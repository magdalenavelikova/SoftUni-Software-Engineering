package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.models.enums.StarType;

import java.util.List;
import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {
//•	Extract from the database, the star name, distance in light years (to second digit after decimal point), description and the constellation name.
//•	Filter only stars who are Red Giants and have never been observed and order them by the light years in ascending order.
    Optional<Star> findFirstByName(String name);
    @Query("Select s FROM Star s WHERE SIZE(s.observers)=:count AND s.starType=:starType order by s.lightYears asc")
   List<Star> findNotObservedStars(int count, StarType starType);

}
