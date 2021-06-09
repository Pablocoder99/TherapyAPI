package my.clinicproject.therapyapi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends Exception {
    public PatientNotFoundException(Integer id) {
        super("Patient not found with ID "+id);
    }
}
