package sidim.doma.sjf.mapper;

import lombok.RequiredArgsConstructor;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Component;
import sidim.doma.sjf.db.tables.records.StreetRecord;
import sidim.doma.sjf.model.City;
import sidim.doma.sjf.model.Street;
import sidim.doma.sjf.service.CityService;

@Component
@RequiredArgsConstructor
public class StreetRecordMapper implements RecordMapper<Record1<StreetRecord>, Street> {
  private final CityService service;

  @Override
  public Street map(Record1<StreetRecord> sr) {
    sidim.doma.sjf.db.tables.pojos.Street street =
        sr.into(sidim.doma.sjf.db.tables.pojos.Street.class);
    City c = service.findById(street.getCityId());

    return new Street(street.getId(), street.getName(), c);
  }
}
