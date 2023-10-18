package sidim.doma.sjf;

import static sidim.doma.sjf.db.Tables.STREET;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import sidim.doma.sjf.db.tables.pojos.Street;

@Service
@RequiredArgsConstructor
public class StreetService {
  private final DSLContext dsl;

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
        .fetchOptionalInto(Street.class)
        .orElseThrow();
  }
}
