package pl.javaproject.bmw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javaproject.bmw.model.CarModel;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}