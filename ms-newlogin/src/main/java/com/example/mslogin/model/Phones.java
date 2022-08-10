package com.example.mslogin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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
