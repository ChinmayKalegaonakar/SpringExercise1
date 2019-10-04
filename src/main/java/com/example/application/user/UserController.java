package com.example.application.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class UserController {
  @Autowired
  private UserRepository userRepository;
  @GetMapping("/")
  public String landing(Model model){
    User dummy = new User("chinmay","male",22);
    List<User> users = userRepository.findAll();
    model.addAttribute("users",users);
    return "landing";
  }
  @PostMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public void addUser(@RequestBody User user){
    userRepository.save(user);
  }
}
