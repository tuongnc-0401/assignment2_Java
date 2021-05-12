package s3818196_s3818764.assignment2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s3818196_s3818764.assignment2.models.DeliveryNote;
import s3818196_s3818764.assignment2.models.Staff;
import s3818196_s3818764.assignment2.services.DeliveryNoteService;
import s3818196_s3818764.assignment2.services.StaffService;

import java.util.List;

@RestController
public class DeliveryNoteController {
    @Autowired
    private DeliveryNoteService service;
    @Autowired
    private StaffService staffService;
    @GetMapping("/deliveryNote")
    public List<DeliveryNote> getAll(){
        return service.getAll();
    }
    @PostMapping("/deliveryNote")
    public ResponseEntity<String> add(@RequestBody DeliveryNote deliveryNote){

        try{
            int id = deliveryNote.getStaff().getId();
            staffService.getOne(id);
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
    public DeliveryNote getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @DeleteMapping("/deliveryNote/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
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
}
