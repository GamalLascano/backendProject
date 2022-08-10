package com.gamal.signup.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity(name = "Phone")
@Table(name = "phone")
public class Phones {
    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;
    private long number;
    private int citycode;
    private String countrycode;
}
