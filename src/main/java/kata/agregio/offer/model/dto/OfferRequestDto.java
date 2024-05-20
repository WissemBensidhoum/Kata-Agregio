package kata.agregio.offer.model.dto;

import kata.agregio.core.MarketType;
import kata.agregio.timeblock.model.TimeBlock;

import java.time.LocalDateTime;
import java.util.List;

public record OfferRequestDto(LocalDateTime startDate, LocalDateTime endDate, List<TimeBlock> timeBlockList,
                              MarketType marketType) {
}
