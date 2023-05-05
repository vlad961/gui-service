package com.guiservice.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * TODO nneuhaus This type ...
 *
 */
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  private String email;

  public User() {

  }

  /**
   * The constructor.
   *
   * @param firstName
   * @param lastName
   * @param email
   */
  public User(String firstName, String lastName, String email) {

    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * @return id
   */
  public long getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getid}.
   */
  public void setId(long id) {

    this.id = id;
  }

  /**
   * @return firstName
   */
  public String getFirstName() {

    return this.firstName;
  }

  /**
   * @param firstName new value of {@link #getfirstName}.
   */
  public void setFirstName(String firstName) {

    this.firstName = firstName;
  }

  /**
   * @return lastName
   */
  public String getLastName() {

    return this.lastName;
  }

  /**
   * @param lastName new value of {@link #getlastName}.
   */
  public void setLastName(String lastName) {

    this.lastName = lastName;
  }

  /**
   * @return email
   */
  public String getEmail() {

    return this.email;
  }

  /**
   * @param email new value of {@link #getemail}.
   */
  public void setEmail(String email) {

    this.email = email;
  }

}
