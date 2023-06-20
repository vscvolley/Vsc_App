package VSC_Volley.springboot_backend.controle;


import VSC_Volley.springboot_backend.modelo.Jogador;
import VSC_Volley.springboot_backend.servico.JogadorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Jogador")
@CrossOrigin
public class ControloJogador {

    @Autowired
    private JogadorServico jogadorServico;

    @PostMapping("/add")
    public boolean add(@RequestBody Jogador jogador){
        if(jogador == null)
            return false;
        return jogadorServico.guardar(jogador);
    }


    @GetMapping("/imprimir")
    public List<Jogador> imprimir(){ return jogadorServico.imprimir(); }

}
