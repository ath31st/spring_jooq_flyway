package sidim.doma.sjf;

import java.time.LocalDate;

public record CityDto(
    String name,
    LocalDate dateOfFoundation,
    Long population
) {
}
