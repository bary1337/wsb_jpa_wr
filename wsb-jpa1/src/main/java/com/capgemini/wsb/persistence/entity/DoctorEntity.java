package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 45)
	private String firstName;

	@Column(nullable = false, length = 45)
	private String lastName;

	@Column(nullable = false, length = 15)
	private String telephoneNumber;
	@Column(nullable = true)
	private String email;

	@Column(nullable = false)
	private String doctorNumber;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	//Relacja dwustronna OneToMany
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
	private List<VisitEntity> visitsEntities;
	//Relacja dwustronna OneToMany
	@OneToOne(mappedBy = "doctor", cascade = CascadeType.REMOVE)
	private AddressEntity address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public List<VisitEntity> getVisitsEntities() {
		return visitsEntities;
	}
	public void setVisitsEntities(List<VisitEntity> visitsEntities) {
		this.visitsEntities = visitsEntities;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

    public void setName(String s) {
    }

}
