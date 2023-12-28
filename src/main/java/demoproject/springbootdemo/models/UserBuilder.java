package demoproject.springbootdemo.models;

import java.sql.Date;

public class UserBuilder {
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private boolean gender;
    private String address;
    private String email;
    private String phoneNumber;
    private String avatar;
    private LibraryCard libraryCard;

    public UserBuilder id(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder username(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder dateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public UserBuilder gender(boolean gender) {
        this.gender = gender;
        return this;
    }

    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserBuilder avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public UserBuilder libraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
        return this;
    }

    public User build() {
        User user = new User(username, password, lastName);
        user.setId(id);
        user.setFirstName(firstName);
        user.setDateOfBirth(dateOfBirth);
        user.setGender(gender);
        user.setAddress(address);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAvatar(avatar);
        user.setLibraryCard(libraryCard);

        return user;
    }
}
