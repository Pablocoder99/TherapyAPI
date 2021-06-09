package my.clinicproject.therapyapi.Service;

import my.clinicproject.therapyapi.Exceptions.PatientNotFoundException;
import my.clinicproject.therapyapi.Mapper.PatientMapper;
import my.clinicproject.therapyapi.Patient.Patient;
import my.clinicproject.therapyapi.Repository.PatientRepository;
import my.clinicproject.therapyapi.dto.Request.PatientDTO;
import my.clinicproject.therapyapi.dto.Response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    private final PatientMapper patientMapper = PatientMapper.INSTANCE;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    private Patient exists(Integer id) throws PatientNotFoundException {
        return patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));
    }

    public MessageResponseDTO createPatient(PatientDTO patientDTO) {
        Patient patientToSave = patientMapper.toModel(patientDTO);

        Patient savedPatient = patientRepository.save(patientToSave);
        return MessageResponseDTO
                .builder()
                .message("Created Patient with ID "+savedPatient.getId()+". Accompained by Dr(a) "+savedPatient.getProResponsibleName())
                .build();
    }

    public List<PatientDTO> listAll() {
        List<Patient> allPatients = patientRepository.findAll();
        return allPatients.stream()
                .map(patient -> patientMapper.toDTO(patient))
                .collect(Collectors.toList());
    }


    public PatientDTO listById(Integer id) throws PatientNotFoundException {
        Patient patient = exists(id);
        return patientMapper.toDTO(patient);
    }

    public void removeById(Integer id) throws PatientNotFoundException {
        exists(id);
        patientRepository.deleteById(id);
    }
}
