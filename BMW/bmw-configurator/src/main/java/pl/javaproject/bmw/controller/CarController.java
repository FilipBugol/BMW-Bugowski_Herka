package pl.javaproject.bmw.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.javaproject.bmw.model.CarModel;
import pl.javaproject.bmw.repository.CarModelRepository;
import pl.javaproject.bmw.repository.EngineRepository;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarModelRepository carModelRepository;
    private final EngineRepository engineRepository;

    public CarController(CarModelRepository carModelRepository, EngineRepository engineRepository) {
        this.carModelRepository = carModelRepository;
        this.engineRepository = engineRepository;
    }

    @GetMapping
    public String listCars(Model model) {
        model.addAttribute("cars", carModelRepository.findAll());
        return "cars/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("car", new CarModel());
        model.addAttribute("engines", engineRepository.findAll());
        return "cars/add-car";
    }

    @PostMapping("/add")
    public String addCar(@Valid @ModelAttribute("car") CarModel car, BindingResult result) {
        if (result.hasErrors()) {
            return "cars/add-car";
        }
        carModelRepository.save(car);
        return "redirect:/cars";
    }
}