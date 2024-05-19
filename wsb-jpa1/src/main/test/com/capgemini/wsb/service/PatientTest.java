package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private VisitService visitService;
    @Autowired
    private DoctorService doctorService;

    @Transactional
    @Test
    void testShouldReturnPatientWhenIdWasPassed() {
        // Given
        final Long patientId = 1L;

        // When
        PatientTO patient = patientService.findById(patientId);

        // Then
        assertEquals("Joanna", patient.getFirstName());
    }

    @Test
    public void testNoArgsConstructor() {
        PatientTO patient = new PatientTO();
        assertNull(patient.getId());
        assertNull(patient.getFirstName());
        assertNull(patient.getLastName());
        assertNull(patient.getTelephoneNumber());
        assertNull(patient.getEmail());
        assertNull(patient.getPatientNumber());
        assertNull(patient.getDateOfBirth());
        assertNull(patient.getAddress());
        assertNull(patient.getVisits());
    }

}
