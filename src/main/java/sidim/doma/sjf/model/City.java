package sidim.doma.sjf.model;

import java.time.LocalDate;

public record City(
    Integer id,
    String name,
    LocalDate dateOfFoundation,
    Long population
) {
}
