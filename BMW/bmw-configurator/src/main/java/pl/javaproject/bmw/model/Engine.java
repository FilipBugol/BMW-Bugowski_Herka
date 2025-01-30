package pl.javaproject.bmw.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "engine")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Typ silnika jest wymagany")
    private String type;

    @Positive(message = "Moc musi być dodatnia")
    private int power;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getPower() { return power; }
    public void setPower(int power) { this.power = power; }
}