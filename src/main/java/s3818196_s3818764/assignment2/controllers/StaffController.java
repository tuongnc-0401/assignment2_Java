package s3818196_s3818764.assignment2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s3818196_s3818764.assignment2.models.Staff;
import s3818196_s3818764.assignment2.services.StaffService;

import java.util.List;

@RestController
public class StaffController {
    @Autowired
    private StaffService service;
    @GetMapping("/staff")
    public List<Staff> findAll(){
        return service.getAll();
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<Staff> findById(@PathVariable int id){
        try {
            Staff staff = service.getOne(id);
            return new ResponseEntity<Staff>(staff,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Staff>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/staff")
    public void add(@RequestBody Staff staff){
        service.save(staff);
    }

    @PutMapping("/staff/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Staff staff){
        try {
            Staff existStaff = service.getOne(id);
            if ((staff.getName() != null)){
                existStaff.setName(staff.getName());
            }

            if (staff.getAddress() != null){
                existStaff.setAddress(staff.getAddress());
            }

            if (staff.getEmail() != null){
                existStaff.setEmail(staff.getEmail());
            }

            if (staff.getPhone() != null){
                existStaff.setPhone(staff.getPhone());
            }
            service.save(existStaff);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @DeleteMapping("/staff/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
