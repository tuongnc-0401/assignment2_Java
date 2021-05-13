package s3818196_s3818764.assignment2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s3818196_s3818764.assignment2.models.DeliveryNote;
import s3818196_s3818764.assignment2.repositories.DeliveryNoteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryNoteService {
    @Autowired
    private DeliveryNoteRepository repository;

    public List<DeliveryNote> getAll(){
        return repository.findAll();
    }

    public DeliveryNote getOne(int id){
        return repository.findById(id).get();
    }

    public void save(DeliveryNote deliveryNote){
        repository.save(deliveryNote);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public List<DeliveryNote> findAllDeliveryNoteByStaffId(int id){
        List<DeliveryNote> notes = new ArrayList<>();
        for( DeliveryNote r : repository.findAll()){
            if( r.getStaff().getId() == id){
                notes.add(r);
            }
        }
        return notes;
    }
}
