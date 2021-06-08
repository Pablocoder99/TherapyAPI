package my.clinicproject.therapyapi.Controller;

import my.clinicproject.therapyapi.Patient.Patient;
import my.clinicproject.therapyapi.Service.PatientService;
import my.clinicproject.therapyapi.dto.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private MessageResponseDTO createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

}
