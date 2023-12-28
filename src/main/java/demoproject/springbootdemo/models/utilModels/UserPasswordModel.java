package demoproject.springbootdemo.models.utilModels;

import demoproject.springbootdemo.models.User;

public class UserPasswordModel extends User {
    private String oldPassword;

    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
