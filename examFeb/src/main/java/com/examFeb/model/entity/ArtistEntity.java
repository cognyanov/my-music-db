package com.examFeb.model.entity;

import com.examFeb.model.entity.enums.SingerEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "artists")
public class ArtistEntity extends BaseEntity{

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private SingerEnum name;

    @Column(name = "career_information", columnDefinition = "text")
    private String careerInformation;

    public ArtistEntity() {
    }

    public SingerEnum getName() {
        return name;
    }

    public void setName(SingerEnum name) {
        this.name = name;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
