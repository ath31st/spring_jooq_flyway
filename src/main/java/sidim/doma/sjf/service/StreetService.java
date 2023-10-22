package sidim.doma.sjf.service;

import static sidim.doma.sjf.db.Tables.STREET;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import sidim.doma.sjf.dto.StreetDto;
import sidim.doma.sjf.mapper.StreetRecordMapper;
import sidim.doma.sjf.model.Street;

@Service
@RequiredArgsConstructor
public class StreetService {
  private final DSLContext dsl;
  private final StreetRecordMapper mapper;

  public void insertStreet(StreetDto dto) {
    dsl.insertInto(STREET)
        .columns(STREET.NAME, STREET.CITY_ID)
        .values(dto.name(), dto.cityId())
        .execute();
  }

  public Street findByName(String name) {
    return dsl.select(STREET)
        .from(STREET)
        .where(STREET.NAME.eq(name))
        .fetchOptional(mapper)
        .orElseThrow();
  }

  public Street findById(Integer streetId) {
    return dsl.select(STREET)
        .from(STREET)
        .where(STREET.ID.eq(streetId))
        .fetchOptional(mapper)
        .orElseThrow();
  }
}
