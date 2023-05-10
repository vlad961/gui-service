package com.guiservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guiservice.util.model.User;
import com.guiservice.util.repository.UserRepository;

@SpringBootApplication
public class GuiServiceBackendApplication implements CommandLineRunner {

  public static void main(String[] args) {

    SpringApplication.run(GuiServiceBackendApplication.class, args);
  }

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {

    this.userRepository.save(new User("Nils", "Neuhäusel", "nils.neuhaeusel@capgemini.com"));
    this.userRepository.save(new User("Nicolas", "van Bellen", "nicolas.vanbellen@capgemini.com"));
    this.userRepository.save(new User("Aleksander", "Kostic", "aleksander.kostic@capgemini.com"));
    this.userRepository.save(new User("Vladislav", "Sehtman", "vladislav.sehtman@capgemini.com"));
    this.userRepository.save(new User("Tobias", "Büttgen", "tobias.büttgen@capgemini.com"));

  }

}
