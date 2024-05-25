package com.capgemini.wsb.persistence.dao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    PatientEntity findByLastName(String lastName);
    List<VisitEntity> findVisitsByPatientId(Long id);
    @Query("SELECT p FROM PatientEntity p WHERE p.isDisabled = :isDisabled")
    List<PatientEntity> findPatientsByIsDisabled(@Param("isDisabled") Boolean isDisabled);

}
