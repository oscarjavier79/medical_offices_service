package com.mx.offices.dto;

import com.mx.offices.entity.Medic;
import com.mx.offices.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CareDto implements Serializable {
      private static final long serialVersionUID = -1051484621912964604L;

      private Long id;

      @NotNull
      private String patientId;

      @NotNull
      private String medicId;

      @NotNull
      private String medicalOfficeId;

      private Timestamp attentionDate;

      private Integer active;

      private Timestamp createdAt;

      private Timestamp updatedAt;

}
