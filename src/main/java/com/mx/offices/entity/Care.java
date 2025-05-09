package com.mx.offices.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name="care")
public class Care implements Serializable {
      private static final long serialVersionUID = -1051484621912964604L;

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "id", unique = true, nullable = false)
      private Long id;

      @Column(name = "patient_id")
      private UUID patientId;

      @Column(name = "medic_id")
      private UUID medicId;

      @Column(name = "medical_office_id")
      private UUID medicalOfficeId;

      @Column(name="attention_date")
      private Timestamp attentionDate;

      @Column(name="active")
      private Integer active;

      @Column(name="created_at", unique = true)
      private Timestamp createdAt;

      @Column(name="updated_at", unique = true)
      private Timestamp updatedAt;

}
