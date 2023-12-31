package sidim.doma.sjf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sidim.doma.sjf.dto.StreetDto;
import sidim.doma.sjf.model.Street;
import sidim.doma.sjf.service.StreetService;

@RestController
@RequiredArgsConstructor
public class StreetController {
  private final StreetService streetService;

  @GetMapping("/street/{name}")
  ResponseEntity<Street> getStreet(@PathVariable String name) {
    return ResponseEntity.ok(streetService.findByName(name));
  }

  @PostMapping("/street/new")
  ResponseEntity<HttpStatus> insertStreet(@RequestBody StreetDto dto) {
    streetService.insertStreet(dto);
    return ResponseEntity.ok(HttpStatus.CREATED);
  }
}
