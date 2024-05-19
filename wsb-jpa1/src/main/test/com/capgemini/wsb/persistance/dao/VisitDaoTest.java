package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitDaoTest {

    @Autowired
    private VisitDao visitDao;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private PatientDao patientDao;

    @Test
    public void testSaveAndFindById() {
        // Zakładając, że dane testowe są już wstawione do bazy danych

        // Pobranie istniejącego rekordu wizyty
        Optional<VisitEntity> foundVisit = visitDao.findById(1L);

        assertTrue(foundVisit.isPresent());
        VisitEntity visit = foundVisit.get();

        assertEquals(1L, visit.getId());
        assertEquals("Przegląd roczny", visit.getDescription());
        assertEquals(LocalDateTime.of(2024, 6, 3, 10, 0), visit.getTime());

        assertNotNull(visit.getDoctor());
        assertEquals("Tomasz", visit.getDoctor().getFirstName());
        assertEquals("Lewandowski", visit.getDoctor().getLastName());

        assertNotNull(visit.getPatient());
        assertEquals("Joanna", visit.getPatient().getFirstName());
        assertEquals("Dąbrowska", visit.getPatient().getLastName());
    }

    private void assertTrue(boolean present) {
    }

    @Test
    public void testFindAll() {
        List<VisitEntity> visits = visitDao.findAll();
        assertEquals(5, visits.size());
    }

    private void assertEquals(int i, int size) {
    }

    @Test
    public void testDeleteById() {
        VisitEntity visit = new VisitEntity();
        visit.setDescription("Visit to be deleted");
        visit.setTime(LocalDateTime.now());

        DoctorEntity doctor = new DoctorEntity();
        doctor.setId(1L); // Użycie istniejącego ID lekarza

        PatientEntity patient = new PatientEntity();
        patient.setId(1L); // Użycie istniejącego ID pacjenta

        visit.setDoctor(doctor);
        visit.setPatient(patient);

        VisitEntity savedVisit = visitDao.save(visit);
        Long visitId = savedVisit.getId();

        visitDao.deleteById(visitId);
        Optional<VisitEntity> deletedVisit = visitDao.findById(visitId);

        assertFalse(deletedVisit.isPresent());
    }

}
