package com.guiservice.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guiservice.util.model.User;

/**
 * TODO nneuhaus This type ...
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
