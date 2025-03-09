package com.softmatech.save_me.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity implements Cloneable{

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @NotNull
    private String userName;

    @NotNull
    private String passwordHash;

    @NotNull
    private LocalTime dateJoined = LocalTime.now();

    private String profilPictureUrl;

    public User(Person person, String userName, String passwordHash, String profilPictureUrl) {
        this.person = person;
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.profilPictureUrl = profilPictureUrl;
    }
}
