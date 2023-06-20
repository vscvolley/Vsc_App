package VSC_Volley.springboot_backend.controle;


import VSC_Volley.springboot_backend.modelo.Equipas;
import VSC_Volley.springboot_backend.servico.EquipasServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipas")
@CrossOrigin
public class ControloEquipas {

    @Autowired
    private EquipasServico equipasServico;

    @PostMapping
    public String add(@RequestBody Equipas equipas){
        equipasServico.guardar(equipas);
        return "Equipa adicionada";
    }

    @GetMapping("/imprimir")
    public List<Equipas> imprimir() {
        return equipasServico.imprimir();
    }
}