package sidim.doma.sjf;

import static sidim.doma.sjf.db.tables.City.CITY;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import sidim.doma.sjf.db.tables.pojos.City;

@Service
@RequiredArgsConstructor
public class CityService {
  private final DSLContext dsl;
  private final TransactionTemplate transactionTemplate;

  void insertCity(CityDto dto) {
    dsl.insertInto(CITY)
        .columns(CITY.NAME, CITY.DATE_OF_FOUNDATION, CITY.POPULATION)
        .values(dto.name(), dto.dateOfFoundation(), dto.population())
        .execute();
  }

  City findByName(String cityName) {
    return dsl.select(CITY)
        .from(CITY)
        .where(CITY.NAME.eq(cityName))
        .fetchOptionalInto(City.class)
        .orElseThrow();
  }
}
