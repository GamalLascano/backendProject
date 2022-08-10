package com.gamal.signup.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "user")
@Getter
@Setter
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,columnDefinition = "BINARY(16)")
    private UUID id;

    private Timestamp created;

    private Timestamp lastLogin;

    private String token;

    private Boolean isActive;

    private String name;

    private String email;
    @JsonIgnore
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phones> phones;
    public UserEntity(UserRequest request){
        this.email = request.getEmail();
        this.name = request.getName();
        this.password =request.getPassword();
        this.phones = request.getPhones();
        this.lastLogin = Timestamp.from(Instant.now());
        this.token = "TokenAqui123";
        this.created = Timestamp.from(Instant.now());
        this.isActive = true;
    }

    public UserEntity() {

    }
}
