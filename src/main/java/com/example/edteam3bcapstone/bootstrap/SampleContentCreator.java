package com.example.edteam3bcapstone.bootstrap;

import com.example.edteam3bcapstone.base.BaseComponent;
import com.example.edteam3bcapstone.domain.*;
import com.example.edteam3bcapstone.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

@Component
@Profile("generate-person-content")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {
    private final PersonService personService;
    //private final FilmService filmService;
    //private final RatingService ratingService;
    //private final TvShowService tvShowService;
    //private final VideoService videoService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.M.yyyy");
    @Override
    public void run(String... args) throws Exception {



        List<Person> persons = List.of(
                Person.builder().firstname("Samuel").lastname("Jackson").dateOfBirth(simpleDateFormat.parse("01.10.1950")).personCategory(PersonCategory.ACTOR).build(),
                Person.builder().firstname("Al").lastname("Pacino").dateOfBirth(simpleDateFormat.parse("05.05.1940")).personCategory(PersonCategory.ACTOR).build(),
                Person.builder().firstname("Tom").lastname("Cruise").dateOfBirth(simpleDateFormat.parse("15.12.1960")).personCategory(PersonCategory.ACTOR).build(),
                Person.builder().firstname("Natalie").lastname("Portman").dateOfBirth(simpleDateFormat.parse("01.11.1982")).personCategory(PersonCategory.ACTOR).build(),
                Person.builder().firstname("James").lastname("Cameron").dateOfBirth(simpleDateFormat.parse("12.06.1949")).personCategory(PersonCategory.DIRECTOR).build(),
                Person.builder().firstname("Kevin").lastname("Feige").dateOfBirth(simpleDateFormat.parse("18.03.1974")).personCategory(PersonCategory.PRODUCER).build()
        );

        logger.info("Created {} persons.", personService.createAll(persons).size());

    }
}
