package sidim.doma.sjf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sidim.doma.sjf.db.tables.daos.CityDao;

@Configuration
public class DaoConfig {
  @Bean
  CityDao cityDao(org.jooq.Configuration configuration) {
    return new CityDao(configuration);
  }
}
