package com.guiservice.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiservice.springboot.model.User;
import com.guiservice.springboot.repository.UserRepository;

/**
 * TODO nneuhaus This type ...
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("users")
  public List<User> getUsers() {

    return this.userRepository.findAll();
  }
}
