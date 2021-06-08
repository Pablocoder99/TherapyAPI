package my.clinicproject.therapyapi.Service;

import my.clinicproject.therapyapi.Patient.Patient;
import my.clinicproject.therapyapi.Repository.PatientRepository;
import my.clinicproject.therapyapi.dto.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public MessageResponseDTO createPatient(Patient patient) {
        Patient savedPatient = patientRepository.save(patient);
        return MessageResponseDTO
                .builder()
                .message("Created Patient with ID "+patient.getId()+". Accompained by Dr(a) "+patient.getProResponsibleName())
                .build();
    }
}
