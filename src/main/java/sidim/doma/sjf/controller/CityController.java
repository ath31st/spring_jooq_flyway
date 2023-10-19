package sidim.doma.sjf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sidim.doma.sjf.service.CityService;
import sidim.doma.sjf.dto.CityDto;
import sidim.doma.sjf.model.City;


@RestController
@RequiredArgsConstructor
public class CityController {

  private final CityService cityService;

  @GetMapping("/city/{name}")
  ResponseEntity<City> getCity(@PathVariable String name) {
    return ResponseEntity.ok(cityService.findByName(name));
  }

  @PostMapping("/city/new")
  ResponseEntity<HttpStatus> insertCity(@RequestBody CityDto dto) {
    cityService.insertCity(dto);
    return ResponseEntity.ok(HttpStatus.CREATED);
  }
}
