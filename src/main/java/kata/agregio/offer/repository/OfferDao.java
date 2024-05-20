package kata.agregio.offer.repository;

import kata.agregio.core.MarketType;
import kata.agregio.offer.model.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfferDao {
    Offer save(Offer offer);
    
    Page<Offer> findAllByMarketType(MarketType marketType, Pageable pageable);

}
