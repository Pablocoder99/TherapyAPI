package my.clinicproject.therapyapi.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TherapyType {

    ANXIETY("Anxiety"),
    DEPRESSION("Depression"),
    STRESS("Stress");

    private final String description;
}
