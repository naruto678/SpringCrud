package com.example.CrudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CrudDemo.entity.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

}
