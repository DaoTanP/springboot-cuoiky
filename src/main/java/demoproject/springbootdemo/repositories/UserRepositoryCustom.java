package demoproject.springbootdemo.repositories;

import demoproject.springbootdemo.models.User;

public interface UserRepositoryCustom {
    public User findByEmail(String email);

    public User findByUsername(String username);

    public boolean validateUser(User user);
}