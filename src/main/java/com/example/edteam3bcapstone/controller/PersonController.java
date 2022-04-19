package com.example.edteam3bcapstone.controller;


import com.example.edteam3bcapstone.domain.Person;
import com.example.edteam3bcapstone.service.BaseService;
import com.example.edteam3bcapstone.service.PersonService;
import com.example.edteam3bcapstone.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController extends AbstractController<Person> {
    private final PersonService personService;

    @GetMapping(params={"lastname"})
    public ResponseEntity<ApiResponse<Person>> findByLastname(@RequestParam String lastname){
        return ResponseEntity.ok(ApiResponse.<Person>builder().data(personService.findByLastname(lastname)).build());
    }

    @Override
    protected BaseService<Person, Long> getBaseService() {
        return personService;
    }



}