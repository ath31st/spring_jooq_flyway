package sidim.doma.sjf;

import static sidim.doma.sjf.db.tables.City.CITY;

import lombok.RequiredArgsConstructor;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import sidim.doma.sjf.db.tables.daos.CityDao;
import sidim.doma.sjf.db.tables.pojos.City;

@Service
@RequiredArgsConstructor
public class CityService {
  private final DSLContext dsl;
  private final TransactionTemplate transactionTemplate;
  private final Configuration jooqConfiguration;
  private final CityDao cityDao;

  void insertCity(CityDto dto) {
//    City c = new City();
//    c.setName(dto.name());
//    c.setPopulation(dto.population());
//    c.setDateOfFoundation(dto.dateOfFoundation());
//
//    cityDao.insert(c);

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
