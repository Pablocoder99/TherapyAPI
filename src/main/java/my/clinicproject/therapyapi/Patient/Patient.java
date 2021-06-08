package my.clinicproject.therapyapi.Patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.clinicproject.therapyapi.Enums.Status;
import my.clinicproject.therapyapi.Enums.TherapyType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TherapyType therapyType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status therapyStatus;

    @Column(nullable = false)
    private String proResponsibleName;

}
