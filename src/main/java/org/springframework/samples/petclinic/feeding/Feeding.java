package org.springframework.samples.petclinic.feeding;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="feedings")
public class Feeding extends BaseEntity {
    Integer id;

    @NotNull
    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    LocalDate startDate;

    @Min(1)
    @Column(name = "weeks_duration")
    double weeksDuration;

    @OneToOne
    @NotNull
    @ManyToOne
    Pet pet;

    @ManyToOne
    FeedingType feedingType;
}
