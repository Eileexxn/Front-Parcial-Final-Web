package main.java.com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoFilaDTO {
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private String bodega;
}

