package com.example.Bms.Controller;

import com.example.Bms.Entity.User;
import com.example.Bms.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public User registerUser(@Valid @RequestBody User user) {
        return userService.uploadUser(user);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser() {
        List<User> user = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    @PostMapping("/bulkUser")
    public List<User> bulkUpload(@RequestParam("file") MultipartFile file) throws IOException {
        List<User> userList = userService.blukUser(file);
        return userList;
    }

    @PostMapping("/addPhone")
    public ResponseEntity<?> getPhone(@Valid @RequestBody User user) {
        List<User> byPhone = userService.findByPhone(user.getPhone());
        if (!byPhone.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mobile number is already exist");
        }else {
            userService.uploadUser(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("successfully saved");
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Integer id) {
       Optional<User> user=userService.getById(id);
       if (!user.isPresent()){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter a vaild ID");
       }
       return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        Optional<User> get = userService.getById(id);
        if (get.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(id + " this id is invalid");
        }
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(" ID " + id + " was deleted successfully ");
    }
    @GetMapping("/getid/{id}")
    public ResponseEntity<?> getById(@PathVariable ("id")User user){
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }
}


