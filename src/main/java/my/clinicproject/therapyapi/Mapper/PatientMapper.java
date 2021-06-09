package my.clinicproject.therapyapi.Mapper;

import my.clinicproject.therapyapi.Patient.Patient;
import my.clinicproject.therapyapi.dto.Request.PatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    @Mapping(target = "birthDate", dateFormat = "dd-MM-yyyy")
    Patient toModel(PatientDTO patientDTO);

    PatientDTO toDTO(Patient patient);

}
