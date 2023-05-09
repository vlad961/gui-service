package com.guiservice.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guiservice.springboot.model.FigmaProject;

@Repository
public interface FigmaRepository extends CrudRepository<FigmaProject, Long> {
    
}
