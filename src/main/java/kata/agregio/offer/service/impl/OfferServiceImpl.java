package kata.agregio.offer.service.impl;

import kata.agregio.core.MarketType;
import kata.agregio.core.PageableDto;
import kata.agregio.core.PageableMapper;
import kata.agregio.offer.mapper.OfferMapper;
import kata.agregio.offer.model.Offer;
import kata.agregio.offer.model.dto.OfferDto;
import kata.agregio.offer.model.dto.OfferRequestDto;
import kata.agregio.offer.repository.OfferDao;
import kata.agregio.offer.service.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferDao offerDao;
    private final OfferMapper offerMapper;
    private final PageableMapper pageableMapper;

    public OfferServiceImpl(OfferDao offerDao, OfferMapper offerMapper, PageableMapper pageableMapper) {
        this.offerDao = offerDao;
        this.offerMapper = offerMapper;
        this.pageableMapper = pageableMapper;
    }

    @Override
    public OfferDto create(OfferRequestDto offerRequestDto) {
        Offer offer =
                new Offer.Builder().startDate(offerRequestDto.startDate())
                        .endDate(offerRequestDto.endDate())
                        .marketType(offerRequestDto.marketType())
                        .build();
        return offerMapper.convertToOfferDto(offerDao.save(offer));
    }

    @Override
    public PageableDto<OfferDto> search(MarketType marketType, Pageable pageable) {
        Page<Offer> offers = offerDao.findAllByMarketType(marketType, pageable);
        Page<OfferDto> offerDtos = offers.map(offerMapper::convertToOfferDto);

        return pageableMapper.convertToDto(offerDtos);
    }
}
