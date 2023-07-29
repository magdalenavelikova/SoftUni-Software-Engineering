package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.enums.ApartmentType;

import java.util.List;


@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
//•	Filter only three_rooms apartments and order them by the area in descending order, then by the price in ascending order.
    List<Offer> findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(ApartmentType apartment_apartmentType);
}
