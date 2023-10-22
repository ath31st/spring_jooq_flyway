package sidim.doma.sjf.model;

import java.time.LocalDate;

public record House(
    Integer id,
    Integer houseNumber,
    LocalDate dateOfBuild,
    Street street
) {
}
