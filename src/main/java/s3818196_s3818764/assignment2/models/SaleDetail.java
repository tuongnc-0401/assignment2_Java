package s3818196_s3818764.assignment2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonIgnore
    private Product product;
    private double price;
    private double totalValue;

    @ManyToOne
    @JsonIgnore
    private SaleInvoice saleInvoice;
}
