package s3818196_s3818764.assignment2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DeliveryNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;

    @ManyToOne
    @JsonIgnore
    private Staff staff;
    @OneToMany(mappedBy = "deliveryNote", cascade = CascadeType.ALL)
    private List<DeliveryDetail> deliveryDetails= new ArrayList<>();
}
