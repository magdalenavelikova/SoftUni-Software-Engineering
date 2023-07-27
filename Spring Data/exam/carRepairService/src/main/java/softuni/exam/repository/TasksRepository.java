package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Task;
import softuni.exam.models.enums.CarType;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {
//    Filter only coupe cars and order them by the price in descending order.
    List<Task> findAllByCars_CarTypeOrderByPriceDesc(CarType carType);

}
