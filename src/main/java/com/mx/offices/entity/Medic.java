package com.mx.offices.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name="medic")
public class Medic implements Serializable {
      private static final long serialVersionUID = -1051484621912964604L;

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="id", unique = true, nullable = false)
      private Long id;

      @Column(name = "medic_id")
      private UUID medicId;

      @Column(name="name")
      private String name;

      @Column(name="last_name")
      private String lastName;

      @Column(name="second_last_name")
      private String secondLastName;

      @Column(name="specialty")
      private String specialty;

      @Column(name="active")
      private Integer active;

      @Column(name="created_at", unique = true)
      private Timestamp createdAt;

      @Column(name="updated_at", unique = true)
      private Timestamp updatedAt;

}
