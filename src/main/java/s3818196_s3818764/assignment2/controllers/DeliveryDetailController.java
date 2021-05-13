package s3818196_s3818764.assignment2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import s3818196_s3818764.assignment2.models.DeliveryDetail;
import s3818196_s3818764.assignment2.services.DeliveryDetailService;

import java.util.List;

@RestController
public class DeliveryDetailController {
    @Autowired
    private DeliveryDetailService detailService;
    @GetMapping("/deliveryDetail")
    public List<DeliveryDetail> getAll(){
        return detailService.getAll();
    }
    @GetMapping("/deliveryDetail/{id}")
    private DeliveryDetail getOne(@PathVariable int id){
        return detailService.getOne(id);
    }

    @PostMapping("/deliveryDetail")
    private void save(@RequestBody DeliveryDetail deliveryDetail){
        detailService.save(deliveryDetail);
    }

    @DeleteMapping("/deliveryDetail/{id}")
    private void delete(@PathVariable int id){
        detailService.delete(id);
    }

    @PutMapping("/deliveryDetail/{id}")
    private void update(@PathVariable int id, @RequestBody DeliveryDetail deliveryDetail){
        DeliveryDetail existDetail = detailService.getOne(id);
        existDetail.setProduct(deliveryDetail.getProduct());
        existDetail.setQuantity(deliveryDetail.getQuantity());
        detailService.save(existDetail);
    }
}
