package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    private final DoctorDao doctorDao;
    @Autowired
    public DoctorServiceImpl(DoctorDao doctorDao) {this.doctorDao = doctorDao;}
    @Override
    public DoctorTO findById(Long id) {
        final DoctorEntity doctor = doctorDao.findOne(id);
        return DoctorMapper.mapToDoctorTO(doctor);
    }
}
