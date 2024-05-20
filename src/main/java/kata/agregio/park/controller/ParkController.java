package kata.agregio.park.controller;

import jakarta.validation.Valid;
import kata.agregio.core.MarketType;
import kata.agregio.core.PageableDto;
import kata.agregio.park.model.dto.ParkDto;
import kata.agregio.park.model.dto.ParkRequestDto;
import kata.agregio.park.service.ParkService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parks")
public class ParkController {
    private final ParkService parkService;

    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

    @GetMapping
    public PageableDto<ParkDto> getPage(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "15") int size,
                                        @RequestParam(name = "market") MarketType marketType) {
        Pageable pageable = PageRequest.of(page, size);
        return parkService.search(marketType, pageable);
    }

    @PostMapping
    public ParkDto create(@Valid @RequestBody ParkRequestDto parkRequestDto) {
        return parkService.create(parkRequestDto);
    }

}