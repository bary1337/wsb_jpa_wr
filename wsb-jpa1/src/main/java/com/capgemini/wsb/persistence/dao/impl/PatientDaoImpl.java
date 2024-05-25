package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public abstract class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public PatientEntity findByLastName(String lastName) {
        String query = "SELECT u FROM PatientEntity u WHERE u.lastName = :lastName";
        return entityManager.createQuery(query, PatientEntity.class)
                .setParameter("lastName", lastName)
                .getSingleResult();
    }

    @Override
    public List<PatientEntity> findPatientsByIsDisabled(Boolean disability) {
        String query = "SELECT u FROM PatientEntity u WHERE u.disability = :disabiity";
        return entityManager.createQuery(query, PatientEntity.class)
                .setParameter("disability", disability)
                .getResultList();
    }

    @Override
    public List<VisitEntity> findVisitsByPatientId(Long id) {
        return entityManager.createQuery("SELECT v FROM VisitEntity v WHERE v.patient.id = :id", VisitEntity.class)
                .setParameter("id", id)
                .getResultList();
    }
}
