package com.example.edteam3bcapstone.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TV_SHOWS")
@SequenceGenerator(name = "idGenerator", sequenceName = "FILMS_SEQ", initialValue = 1, allocationSize = 1)
public class TvShow extends Video {



    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date firstReleaseDate;

    @Min(value = 1)
    private Integer numberOfSeasons;

    @ManyToMany
    @JoinTable(name="videos_people",
            joinColumns = { @JoinColumn(name = "tv_shows_id")},
            inverseJoinColumns = { @JoinColumn(name = "people_id")})
    private Set<Person> people = new HashSet<>();
}