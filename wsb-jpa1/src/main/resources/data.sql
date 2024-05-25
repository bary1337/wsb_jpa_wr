-- Doctor Insert
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (1, 'Tomasz', 'Lewandowski', '+48 111 222 333', 'tomasz.lewandowski@example.com', '654321', 'SURGEON');
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (2, 'Ewa', 'Kaczmarek', '+48 222 333 444', 'ewa.kaczmarek@example.com', '321654', 'DERMATOLOGIST');
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (3, 'Marek', 'Kwiatkowski', '+48 333 444 555', 'marek.kwiatkowski@example.com', '789123', 'GP');
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (4, 'Agnieszka', 'Pawlak', '+48 444 555 666', 'agnieszka.pawlak@example.com', '456789', 'OCULIST');

-- Patient Insert
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_disabled)
VALUES (1, 'Joanna', 'Dąbrowska', '+48 555 666 777', 'joanna.dabrowska@example.com', '1230984567', '2001-02-02', true);
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_disabled)
VALUES (2, 'Adam', 'Wójcik', '+48 666 777 888', 'adam.wojcik@example.com', '2345678901', '1986-06-16', false);
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_disabled)
VALUES (3, 'Karolina', 'Majewska', '+48 777 888 999', 'karolina.majewska@example.com', '3456789012', '1971-11-30', true);
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_disabled)
VALUES (4, 'Paweł', 'Ostrowski', '+48 888 999 000', 'pawel.ostrowski@example.com', '4567890123', '1996-08-11', false);

-- Address Insert
INSERT INTO address (id, address_line1, address_line2, city, postal_code, doctor_id)
VALUES (1, 'ul. Słoneczna 12', '', 'Łódź', '90-100', 1);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, doctor_id)
VALUES (2, 'Aleja Lipowa 67', 'lok. 4', 'Wrocław', '50-001', 2);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, doctor_id)
VALUES (3, 'ul. Dębowa 9', '', 'Gdynia', '81-100', 3);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, doctor_id)
VALUES (4, 'ul. Brzozowa 3/2', '', 'Szczecin', '70-777', 4);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, patient_id)
VALUES (5, 'ul. Słoneczna 12', '', 'Łódź', '90-100', 1);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, patient_id)
VALUES (6, 'Aleja Lipowa 67', 'lok. 4', 'Wrocław', '50-001', 2);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, patient_id)
VALUES (7, 'ul. Dębowa 9', '', 'Gdynia', '81-100', 3);
INSERT INTO address (id, address_line1, address_line2, city, postal_code, patient_id)
VALUES (8, 'ul. Brzozowa 3/2', '', 'Szczecin', '70-777', 4);

-- Visit Insert
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (1, 'Przegląd roczny', '2024-06-03 10:00:00', 1, 1);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (2, 'Konsultacja alergologiczna', '2024-06-03 11:30:00', 2, 2);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (3, 'Operacja ortopedyczna', '2024-06-03 14:00:00', 3, 3);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (4, 'Badanie słuchu', '2024-06-03 15:30:00', 4, 1);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (5, 'Kontrolna wizyta kardiologiczna', '2024-06-03 16:00:00', 1, 4);

-- Medical Treatment Insert
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (1, 'Badanie USG tarczycy', 'USG', 1);
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (2, 'Badanie Holtera', 'EKG', 2);
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (3, 'Zdjęcie RTG kręgosłupa', 'RTG', 3);
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (4, 'Kontrolne badanie EKG', 'EKG', 5);
