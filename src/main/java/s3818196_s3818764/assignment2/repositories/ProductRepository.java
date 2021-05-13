package s3818196_s3818764.assignment2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import s3818196_s3818764.assignment2.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
