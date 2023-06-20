package VSC_Volley.springboot_backend.controle;


import VSC_Volley.springboot_backend.modelo.Jogos;
import VSC_Volley.springboot_backend.servico.JogosServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Jogos")
@CrossOrigin
public class ControloJogos {

    @Autowired
    private JogosServico jogoServico;

    @PostMapping("/add")
    public boolean add(@RequestBody Jogos jogos){
         return  jogoServico.guardar(jogos);
    }

    @GetMapping("/imprimir")
    public List<Jogos> imprimir(){
        return jogoServico.imprimir();
    }

}
