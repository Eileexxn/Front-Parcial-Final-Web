package main.java.com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BodegaDTO {
    private Long id;
    private String nombre;
    private String ubicacion;
    private List<ProductoDTO> productos = new ArrayList<>();
}
