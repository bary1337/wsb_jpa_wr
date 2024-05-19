package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.Dao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    public PatientEntity findByLastName(String lastName) {
        String query = "SELECT u FROM PatientEntity u WHERE u.lastName = :lastName";
        return entityManager.createQuery(query, PatientEntity.class)
                .setParameter("lastName", lastName)
                .getSingleResult();
    }
}
