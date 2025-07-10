package com.rajkumarv.sandbox.repository;

import com.rajkumarv.sandbox.model.Person;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ListCrudRepository<Person, Long> {
}

