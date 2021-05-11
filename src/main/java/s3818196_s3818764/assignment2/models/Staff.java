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

    public Staff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public List<ReceivingNote> getReceivingNotes() {
        return receivingNotes;
    }

    public void setReceivingNotes(List<ReceivingNote> receivingNotes) {
        this.receivingNotes = receivingNotes;
    }

    public List<DeliveryNote> getDeliveryNotes() {
        return deliveryNotes;
    }

    public void setDeliveryNotes(List<DeliveryNote> deliveryNotes) {
        this.deliveryNotes = deliveryNotes;
    }

    public List<SaleInvoice> getSaleInvoices() {
        return saleInvoices;
    }

    public void setSaleInvoices(List<SaleInvoice> saleInvoices) {
        this.saleInvoices = saleInvoices;
    }
}
