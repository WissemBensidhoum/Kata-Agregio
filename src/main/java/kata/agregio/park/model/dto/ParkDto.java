package kata.agregio.park.model.dto;

import kata.agregio.core.EnergyType;

public record ParkDto(EnergyType energyType, long capacity) {
}
