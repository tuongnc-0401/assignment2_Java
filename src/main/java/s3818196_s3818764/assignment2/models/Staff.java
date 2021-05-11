package s3818196_s3818764.assignment2.models;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<ProductOrder> productOrders = new ArrayList<>();

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<ReceivingNote> receivingNotes = new ArrayList<>();

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<DeliveryNote> deliveryNotes = new ArrayList<>();

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<SaleInvoice> saleInvoices = new ArrayList<>();
}
