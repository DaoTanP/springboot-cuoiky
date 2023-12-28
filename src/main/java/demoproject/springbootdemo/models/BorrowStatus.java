package demoproject.springbootdemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TrangThaiMuonSach")
public class BorrowStatus {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "TrangThaiMuon")
    private String status;
}
