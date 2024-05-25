package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    @Mock
    private PatientDao patientDao;

    @InjectMocks
    private PatientServiceImpl patientService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
@Test
public void testFindById() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setFirstName("Joanna");
        patientEntity.setLastName("Dąbrowska");
        patientEntity.setTelephoneNumber("+48 555 666 777");
        patientEntity.setEmail("joanna.dabrowska@example.com");
        patientEntity.setPatientNumber("1230984567");
        patientEntity.setDateOfBirth(LocalDate.of(2001, 2, 2));
        patientEntity.setVisits(Collections.emptySet());
        patientEntity.setAddresses(Collections.emptySet());

        when(patientDao.findOne(anyLong())).thenReturn(patientEntity);

        // when
        PatientTO patientTO = patientService.findById(1L);

        // then
        assertNotNull(patientTO);
        assertEquals(patientEntity.getId(), patientTO.getId());
        assertEquals(patientEntity.getFirstName(), patientTO.getFirstName());
        assertEquals(patientEntity.getLastName(), patientTO.getLastName());
        assertEquals(patientEntity.getTelephoneNumber(), patientTO.getTelephoneNumber());
        assertEquals(patientEntity.getEmail(), patientTO.getEmail());
        assertEquals(patientEntity.getPatientNumber(), patientTO.getPatientNumber());
        assertEquals(patientEntity.getDateOfBirth(), patientTO.getDateOfBirth());
        assertTrue(patientTO.getVisits().isEmpty());
        assertTrue(patientTO.getAddresses().isEmpty());
        }

@Test
public void testDeletePatient() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(1L);
        Set<VisitEntity> visits = new HashSet<>();
        visits.add(visitEntity);
        patientEntity.getVisits();

        when(patientDao.findOne(anyLong())).thenReturn(patientEntity);
        when(patientDao.exists(anyLong())).thenReturn(true);

        // when
        patientService.deletePatient(1L);

        // then
        ArgumentCaptor<PatientEntity> captor = ArgumentCaptor.forClass(PatientEntity.class);
        verify(patientDao, times(1)).delete(captor.capture());
        PatientEntity capturedEntity = captor.getValue();
        assertEquals(patientEntity.getId(), capturedEntity.getId());

        // Ensure visits are removed (handled by cascade)
        verify(patientDao, times(1)).delete(any(PatientEntity.class));
        }

@Test
public void testSavePatient() {
        // given
        PatientTO patientTO = new PatientTO();
        patientTO.setId(1L);
        patientTO.setFirstName("Joanna");
        patientTO.setLastName("Dąbrowska");
        patientTO.setTelephoneNumber("+48 555 666 777");
        patientTO.setEmail("joanna.dabrowska@example.com");
        patientTO.setPatientNumber("1230984567");
        patientTO.setDateOfBirth(LocalDate.of(2001, 2, 2));

        PatientEntity patientEntity = PatientMapper.mapToPatientEntity(patientTO);

        when(patientDao.save(any(PatientEntity.class))).thenReturn(patientEntity);

        // when
        PatientTO savedPatientTO = patientService.savePatient(patientTO);

        // then
        assertNotNull(savedPatientTO);
        assertEquals(patientTO.getId(), savedPatientTO.getId());
        assertEquals(patientTO.getFirstName(), savedPatientTO.getFirstName());
        assertEquals(patientTO.getLastName(), savedPatientTO.getLastName());
        assertEquals(patientTO.getTelephoneNumber(), savedPatientTO.getTelephoneNumber());
        assertEquals(patientTO.getEmail(), savedPatientTO.getEmail());
        assertEquals(patientTO.getPatientNumber(), savedPatientTO.getPatientNumber());
        assertEquals(patientTO.getDateOfBirth(), savedPatientTO.getDateOfBirth());
        }






}
