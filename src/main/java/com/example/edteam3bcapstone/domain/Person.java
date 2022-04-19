package com.example.edteam3bcapstone.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "idGenerator", sequenceName = "PERSON_SEQ", initialValue = 1, allocationSize = 1)

public class Person extends BaseModel{

    @NotNull
    @Column(length = 30, nullable = false)
    private String firstname;

    @NotNull
    @Column(length = 50, nullable = false)
    private String lastname;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private PersonCategory personCategory;

    @ManyToMany(mappedBy = "people")
    private Set<Video> videos = new HashSet<>();
}