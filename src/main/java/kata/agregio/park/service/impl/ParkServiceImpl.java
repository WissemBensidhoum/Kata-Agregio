package kata.agregio.park.service.impl;

import kata.agregio.core.MarketType;
import kata.agregio.core.PageableDto;
import kata.agregio.core.PageableMapper;
import kata.agregio.park.mapper.ParkMapper;
import kata.agregio.park.model.Park;
import kata.agregio.park.model.dto.ParkDto;
import kata.agregio.park.model.dto.ParkRequestDto;
import kata.agregio.park.repository.ParkDao;
import kata.agregio.park.service.ParkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ParkServiceImpl implements ParkService {
    private final ParkDao parkDao;
    private final ParkMapper parkMapper;
    private final PageableMapper pageableMapper;

    public ParkServiceImpl(ParkDao parkDao, ParkMapper parkMapper, PageableMapper pageableMapper) {
        this.parkDao = parkDao;
        this.parkMapper = parkMapper;
        this.pageableMapper = pageableMapper;
    }

    @Override
    public ParkDto create(ParkRequestDto parkRequestDto) {
        Park park =
                new Park.Builder().energyType(parkRequestDto.energyType())
                        .capacity(parkRequestDto.capacity())
                        .build();
        return parkMapper.convertToParkDto(parkDao.save(park));
    }

    @Override
    public PageableDto<ParkDto> search(MarketType marketType, Pageable pageable) {
        Page<Park> parks = parkDao.findAllByMarketType(marketType, pageable);
        Page<ParkDto> parkDtos = parks.map(parkMapper::convertToParkDto);

        return pageableMapper.convertToDto(parkDtos);
    }
}
