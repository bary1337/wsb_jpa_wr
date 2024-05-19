package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {
    private final VisitDao visitDao;
    @Autowired
    public VisitServiceImpl(VisitDao visitDao) { this.visitDao = visitDao;}


    @Override
    public VisitTO getVisitById(Long id) {
        VisitEntity visitEntity = visitDao.findOne(id);
        return VisitMapper.mapToVisitTO(visitEntity);
    }

    @Override
    public List<VisitTO> getAllVisits() {
        return null;
    }
}
