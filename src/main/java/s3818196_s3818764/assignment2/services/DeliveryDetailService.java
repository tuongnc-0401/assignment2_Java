package s3818196_s3818764.assignment2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s3818196_s3818764.assignment2.models.DeliveryDetail;
import s3818196_s3818764.assignment2.repositories.DeliveryDetailRepository;

import java.util.List;

@Service
public class DeliveryDetailService {
    @Autowired
    private DeliveryDetailRepository deliveryDetailRepository;

    public void save(DeliveryDetail deliveryDetail){
        deliveryDetailRepository.save(deliveryDetail);
    }
    public DeliveryDetail getOne(int id){
        return deliveryDetailRepository.findById(id).get();
    }

    public List<DeliveryDetail> getAll(){
        return deliveryDetailRepository.findAll();
    }

    public void delete(int id){
        deliveryDetailRepository.deleteById(id);
    }

}
