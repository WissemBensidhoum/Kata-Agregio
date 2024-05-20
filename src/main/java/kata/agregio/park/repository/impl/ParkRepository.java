package kata.agregio.park.repository.impl;

import kata.agregio.core.MarketType;
import kata.agregio.park.model.Park;
import kata.agregio.park.repository.ParkDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkRepository extends ParkDao, JpaRepository<Park, Long> {
    @Query(nativeQuery = true, value = """
            SELECT p.*
            FROM park p
            JOIN time_block_producer tbp ON p.id = tbp.park_id
            JOIN time_block tb ON tbp.time_block_id = tb.id
            JOIN offer o ON tb.offer_id = o.id
            WHERE o.market_type = :#{#marketType.name()}""")
    Page<Park> findAllByMarketType(MarketType marketType, Pageable pageable);

}
