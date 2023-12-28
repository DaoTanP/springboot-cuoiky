package demoproject.springbootdemo.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TrangThaiMuonSach")
public class BorrowStatus {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "TrangThaiMuon")
    private String status;

    @OneToMany(mappedBy = "status")
    private Set<BorrowInfo> borrowInfos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
