package main.java.com.example.demo.service;

import main.java.com.example.demo.model.BodegaDTO;
import main.java.com.example.demo.model.ProductoDTO;
import main.java.com.example.demo.model.ProductoFilaDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BodegaFrontService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String backendUrl = "http://localhost:8080/bodegas";

    public void registrarBodega(BodegaDTO bodega) {
        restTemplate.postForObject(backendUrl, bodega, BodegaDTO.class);
    }

    public List<ProductoFilaDTO> obtenerProductosConBodega() {
        BodegaDTO[] respuesta = restTemplate.getForObject(backendUrl, BodegaDTO[].class);
        List<ProductoFilaDTO> filas = new ArrayList<>();

        if (respuesta != null) {
            for (BodegaDTO bodega : Arrays.asList(respuesta)) {
                if (bodega.getProductos() != null) {
                    for (ProductoDTO p : bodega.getProductos()) {
                        filas.add(new ProductoFilaDTO(
                                p.getNombre(),
                                p.getPrecio(),
                                p.getCantidad(),
                                bodega.getNombre()
                        ));
                    }
                }
            }
        }
        return filas;
    }
}