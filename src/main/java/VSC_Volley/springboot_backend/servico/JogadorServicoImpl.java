package VSC_Volley.springboot_backend.servico;


import VSC_Volley.springboot_backend.modelo.Jogador;
import VSC_Volley.springboot_backend.repositorio.JogadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorServicoImpl implements JogadorServico{
    @Autowired
    private JogadorRepositorio jogadorRepositorio;

    private int id=0;

    public int getId(){return  id;}

    @Override
    public boolean guardar(Jogador jogador) {
        jogadorRepositorio.save(jogador);
        if(jogadorRepositorio.findAll().contains(jogador)){
            return true;
        }
        return false;
    }

    @Override
    public List<Jogador> imprimir() { return jogadorRepositorio.findAll(); }

    public String[] nomes(){
        List<Jogador> j =imprimir();
        int i=0;
        String nomes[]=new String[j.size()];

        while(i<j.size()){
            nomes[i]=j.get(i).getNome();
            i++;
        }
        return nomes;
    }
}
