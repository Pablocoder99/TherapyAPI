package my.clinicproject.therapyapi.Controller;

import my.clinicproject.therapyapi.Patient.Patient;
import my.clinicproject.therapyapi.Service.PatientService;
import my.clinicproject.therapyapi.dto.Request.PatientDTO;
import my.clinicproject.therapyapi.dto.Response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    private MessageResponseDTO createPatient(@RequestBody @Valid PatientDTO patientDTO) {
        return patientService.createPatient(patientDTO);
    }

}
