package com.example.edteam3bcapstone.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "RATINGS")
@Data
@SequenceGenerator(name = "idGenerator", sequenceName = "RATINGS_SEQ", initialValue = 1, allocationSize = 1)
public class Rating extends BaseModel{

    @Min(value = 0)
    private Integer numberOfVotes;

    @OneToOne(mappedBy = "rating")
    private Video video;

}
