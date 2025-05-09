package com.mx.offices.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
public class CompositeKey implements Serializable {
    private String name;
    private String lastName;

    @Column(name = "birthdate")
    private Date birthdate;
}
