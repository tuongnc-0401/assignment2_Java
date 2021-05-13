package s3818196_s3818764.assignment2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s3818196_s3818764.assignment2.models.Product;
import s3818196_s3818764.assignment2.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

     public boolean checkProduct(int id){
        List<Product> productList = productRepository.findAll();
        for (Product p: productList) {
            if (p.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Product getOne(int id){
         return productRepository.findById(id).get();
    }

}
