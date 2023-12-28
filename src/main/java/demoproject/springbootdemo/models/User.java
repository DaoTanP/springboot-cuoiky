package demoproject.springbootdemo.models;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "NguoiDung")
public class User {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "TenDangNhap", nullable = false)
    private String username;

    @Column(name = "MatKhau", nullable = false)
    private String password;

    @Column(name = "Ten", nullable = false)
    private String firstName;

    @Column(name = "HoDem")
    private String lastName;

    @Column(name = "NgaySinh")
    private Date dateOfBirth;

    @Column(name = "GioiTinh")
    private boolean gender;

    @Column(name = "DiaChi")
    private String address;

    @Column(name = "Email")
    private String email;

    @Column(name = "SoDienThoai")
    private String phoneNumber;

    @Column(name = "AnhDaiDien")
    private String avatar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SoThe", referencedColumnName = "SoThe")
    private LibraryCard libraryCard;

    public User() {

    }

    public void copyInfo(User user) {
        if (user.getFirstName() != null)
            firstName = user.getFirstName();

        if (user.getLastName() != null)
            lastName = user.getLastName();

        if (user.getDateOfBirth() != null)
            dateOfBirth = user.getDateOfBirth();

        gender = user.getGender();

        if (user.getAddress() != null)
            address = user.getAddress();

        if (user.getEmail() != null)
            email = user.getEmail();

        if (user.getPhoneNumber() != null)
            phoneNumber = user.getPhoneNumber();

        if (user.getAvatar() != null)
            avatar = user.getAvatar();

        if (user.getLibraryCard() != null)
            libraryCard = user.getLibraryCard();
    }

    public User(String username, String password, String lastName) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setLibraryCard(LibraryCard card) {
        this.libraryCard = card;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

}