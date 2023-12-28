package demoproject.springbootdemo.controllers;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demoproject.springbootdemo.models.LibraryCard;
import demoproject.springbootdemo.models.User;
import demoproject.springbootdemo.models.UserBuilder;
import demoproject.springbootdemo.models.utilModels.UserLibraryCardModel;
import demoproject.springbootdemo.models.utilModels.UserPasswordModel;
import demoproject.springbootdemo.repositories.LibraryCardRepository;
import demoproject.springbootdemo.repositories.UserRepository;
import demoproject.springbootdemo.services.JwtService;

@Controller
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    @Autowired
    private JwtService authService;

    @GetMapping(path = "")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping(path = "")
    public ResponseEntity<String> updateUser(@ModelAttribute User userToUpdate) {
        User user = userRepository.findByUsername(userToUpdate.getUsername());

        if (user != null) {
            user.copyInfo(userToUpdate);
            userRepository.save(user);
            return ResponseEntity.ok("Updated user " + userToUpdate.getUsername());
        }

        return ResponseEntity.status(404).body("Could not find user " + userToUpdate.getUsername());
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody User getUser(@PathVariable("id") String id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            User u = user.get();
            u.setPassword("");
            return u;
        }

        return null;
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody ResponseEntity<String> deleteUser(@ModelAttribute User userToDelete) {
        User user = userRepository.findByUsername(userToDelete.getUsername());

        if (user != null) {
            if (user.getPassword() != userToDelete.getPassword())
                return ResponseEntity.status(500).body("Wrong password");

            userRepository.deleteById(user.getId());
            return ResponseEntity.ok("Deleted user " + user.getUsername());
        }

        return ResponseEntity.status(404).body("Could not find user " + userToDelete.getUsername());
    }

    @PostMapping(path = "/changePassword")
    public @ResponseBody ResponseEntity<String> changePassword(@RequestBody UserPasswordModel passwordModel) {
        User user = userRepository.findByUsername(passwordModel.getUsername());

        if (user != null) {
            if (user.getPassword().equals(passwordModel.getOldPassword()))
                return ResponseEntity.status(500).body("Wrong password");

            user.setPassword(passwordModel.getNewPassword());

            userRepository.save(user);
            return ResponseEntity.ok("Password is changed for user " + user.getUsername());
        }

        return ResponseEntity.status(404).body("Could not find user " + passwordModel.getUsername());
    }

    @PostMapping(path = "/libraryCard")
    public @ResponseBody ResponseEntity<String> linkLibraryCard(@RequestBody UserLibraryCardModel u) {
        User user = userRepository.findByUsername(u.getUsername());

        if (user != null) {
            Optional<LibraryCard> card = libraryCardRepository.findById(u.getCardNumber());

            if (card.isPresent()) {
                user.setLibraryCard(card.get());
            }
            userRepository.save(user);
            return ResponseEntity.ok("Card number updated for user " + user.getUsername());
        }

        return ResponseEntity.status(404).body("Could not find user " + u.getUsername());
    }

    @PostMapping(path = "/usernameExists")
    public @ResponseBody ResponseEntity<Boolean> usernameExists(@RequestBody User u) {
        User user = userRepository.findByUsername(u.getUsername());

        if (user != null)
            return ResponseEntity.ok(true);

        return ResponseEntity.ok(false);
    }

    // @PostMapping(path = "/login")
    // public ResponseEntity<Object> login(@RequestParam String username,
    // @RequestParam String password) {
    // User user = userRepository.findByUsername(username);
    // if (user == null)
    // return ResponseEntity.status(404).body("User not found");
    // else if (!user.getPassword().equals(password))
    // return ResponseEntity.status(500).body("Wrong password");
    // // HttpHeaders responseHeaders = new HttpHeaders();
    // // responseHeaders.set("token", authService.generateToken(user));
    // // return ResponseEntity.ok()
    // // .headers(responseHeaders)
    // // .body("Logged in successfully");
    // HashMap<String, String> body = new HashMap<String, String>();
    // body.put("token", authService.generateToken(user));
    // body.put("id", user.getId());
    // return ResponseEntity.ok().body(body);
    // }

    @PostMapping(path = "/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        User u = userRepository.findByUsername(user.getUsername());
        if (u == null)
            return ResponseEntity.status(404).body("User not found");
        else if (!u.getPassword().equals(user.getPassword()))
            return ResponseEntity.status(500).body("Wrong password");

        HashMap<String, String> body = new HashMap<String, String>();
        body.put("token", authService.generateToken(u));
        body.put("id", u.getId());

        return ResponseEntity.ok().body(body);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Object> register(@RequestBody User user) {
        User u = userRepository.findByUsername(user.getUsername());
        if (u != null)
            return ResponseEntity.status(409).body("User exists");
        if (user.getPassword() == null || user.getFirstName() == null)
            return ResponseEntity.status(400).body("Invalid information");

        String id = UUID.randomUUID().toString();
        while (userRepository.findById(id).isPresent()) {
            id = UUID.randomUUID().toString();
        }

        UserBuilder userBuilder = new UserBuilder();
        User newUser = userBuilder.id(id)
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .build();

        User result = userRepository.save(newUser);

        HashMap<String, String> body = new HashMap<String, String>();
        body.put("token", authService.generateToken(result));
        body.put("id", result.getId());

        return ResponseEntity.ok().body(body);
    }
}