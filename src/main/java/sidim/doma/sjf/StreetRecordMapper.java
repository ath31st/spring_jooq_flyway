package sidim.doma.sjf;

import java.time.LocalDate;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Component;
import sidim.doma.sjf.db.tables.records.StreetRecord;

@Component
public class StreetRecordMapper implements RecordMapper<Record1<StreetRecord>, Street> {

  @Override
  public Street map(Record1<StreetRecord> sr) {
    sidim.doma.sjf.db.tables.pojos.Street street =
        sr.into(sidim.doma.sjf.db.tables.pojos.Street.class);

    return new Street(street.getId(), street.getName(), new City(1, "Woop", LocalDate.now(), 1L));
  }
}
