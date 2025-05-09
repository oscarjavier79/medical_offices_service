package com.mx.offices.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class MedicRemoveDto {

    @NonNull
    private String name;

    private String middleNme;

    @NonNull
    private String lastName;

    private String secondLastName;

    private int age;

    private String gender;

    @NonNull
    private String birthdate;

    private String position;

    private int status = 0;

    public MedicRemoveDto(){

    }

    public MedicRemoveDto(@NonNull String name, String middleNme, @NonNull String lastName, String secondLastName, int age, String gender, @NonNull String birthdate, String position) {
        this.name = name;
        this.middleNme = middleNme;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.age = age;
        this.gender = gender;
        this.birthdate = birthdate;
        this.position = position;
    }
}
