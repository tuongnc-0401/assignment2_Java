package s3818196_s3818764.assignment2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import s3818196_s3818764.assignment2.models.Customer;
import s3818196_s3818764.assignment2.services.CustomerService;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService cusService;
    //Get All Customer
    @GetMapping("/customer")
    public List<Customer> getAll(){
        return cusService.getAll();
    }
    //Get One Customer
    @GetMapping("/customer/{id}")
    public Customer getOne(@PathVariable Integer id){
        return cusService.getOne(id);
    }
    // Add One Customer
    @PostMapping("/customer")
    public void save(@RequestBody Customer customer){
        cusService.save(customer);
    }
    // Update One Customer
    @PutMapping("/customer/{id}")
    public void update(@PathVariable Integer id, @RequestBody Customer customer){
        Customer existCustomer = cusService.getOne(id);
        if (customer.getName() != null) {
            existCustomer.setName(customer.getName());
        }
        if (customer.getAddress() != null) {
            existCustomer.setAddress(customer.getAddress());
        }
        if (customer.getEmail() != null){
            existCustomer.setEmail(customer.getEmail());
        }
        if (customer.getPhone() != null){
            existCustomer.setPhone(customer.getPhone());
        }
        if (customer.getFax() != null){
            existCustomer.setFax(customer.getFax());
        }
        if (customer.getContactPerson() != null){
            existCustomer.setContactPerson(customer.getContactPerson());
        }
        cusService.save(existCustomer);

    }
    //Delete One Customer
    @DeleteMapping("/customer/{id}")
    public void delete(@PathVariable Integer id){
        cusService.delete(id);
    }
}
