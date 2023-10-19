package sidim.doma.sjf.service;

import static sidim.doma.sjf.db.tables.City.CITY;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import sidim.doma.sjf.mapper.CityRecordMapper;
import sidim.doma.sjf.db.tables.daos.CityDao;
import sidim.doma.sjf.dto.CityDto;
import sidim.doma.sjf.model.City;

@Service
@RequiredArgsConstructor
public class CityService {
  private final DSLContext dsl;
  private final TransactionTemplate transactionTemplate;
  private final CityDao cityDao;
  private final CityRecordMapper mapper;

  public void insertCity(CityDto dto) {
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

  public City findByName(String cityName) {
    return dsl.select(CITY)
        .from(CITY)
        .where(CITY.NAME.eq(cityName))
        .fetchOptional(mapper)
        .orElseThrow();
  }

  public City findById(Integer cityId) {
    return dsl.select(CITY)
        .from(CITY)
        .where(CITY.ID.eq(cityId))
        .fetchOptional(mapper)
        .orElseThrow();
  }
}
