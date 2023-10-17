package sidim.doma.sjf;

import lombok.RequiredArgsConstructor;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import sidim.doma.sjf.db.tables.daos.CityDao;

@Service
@RequiredArgsConstructor
public class CityService {
  private final DSLContext dsl;
  private final Configuration jooqConfiguration;
  private final TransactionTemplate transactionTemplate;
  private final CityDao cityDao = new CityDao(jooqConfiguration);
}
