package sidim.doma.sjf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConfig {
  @Value("${spring.datasource.username}")
  String userName = "username";
  @Value("${spring.datasource.password}")
  String password = "password";
  @Value("${spring.datasource.url}")
  String url = "jdbc:postgresql://localhost:1234/some_db";

  @Bean
  public DSLContext dslContext() throws SQLException {
    Connection conn = DriverManager.getConnection(url, userName, password);
    return DSL.using(conn, SQLDialect.SQLITE);
  }
}
