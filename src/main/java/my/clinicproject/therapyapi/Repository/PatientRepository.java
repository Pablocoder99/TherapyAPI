package my.clinicproject.therapyapi.Repository;

import my.clinicproject.therapyapi.Patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {}