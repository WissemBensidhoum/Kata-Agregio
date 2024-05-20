package kata.agregio.offer.model;

import jakarta.persistence.*;
import kata.agregio.core.MarketType;
import kata.agregio.timeblock.model.TimeBlock;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_id_seq")
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
    private List<TimeBlock> timeBlocks;
    @Enumerated(EnumType.STRING)
    private MarketType marketType;

    public Offer() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<TimeBlock> getTimeBlocks() {
        return timeBlocks;
    }

    public void setTimeBlocks(List<TimeBlock> timeBlocks) {
        this.timeBlocks = timeBlocks;
    }

    public MarketType getMarketType() {
        return marketType;
    }

    public void setMarketType(MarketType marketType) {
        this.marketType = marketType;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Offer offer && Objects.equals(id, offer.id) && Objects.equals(startDate, offer.startDate) &&
                Objects.equals(endDate, offer.endDate) &&
                Objects.equals(timeBlocks, offer.timeBlocks) && marketType == offer.marketType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, timeBlocks, marketType);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", timeBlocks=" + timeBlocks +
                ", marketType=" + marketType +
                '}';
    }

    public static class Builder {
        private Long id;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private List<TimeBlock> timeBlocks;
        private MarketType marketType;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            this.startDate = Builder.this.startDate;
            return this;
        }

        public Builder endDate(LocalDateTime endDate) {
            this.endDate = Builder.this.endDate;
            return this;
        }

        public Builder timeBlocks(List<TimeBlock> timeBlocks) {
            this.timeBlocks = Builder.this.timeBlocks;
            return this;
        }

        public Builder marketType(MarketType marketType) {
            this.marketType = Builder.this.marketType;
            return this;
        }

        public Offer build() {
            Offer timeBlock = new Offer();
            timeBlock.id = this.id;
            timeBlock.startDate = this.startDate;
            timeBlock.endDate = this.endDate;
            timeBlock.timeBlocks = this.timeBlocks;
            timeBlock.marketType = this.marketType;
            return timeBlock;
        }
    }
}
