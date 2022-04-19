package com.example.edteam3bcapstone.bootstrap;

import com.example.edteam3bcapstone.base.BaseComponent;
import com.example.edteam3bcapstone.domain.*;
import com.example.edteam3bcapstone.service.FilmService;
import com.example.edteam3bcapstone.service.PersonService;
import com.example.edteam3bcapstone.service.TvShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Profile("generate-person-content")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {
    private final PersonService personService;
    private final FilmService filmService;
    private final TvShowService tvShowService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.M.yyyy");
    @Override
    public void run(String... args) throws Exception {

        Person person = Person.builder().firstname("Samuel").lastname("Jackson").dateOfBirth(simpleDateFormat.parse("01.10.1950")).personCategory(PersonCategory.ACTOR).build();
        Set<Person> personSet = new HashSet<>();
        personSet.add(person);

        List<Film> films = List.of(
                Film.builder().title("The Avengers").plotSummary("MCU movie").videoCategory(VideoCategory.FANTASY).rating(8).releaseDate(simpleDateFormat.parse("01.10.2019")).build(),
                Film.builder().title("Scarface").plotSummary("Gangster movie").videoCategory(VideoCategory.DRAMA).rating(9).releaseDate(simpleDateFormat.parse("10.11.1975")).build(),
                Film.builder().title("Top Gun").plotSummary("Air fights movie").videoCategory(VideoCategory.ACTION).rating(9).releaseDate(simpleDateFormat.parse("10.11.1986")).build()
        );

        logger.info("Created {} films.", filmService.createAll(films).size());

        List<TvShow> tvShows = List.of(
                TvShow.builder().title("Walking Dead").plotSummary("Zombie tv series").videoCategory(VideoCategory.HORROR).rating(5).firstReleaseDate(simpleDateFormat.parse("01.10.2005")).numberOfSeasons(11).build(),
                TvShow.builder().title("Breaking Bad").plotSummary("Drug trafficing tv series").videoCategory(VideoCategory.THRILLER).rating(6).firstReleaseDate(simpleDateFormat.parse("07.09.2010")).numberOfSeasons(1).build(),
                TvShow.builder().title("Outlander").plotSummary("Romance tv series").videoCategory(VideoCategory.ROMANCE).rating(3).firstReleaseDate(simpleDateFormat.parse("12.12.2013")).numberOfSeasons(6).build()
        );

        logger.info("Created {} tvShows.", tvShowService.createAll(tvShows).size());

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
