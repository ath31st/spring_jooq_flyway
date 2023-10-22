package sidim.doma.sjf.mapper;

import lombok.RequiredArgsConstructor;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Component;
import sidim.doma.sjf.db.tables.records.HouseRecord;
import sidim.doma.sjf.model.House;
import sidim.doma.sjf.model.Street;
import sidim.doma.sjf.service.StreetService;

@Component
@RequiredArgsConstructor
public class HouseRecordMapper implements RecordMapper<Record1<HouseRecord>, House> {
  private final StreetService service;

  @Override
  public House map(Record1<HouseRecord> hr) {
    sidim.doma.sjf.db.tables.pojos.House house =
        hr.into(sidim.doma.sjf.db.tables.pojos.House.class);
    Street s = service.findById(house.getStreetId());

    return new House(house.getId(), house.getHouseNumber(), house.getDateOfBuild(), s);
  }
}
