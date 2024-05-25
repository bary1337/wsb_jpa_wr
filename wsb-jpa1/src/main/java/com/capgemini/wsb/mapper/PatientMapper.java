package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class PatientMapper {
    public static PatientTO mapToPatientTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());

        if (patientEntity.getVisits() != null) {
            patientTO.setVisits(patientEntity.getVisits().stream()
                    .map(VisitMapper::mapToVisitTO)
                    .collect(Collectors.toList()));
        }


        if (patientEntity.getAddresses() != null) {
            patientTO.setAddresses(patientEntity.getAddresses().stream()
                    .map(AddressMapper::mapToAddressTO)
                    .collect(Collectors.toList()));
        }

        return patientTO;
    }

    public static PatientEntity mapToPatientEntity(final PatientTO patientTO)
    {
        if(patientTO == null)
        {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());

        if (patientTO.getVisits() != null) {
            patientEntity.setVisits((Set<VisitEntity>) patientTO.getVisits().stream()
                    .map(VisitMapper::mapToVisitEntity)
                    .collect(Collectors.toSet()));
        }


        if (patientTO.getAddresses() != null) {
            patientEntity.setAddresses((Set<AddressEntity>) patientTO.getAddresses().stream()
                    .map(AddressMapper::mapToAddressEntity)
                    .collect(Collectors.toSet()));
        }
        return patientEntity;
    }
}
