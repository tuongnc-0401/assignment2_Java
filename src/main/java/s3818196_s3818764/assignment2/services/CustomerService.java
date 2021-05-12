package s3818196_s3818764.assignment2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s3818196_s3818764.assignment2.models.Customer;
import s3818196_s3818764.assignment2.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository cusRepo;
    //List all Customer service
    public List<Customer> getAll(){
        return cusRepo.findAll();
    }
    //List one Customer service
    public Customer getOne(Integer id){
        return cusRepo.findById(id).get();
    }
    //Add one Customer service
    public void save(Customer customer){
        cusRepo.save(customer);
    }
    //Delete one Customer service
    public void delete(Integer id){
        cusRepo.deleteById(id);
    }


}
