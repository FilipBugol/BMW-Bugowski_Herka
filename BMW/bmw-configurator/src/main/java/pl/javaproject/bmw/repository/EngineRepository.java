package pl.javaproject.bmw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javaproject.bmw.model.Engine;

public interface EngineRepository extends JpaRepository<Engine, Long> {
}