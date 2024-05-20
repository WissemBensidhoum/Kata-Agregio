package kata.agregio.service;

import kata.agregio.core.PageableMapper;
import kata.agregio.park.mapper.ParkMapper;
import kata.agregio.park.model.Park;
import kata.agregio.park.model.dto.ParkRequestDto;
import kata.agregio.park.repository.ParkDao;
import kata.agregio.park.service.impl.ParkServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static kata.agregio.core.EnergyType.WIND;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ParkServiceTest {
    @Mock
    private ParkDao parkDao;

    @Mock
    private ParkMapper parkMapper;

    @Mock
    private PageableMapper pageableMapper;

    @InjectMocks
    private ParkServiceImpl parkService;

    @AfterEach
    void tearDown() {
        clearInvocations(parkDao);
    }

    @Test
    @DisplayName("it should create park")
    void createParkTest() {
        // GIVEN
        Park park = new Park.Builder().energyType(WIND)
                .capacity(50000)
                .build();

        ParkRequestDto parkRequestDto = new ParkRequestDto(WIND, 50000);

        // WHEN
        parkService.create(parkRequestDto);

        // THEN
        verify(parkDao, times(1)).save(park);
    }

}
