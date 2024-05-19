package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = true)
	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	//Relacja ManyToOne jednokierunkowa od strony dziecka
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_ID")
	private DoctorEntity doctorEntity;

	//Relacja OneToMany jednokierunkowa od strony rodzica
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
	)
	@JoinColumn(name = "MEDICAL_TREATMENT_ID")
	private Collection<MedicalTreatmentEntity> medicalTreatment;

	//Relacja ManyToOne jednokierunkowa od strony dziecka
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID")
	private PatientEntity patientEntity;
	private Collection<MedicalTreatmentEntity> medicalTreatments;
	private DoctorEntity doctor;
	private PatientEntity patient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public Collection<MedicalTreatmentEntity> getMedicalTreatments() {
		return medicalTreatments;
	}

	public void setMedicalTreatments(Collection<MedicalTreatmentEntity> medicalTreatments) {
		this.medicalTreatments = medicalTreatments;
	}

}
