package sidim.doma.sjf.dto;

import java.time.LocalDate;

public record CityDto(
    String name,
    LocalDate dateOfFoundation,
    Long population
) {
}
