package my.clinicproject.therapyapi.dto.Request;


import br.com.caelum.stella.bean.validation.CPF;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.clinicproject.therapyapi.Enums.TherapyStatus;
import my.clinicproject.therapyapi.Enums.TherapyType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Integer id;

    @NotEmpty
    @Size(min = 9, max = 100)
    private String name;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;

    @Enumerated(EnumType.STRING)
    @NotEmpty
    private TherapyType therapyType;

    @Enumerated(EnumType.STRING)
    @NotEmpty
    private TherapyStatus therapyStatus;

    @NotEmpty
    private String proResponsibleName;

}
