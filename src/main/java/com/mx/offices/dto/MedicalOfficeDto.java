package com.mx.offices.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class MedicalOfficeDto implements Serializable {
      private static final long serialVersionUID = -1051484621912964604L;

      private Long id;

      private UUID medicalOfficeId;

      private Integer number;

      private Integer floor;

      private Integer active;

      private Timestamp createdAt;

      private Timestamp updatedAt;

}
