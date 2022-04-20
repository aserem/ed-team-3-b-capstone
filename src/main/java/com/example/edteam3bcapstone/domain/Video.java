package com.example.edteam3bcapstone.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "VIDEOS", indexes = {@Index(columnList = "title")})
@SequenceGenerator(name = "idGenerator", sequenceName = "VIDEOS_SEQ", initialValue = 1, allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Video extends BaseModel implements Serializable {

    @NotNull
    @Column(length = 50, nullable = false)
    private String title;

    @NotNull
    @Column(length = 500, nullable = false)
    private String plotSummary;

    @NotNull
    @Min(value = 0)
    @Max(value = 10)
    @Column(length = 2, nullable = false)
    private Integer rating;

    @NotNull
    private VideoCategory videoCategory;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Video_Person",
            joinColumns = { @JoinColumn(name = "video_id") },
            inverseJoinColumns = { @JoinColumn(name = "person_id") }
    )
    Set<Person> persons = new HashSet<>();

}
