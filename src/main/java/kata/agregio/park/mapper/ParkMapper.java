package kata.agregio.park.mapper;

import kata.agregio.park.model.Park;
import kata.agregio.park.model.dto.ParkDto;
import org.springframework.stereotype.Component;

@Component
public class ParkMapper {
    public ParkDto convertToParkDto(Park park) {
        return new ParkDto(park.getEnergyType(), park.getCapacity());
    }

}
