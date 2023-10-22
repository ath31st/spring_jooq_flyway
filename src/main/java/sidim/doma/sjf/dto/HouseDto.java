package sidim.doma.sjf.dto;

import java.time.LocalDate;

public record HouseDto(
    Integer houseNumber,
    LocalDate dateOfBuild,
    Integer streetId
) {
}
