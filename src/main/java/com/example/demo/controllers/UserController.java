package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
@Autowired
    UserRepository userRepository;

//    @PostMapping("/user")
//    public ResponseEntity addUser(@RequestBody User user) {
//        userRepository.save(user);
//        return new ResponseEntity(HttpStatus.OK);
//    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User userDetails) {
        User user = userRepository.findByLogin(userDetails.getLogin());
        if(user != null && user.getPassword().equals(userDetails.getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("such user doesn't exist");
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return  new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String addUser(@RequestParam String login, @RequestParam String name, @RequestParam String surname, @RequestParam String password,@RequestParam String email) {
        User user = new User(login,name,surname,password,email);
        userRepository.save(user);
        return user.getLogin();
    }

}
