package pl.javaproject.bmw.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "car_model")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nazwa jest wymagana")
    private String name;

    @Min(2000)
    @Max(2024)
    private int productionYear;

    @Positive(message = "Cena musi być dodatnia")
    private double basePrice;

    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @Pattern(regexp = "^\\+?[0-9\\s-]{9,}$", message = "Nieprawidłowy format numeru telefonu")
    private String phoneNumber;

    // Gettery i settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getProductionYear() { return productionYear; }
    public void setProductionYear(int productionYear) { this.productionYear = productionYear; }
    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }
    public Engine getEngine() { return engine; }
    public void setEngine(Engine engine) { this.engine = engine; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}