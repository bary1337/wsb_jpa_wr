package com.capgemini.wsb.service;
import com.capgemini.wsb.dto.PatientTO;

public interface PatientService {
    PatientTO findById(Long id);
    boolean deleteById(Long id);
    PatientTO addPatient(PatientTO patientTO) throws Exception;
    PatientTO updatePatient(PatientTO patientTO) throws Exception;
}
