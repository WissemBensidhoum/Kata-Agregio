package kata.agregio.park.repository;

import kata.agregio.core.MarketType;
import kata.agregio.park.model.Park;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParkDao {
    Park save(Park offer);

    Page<Park> findAllByMarketType(MarketType marketType, Pageable pageable);

}
