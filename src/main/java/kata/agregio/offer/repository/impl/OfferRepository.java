package kata.agregio.offer.repository.impl;

import kata.agregio.offer.model.Offer;
import kata.agregio.offer.repository.OfferDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends OfferDao, JpaRepository<Offer, Long> {
}
