package com.application.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "visits")
public class Visit extends BaseEntity{

    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "pet_id")
    @ManyToOne
    private Pet pet;

    public LocalDate getDate(){
        return date;
    }

}
