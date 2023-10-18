package sidim.doma.sjf;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StreetService {
  private final DSLContext dsl;
}
