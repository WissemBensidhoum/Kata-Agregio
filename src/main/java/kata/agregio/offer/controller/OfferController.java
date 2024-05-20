package kata.agregio.offer.controller;

import jakarta.validation.Valid;
import kata.agregio.core.MarketType;
import kata.agregio.core.PageableDto;
import kata.agregio.offer.model.dto.OfferDto;
import kata.agregio.offer.model.dto.OfferRequestDto;
import kata.agregio.offer.service.OfferService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public PageableDto<OfferDto> getPage(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "15") int size,
                                         @RequestParam(required = false) MarketType marketType) {
        Pageable pageable = PageRequest.of(page, size);
        return offerService.search(marketType, pageable);
    }

    @PostMapping
    public OfferDto create(@Valid @RequestBody OfferRequestDto offerRequestDto) {
        return offerService.create(offerRequestDto);
    }
}
