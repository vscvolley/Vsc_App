package VSC_Volley.springboot_backend.servico;


import VSC_Volley.springboot_backend.modelo.Jogos;
import VSC_Volley.springboot_backend.repositorio.JogosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class JogosServicoImpl implements JogosServico {

    private int id=0;
    public int getId(){ return id; }

    @Autowired
    private JogosRepositorio jogosRepositorio;

    @Override
    public boolean guardar(Jogos jogos) {
        jogosRepositorio.save(jogos);
        if(jogosRepositorio.findAll().contains(jogos)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Jogos> imprimir() {
        return jogosRepositorio.findAll();
    }

    public Jogos detalhes() throws IOException {
        return jogosRepositorio.findAll().get((jogosRepositorio.findAll().size())-1);
    }

}