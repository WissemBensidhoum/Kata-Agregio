package kata.agregio.timeblock.model;

import jakarta.persistence.*;
import kata.agregio.offer.model.Offer;
import kata.agregio.park.model.Park;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class TimeBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timeBlock_id_seq")
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long energyQuantity;
    private double priceFloor;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "TimeBlock_Producer",
            joinColumns = {@JoinColumn(name = "time_block_id")},
            inverseJoinColumns = {@JoinColumn(name = "park_id")}
    )
    private List<Park> producers;
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public TimeBlock() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getPriceFloor() {
        return priceFloor;
    }

    public void setPriceFloor(double priceFloor) {
        this.priceFloor = priceFloor;
    }

    public long getEnergyQuantity() {
        return energyQuantity;
    }

    public void setEnergyQuantity(long energyQuantity) {
        this.energyQuantity = energyQuantity;
    }

    public List<Park> getProducers() {
        return producers;
    }

    public void setProducers(List<Park> producers) {
        this.producers = producers;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof TimeBlock timeBlock && energyQuantity == timeBlock.energyQuantity &&
                Double.compare(priceFloor, timeBlock.priceFloor) == 0 &&
                Objects.equals(id, timeBlock.id) && Objects.equals(startTime, timeBlock.startTime) &&
                Objects.equals(endTime, timeBlock.endTime) &&
                Objects.equals(producers, timeBlock.producers) &&
                Objects.equals(offer, timeBlock.offer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, energyQuantity, priceFloor, producers, offer);
    }

    @Override
    public String toString() {
        return "TimeBlock{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", energyQuantity=" + energyQuantity +
                ", priceFloor=" + priceFloor +
                ", producers=" + producers +
                ", offer=" + offer +
                '}';
    }

    public static class Builder {
        private Long id;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private long energyQuantity;
        private double priceFloor;
        private Offer offer;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder startTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder energyQuantity(long energyQuantity) {
            this.energyQuantity = energyQuantity;
            return this;
        }

        public Builder priceFloor(long priceFloor) {
            this.priceFloor = priceFloor;
            return this;
        }

        public Builder offer(Offer offer) {
            this.offer = offer;
            return this;
        }

        public TimeBlock build() {
            TimeBlock timeBlock = new TimeBlock();
            timeBlock.id = this.id;
            timeBlock.startTime = this.startTime;
            timeBlock.endTime = this.endTime;
            timeBlock.energyQuantity = this.energyQuantity;
            timeBlock.priceFloor = this.priceFloor;
            timeBlock.offer = this.offer;
            return timeBlock;
        }
    }
}
