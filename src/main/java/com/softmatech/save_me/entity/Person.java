package com.softmatech.save_me.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends AbstractEntity implements Cloneable {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Sexe sexe;

    private String email;

    @NotNull
    private Date birthDate;

    @NotNull
    private String birthPlace;

    @NotNull
    private String adress;

    @NotNull
    private String livingCountry;

    @NotNull
    private String nationalite;

    @NotNull
    private String documentId;

    @NotNull
    private DocumentType documentType;

    private String motherName;

    @NotNull
    private String contactName;

    private String matrimonialStatus;
}
