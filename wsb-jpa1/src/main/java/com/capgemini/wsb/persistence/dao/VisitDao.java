package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.Optional;

public interface VisitDao extends Dao<VisitEntity, Long>{
    Optional<VisitEntity> findById(Long id);

    void deleteById(Long visitId);
}
