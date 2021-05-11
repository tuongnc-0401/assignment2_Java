package s3818196_s3818764.assignment2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ReceivingNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    @ManyToOne
    @JsonIgnore
    private Staff staff;
    @OneToMany(mappedBy = "receivingNote", cascade = CascadeType.ALL)
    private List<ReceivingDetail> receivingDetails = new ArrayList<>();

    public ReceivingNote() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<ReceivingDetail> getReceivingDetails() {
        return receivingDetails;
    }

    public void setReceivingDetails(List<ReceivingDetail> receivingDetails) {
        this.receivingDetails = receivingDetails;
    }
}
