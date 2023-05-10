package com.guiservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guiservice.repository.UserRepository;
import com.guiservice.model.User;

/**
 * TODO nneuhaus This type ...
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("test/")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("users")
  public List<User> getUsers() {

    return this.userRepository.findAll();
  }
}
