package sidim.doma.sjf.service;

import static sidim.doma.sjf.db.Tables.HOUSE;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import sidim.doma.sjf.dto.HouseDto;
import sidim.doma.sjf.mapper.HouseRecordMapper;
import sidim.doma.sjf.model.House;

@Service
@RequiredArgsConstructor
public class HouseService {
  private final DSLContext dsl;
  private final HouseRecordMapper mapper;

  public void insertHouse(HouseDto dto) {
    dsl.insertInto(HOUSE)
        .columns(HOUSE.HOUSE_NUMBER, HOUSE.DATE_OF_BUILD, HOUSE.STREET_ID)
        .values(dto.houseNumber(), dto.dateOfBuild(), dto.streetId())
        .execute();
  }

  public House findByNumber(Integer houseNumber) {
    return dsl.select(HOUSE)
        .from(HOUSE)
        .where(HOUSE.HOUSE_NUMBER.eq(houseNumber))
        .fetchOptional(mapper)
        .orElseThrow();
  }
}
