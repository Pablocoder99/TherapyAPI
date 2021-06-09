package my.clinicproject.therapyapi.Controller;

import lombok.AllArgsConstructor;
import my.clinicproject.therapyapi.Exceptions.PatientNotFoundException;
import my.clinicproject.therapyapi.Service.PatientService;
import my.clinicproject.therapyapi.dto.Request.PatientDTO;
import my.clinicproject.therapyapi.dto.Response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PatientController {

    private PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private MessageResponseDTO createPatient(@RequestBody @Valid PatientDTO patientDTO) {
        return patientService.createPatient(patientDTO);
    }

    @GetMapping
    public List<PatientDTO> listAll() {
        return patientService.listAll();
    }

    @GetMapping("/{id}")
    public PatientDTO listById(@PathVariable Integer id) throws PatientNotFoundException {
        return patientService.listById(id);
    }


    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Integer id, @RequestBody @Valid PatientDTO patientDTO) throws PatientNotFoundException {
        return patientService.updateById(id, patientDTO);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeById(@PathVariable Integer id) throws PatientNotFoundException {
        patientService.removeById(id);
    }

}
