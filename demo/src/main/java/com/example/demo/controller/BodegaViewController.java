package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.BodegaDTO;
import main.java.com.example.demo.service.BodegaFrontService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BodegaViewController {

    private final BodegaFrontService bodegaFrontService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bodega", new BodegaDTO());
        model.addAttribute("productos", bodegaFrontService.obtenerProductosConBodega());
        return "index";
    }

    @PostMapping("/bodegas")
    public String guardarBodega(@ModelAttribute("bodega") BodegaDTO bodega,
                                RedirectAttributes redirectAttributes) {
        if (bodega.getNombre() == null || bodega.getNombre().isBlank()
                || bodega.getUbicacion() == null || bodega.getUbicacion().isBlank()) {
            redirectAttributes.addFlashAttribute("mensaje", "Debe ingresar nombre y ubicación.");
            return "redirect:/";
        }

        bodegaFrontService.registrarBodega(bodega);
        redirectAttributes.addFlashAttribute("mensaje", "Bodega registrada correctamente.");
        return "redirect:/";
    }
}