package com.example.edteam3bcapstone.service;

import com.example.edteam3bcapstone.domain.Person;
import com.example.edteam3bcapstone.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }


    @Override
    public Person findByLastname(String lastname) {
        return personRepository.findByLastname(lastname);
    }
}
