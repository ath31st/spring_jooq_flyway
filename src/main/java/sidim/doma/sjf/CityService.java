package sidim.doma.sjf;

import static sidim.doma.sjf.db.tables.City.CITY;

import lombok.RequiredArgsConstructor;
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
  private final CityDao cityDao = new CityDao();

  void insertCity(CityDto dto) {
    City city = new City();
    city.setName(dto.name());
    city.setPopulation(dto.population());
    city.setDateOfFoundation(dto.dateOfFoundation());

    cityDao.insert(city);
  }

  City findByName(String cityName) {
    return dsl.select(CITY)
        .from(CITY)
        .where(CITY.NAME.eq(cityName))
        .fetchOptionalInto(City.class)
        .orElseThrow();
  }
}
