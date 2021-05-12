package s3818196_s3818764.assignment2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s3818196_s3818764.assignment2.models.Staff;
import s3818196_s3818764.assignment2.repositories.StaffRepository;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public void save(Staff staff){
        staffRepository.save(staff);
    }

    public Staff getOne(int id){
        return staffRepository.findById(id).get();
    }

    public List<Staff> getAll(){
        return staffRepository.findAll();
    }

    public void delete(int id){
        staffRepository.deleteById(id);
    }
}
