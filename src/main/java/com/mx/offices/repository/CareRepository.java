package com.mx.offices.repository;

import com.mx.offices.entity.Care;
import com.mx.offices.entity.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareRepository extends JpaRepository<Care, Long> {
    List<Care> findAllByActive(int status);
}
