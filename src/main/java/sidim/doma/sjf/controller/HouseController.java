package sidim.doma.sjf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sidim.doma.sjf.dto.HouseDto;
import sidim.doma.sjf.model.House;
import sidim.doma.sjf.service.HouseService;

@RestController
@RequiredArgsConstructor
public class HouseController {
  private final HouseService houseService;

  @GetMapping("/house/{number}")
  ResponseEntity<House> getStreet(@PathVariable Integer number) {
    return ResponseEntity.ok(houseService.findByNumber(number));
  }

  @PostMapping("/street/new")
  ResponseEntity<HttpStatus> insertStreet(@RequestBody HouseDto dto) {
    houseService.insertHouse(dto);
    return ResponseEntity.ok(HttpStatus.CREATED);
  }
}
