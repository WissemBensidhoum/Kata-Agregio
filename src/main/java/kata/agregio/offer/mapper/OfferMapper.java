package kata.agregio.offer.mapper;

import kata.agregio.offer.model.Offer;
import kata.agregio.offer.model.dto.OfferDto;
import org.springframework.stereotype.Component;

@Component
public class OfferMapper {
    public OfferDto convertToOfferDto(Offer offer) {
        return new OfferDto(offer.getId(), offer.getStartDate(), offer.getEndDate(), offer.getTimeBlocks(),
                offer.getMarketType());
    }

    public Offer convertFromOfferDto(OfferDto offerDto) {
        return new Offer.Builder().id(offerDto.id())
                .startDate(offerDto.startDate())
                .endDate(offerDto.endDate())
                .timeBlocks(offerDto.timeBlockList())
                .marketType(offerDto.marketType())
                .build();
    }

}
