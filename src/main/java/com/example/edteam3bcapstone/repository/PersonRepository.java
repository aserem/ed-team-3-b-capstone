package com.example.edteam3bcapstone.repository;


import com.example.edteam3bcapstone.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    public Person findByLastname(String lastname);
}