package com.mx.offices.repository;

import com.mx.offices.entity.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicRepository extends JpaRepository<Medic, Long> {
    @Query(nativeQuery =true,value = "SELECT e.* " +
            "FROM medic as e " +
            "WHERE concat(e.name, ' ', e.last_name,  ' ', e.birthdate) IN (:names)" +
            " AND e.status = 1;")
    List<Medic> findByNamesAndLastNameAndBirthdateAndStatus(@Param("names") List<String> names);

    List<Medic> findAllByActive(int status);
}
