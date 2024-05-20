package kata.agregio.park.model;

import jakarta.persistence.*;
import kata.agregio.core.EnergyType;

import java.util.Objects;

@Entity
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "park_id_seq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private EnergyType energyType;
    private long capacity;

    public Park() {
    }

    public Long getId() {
        return id;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Park park && Objects.equals(id, park.id) && energyType == park.energyType &&
                capacity == park.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, energyType, capacity);
    }

    @Override
    public String toString() {
        return "Park{" +
                "id=" + id +
                ", energyType=" + energyType +
                ", capacity=" + capacity +
                '}';
    }

    public static class Builder {
        private Long id;
        private EnergyType energyType;
        private long capacity;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder energyType(EnergyType energyType) {
            this.energyType = energyType;
            return this;
        }

        public Builder capacity(long capacity) {
            this.capacity = capacity;
            return this;
        }

        public Park build() {
            Park park = new Park();
            park.id = this.id;
            park.energyType = this.energyType;
            park.capacity = this.capacity;
            return park;
        }
    }
}
