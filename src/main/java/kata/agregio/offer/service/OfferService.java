package kata.agregio.offer.service;

import kata.agregio.core.MarketType;
import kata.agregio.core.PageableDto;
import kata.agregio.offer.model.dto.OfferDto;
import kata.agregio.offer.model.dto.OfferRequestDto;
import org.springframework.data.domain.Pageable;

public interface OfferService {
    OfferDto create(OfferRequestDto offerRequestDto);

    PageableDto<OfferDto> search(MarketType marketType, Pageable pageable);
}
