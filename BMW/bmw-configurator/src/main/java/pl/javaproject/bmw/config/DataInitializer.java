package pl.javaproject.bmw.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import pl.javaproject.bmw.model.CarModel;
import pl.javaproject.bmw.model.Engine;
import pl.javaproject.bmw.repository.CarModelRepository;
import pl.javaproject.bmw.repository.EngineRepository;

@Component
public class DataInitializer {

    private final CarModelRepository carModelRepository;
    private final EngineRepository engineRepository;

    public DataInitializer(CarModelRepository carModelRepository, EngineRepository engineRepository) {
        this.carModelRepository = carModelRepository;
        this.engineRepository = engineRepository;
    }

    @PostConstruct
    public void initData() {
        Engine diesel = new Engine();
        diesel.setType("2.0L Diesel");
        diesel.setPower(190);
        engineRepository.save(diesel);

        Engine benzyna = new Engine();
        benzyna.setType("3.0L Benzyna");
        benzyna.setPower(340);
        engineRepository.save(benzyna);

        Engine hybrid = new Engine();
        hybrid.setType("2.0L Hybrid");
        hybrid.setPower(292);
        engineRepository.save(hybrid);

        CarModel ser3 = new CarModel();
        ser3.setName("BMW Seria 3");
        ser3.setProductionYear(2024);
        ser3.setBasePrice(200000);
        ser3.setEngine(diesel);
        carModelRepository.save(ser3);

        CarModel x5 = new CarModel();
        x5.setName("BMW X5");
        x5.setProductionYear(2024);
        x5.setBasePrice(350000);
        x5.setEngine(benzyna);
        carModelRepository.save(x5);
    }
}