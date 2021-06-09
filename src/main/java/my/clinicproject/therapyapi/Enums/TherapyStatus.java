package my.clinicproject.therapyapi.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TherapyStatus {

    INITIAL("Initial"),
    DEVELOPMENT("Development"),
    INTERPRETATION("Interpretation");

    private final String description;
}
