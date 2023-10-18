package sidim.doma.sjf;

import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Component;
import sidim.doma.sjf.db.tables.pojos.City;
import sidim.doma.sjf.db.tables.records.CityRecord;

@Component
public class CityRecordMapper implements RecordMapper<Record1<CityRecord>, sidim.doma.sjf.City> {

  @Override
  public sidim.doma.sjf.City map(Record1<CityRecord> cr) {
    City c = cr.into(City.class);
    return new sidim.doma.sjf.City(
        c.getId(), c.getName(), c.getDateOfFoundation(), c.getPopulation());
  }
}
