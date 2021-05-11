package s3818196_s3818764.assignment2.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;
    private String fax;
    private String email;
    private String contactPerson;
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<ProductOrder> productOrders = new ArrayList<>();

}
