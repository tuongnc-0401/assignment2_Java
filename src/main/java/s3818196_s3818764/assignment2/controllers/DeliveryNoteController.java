package s3818196_s3818764.assignment2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s3818196_s3818764.assignment2.models.DeliveryDetail;
import s3818196_s3818764.assignment2.models.DeliveryNote;
import s3818196_s3818764.assignment2.models.Staff;
import s3818196_s3818764.assignment2.services.DeliveryNoteService;
import s3818196_s3818764.assignment2.services.ProductService;
import s3818196_s3818764.assignment2.services.StaffService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class DeliveryNoteController {
    @Autowired
    private DeliveryNoteService service;
    @Autowired
    private StaffService staffService;
    @Autowired
    private ProductService productService;
    @GetMapping("/deliveryNote")
    public List<DeliveryNote> getAll(){
        return service.getAll();
    }
    @PostMapping("/deliveryNote")
    public ResponseEntity<String> add(@RequestBody DeliveryNote deliveryNote){

        try{
            int id = deliveryNote.getStaff().getId();
            staffService.getOne(id);

            List<DeliveryDetail> deliveryDetails = deliveryNote.getDetails();
            if (deliveryDetails.size()>0){
                for (DeliveryDetail detail: deliveryDetails) {
                    if (productService.checkProduct(detail.getProduct().getId()) == false){
                        return new ResponseEntity<String>("Cannot find these products",
                                HttpStatus.NOT_FOUND);
                    }
                }
            }
            service.save(deliveryNote);
            return new ResponseEntity<String>("Add Delivery Note successfully!", HttpStatus.OK);
        }
        catch (NullPointerException e) {
            return new ResponseEntity<String>("Can not insert a Delivery note without a staff",
                    HttpStatus.BAD_REQUEST);
        }catch( Exception e){
            int id = deliveryNote.getStaff().getId();
            return new ResponseEntity<String>("Can not find this staff with id = "+ id , HttpStatus.NOT_FOUND );
        }

    }
    @GetMapping("/deliveryNote/{id}")
    public ResponseEntity<DeliveryNote> getOne(@PathVariable int id){
        try {
            DeliveryNote deliveryNote = service.getOne(id);
            return new ResponseEntity<DeliveryNote>(deliveryNote,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<DeliveryNote>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deliveryNote/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
    @GetMapping("/deliveryNote/ByStaffId/{id}")
    public List<DeliveryNote> findAllDeliveryNoteByStaffId(@PathVariable int id){
        return service.findAllDeliveryNoteByStaffId(id);
    }

    @PutMapping("/deliveryNote/{id}")
    public ResponseEntity<String> update(@PathVariable int id,
                                       @RequestBody DeliveryNote deliveryNote){
        try {
            DeliveryNote existNote = service.getOne(id);
            if (deliveryNote.getDate() != null ){
                existNote.setDate(deliveryNote.getDate());
                service.save(existNote);
                return new ResponseEntity<String>("Update this delivery note successfully!",
                        HttpStatus.OK);
            } else  {
                return new ResponseEntity<String>("Date can not be NULL!",HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return new ResponseEntity<String>("Can not find delivery note with id = "+id,
                    HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/deliveryNote/{noteId}/{staffId}")
    public ResponseEntity<String> updateStaff(@PathVariable int noteId, @PathVariable int staffId){
        try {
            DeliveryNote existNote = service.getOne(noteId);
            try {
                Staff staff = staffService.getOne(staffId);
                existNote.setStaff(staff);
                service.save(existNote);
                return new ResponseEntity<String>("Update staff in delivery note successfully!",
                        HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                return new ResponseEntity<String>("Update failed! Can not find staff with id = "+ staffId,
                        HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>("Update failed! Can not find delivery note with id " +
                    "= "+noteId,
                    HttpStatus.NOT_FOUND);
        }


    }

}
