package com.guiservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guiservice.model.User;

/**
 * TODO nneuhaus This type ...
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
