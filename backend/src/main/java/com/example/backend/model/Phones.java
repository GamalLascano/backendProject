package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Phones {
    @JsonIgnore
    private long id;
    private long number;
    private int citycode;
    private String countrycode;
}
