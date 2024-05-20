package kata.agregio.park.service;

import kata.agregio.core.MarketType;
import kata.agregio.core.PageableDto;
import kata.agregio.park.model.dto.ParkDto;
import kata.agregio.park.model.dto.ParkRequestDto;
import org.springframework.data.domain.Pageable;

public interface ParkService {
    ParkDto create(ParkRequestDto parkRequestDto);

    PageableDto<ParkDto> search(MarketType marketType, Pageable pageable);
}
