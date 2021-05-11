package s3818196_s3818764.assignment2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;// dd-MM-YYYY
    @ManyToOne
    @JsonIgnore
    private Staff staff;

    @ManyToOne
    @JsonIgnore
    private Provider provider;
    @OneToMany(mappedBy = "productOrder", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
