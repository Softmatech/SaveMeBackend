package com.softmatech.save_me.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class UserLoginHistory extends AbstractEntity implements Cloneable{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private String ActionDescription;

    @NotNull
    private LocalTime date_created = LocalTime.now();


}
