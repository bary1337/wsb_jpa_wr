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

    @Transactional
    @Test
    void testShouldRemoveVisitsWhenPatientWasDeleted() {
        // Given
        final Long patientId = 1L;
        PatientTO patient = patientService.findById(patientId);
        List<VisitTO> patientVisits = patient.getVisits();
        Long firstVisitIdAssignedToPatient = patientVisits.get(0).getId();

        // When
        patientService.deleteById(patientId);

        // Then
        VisitService visitService = null;
        VisitTO visitDto = visitService.getVisitById(firstVisitIdAssignedToPatient);
        assertNull(visitDto);
    }
}
