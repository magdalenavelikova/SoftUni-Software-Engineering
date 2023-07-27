package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import softuni.exam.models.entity.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

     Country findByCountryName(String name);

}
