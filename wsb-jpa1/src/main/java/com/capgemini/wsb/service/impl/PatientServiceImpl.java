package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity patientEntity = patientDao.findOne(id);
        return PatientMapper.mapToPatientTO(patientEntity);
    }

    @Override
    public boolean deleteById(Long id) {
        PatientEntity patient = patientDao.findOne(id);
        if (patient != null) {
            patientDao.delete(patient);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public PatientTO addPatient(PatientTO patientTO) throws Exception {
        if (patientTO == null) {
            throw new Exception("Patient cannot be null");
        }
        PatientEntity patientEntity = PatientMapper.mapToPatientEntity(patientTO);
        patientDao.save(patientEntity);
        return patientTO;
    }

    @Override
    public PatientTO updatePatient(PatientTO patientTO) {
        PatientEntity existingPatientEntity = patientDao.findOne(patientTO.getId());
        if (existingPatientEntity != null) {
            PatientEntity updatedPatientEntity = PatientMapper.mapToPatientEntity(patientTO);
            patientDao.update(updatedPatientEntity);
        }
        return patientTO;
    }

}
