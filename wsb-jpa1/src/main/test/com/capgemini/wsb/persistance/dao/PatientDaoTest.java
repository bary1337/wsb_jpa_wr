package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    @Description("Lab3/Zad1 Znajdz pacjentow po nazwisku / DAO")
    public void testShouldReturnPatientWhenPassedLastName()
    {
        //given
        final String lastNameSearchingPatient = "Kamiński";
        final Long expectedPatientId = 2L;
        final String expectedPatientName = "Bartosz";
        //when
        PatientEntity patientEntity = patientDao.findByLastName(lastNameSearchingPatient);
        //then
        assertEquals(expectedPatientId, patientEntity.getId());
        assertEquals(expectedPatientName, patientEntity.getFirstName());
        assertEquals(patientDao.findOne(2L), patientEntity);
    }
    @Transactional
    @Test
    @Description("Lab3/Zad2 Znajdz wszystkie wizyty pacjenta po jego ID / DAO")
    public void testShouldReturnListOfVisitsByPaitentId()
    {
        //given
        Long patientId = 1L;
        //when
        List<VisitEntity> visits = patientDao.findVisitsByPatientId(patientId);
        //then
        assertThat(visits).isNotEmpty();
        assertThat(visits).allMatch(visit -> visit.getPatient().getId().equals(patientId));
    }
    @Transactional
    @Test
    @Description("Lab3/Zad4 Znajdz pacjentow po dodanym przez Ciebie polu - nie wyszukuj wprost po wartosci, uzyj zapytania typu wieksze/mniejsze/pozniej/wczesniej/zawiera, w zaleznosci od wybranego typu zmiennej.")
    public void testShouldReturnListOfDisabledPatients()
    {
        // given
        final Boolean disability = true;
        final int expectedNumberOfPatients = 2;

        // when
        List<PatientEntity> listOfPatients = patientDao.findPatientsByIsDisabled(disability);

        // then
        assertNotNull(listOfPatients);
        assertEquals(expectedNumberOfPatients, listOfPatients.size());
        for (PatientEntity patient : listOfPatients) {
            assertEquals(disability, patient.getIsDisabled());
        }
    }
}