package kata.agregio.park.model.dto;

import kata.agregio.core.EnergyType;

public record ParkRequestDto(EnergyType energyType, long capacity) {
}
