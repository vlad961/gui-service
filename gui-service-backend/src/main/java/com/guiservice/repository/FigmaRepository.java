package com.guiservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guiservice.model.FigmaProject;

@Repository
public interface FigmaRepository extends CrudRepository<FigmaProject, Long> {

    // TODO: Prepare Java Objects for Angular
    
}
