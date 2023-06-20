package VSC_Volley.springboot_backend.servico;

import VSC_Volley.springboot_backend.modelo.Jogador;

import java.util.List;

public interface JogadorServico {

    public int getId();

    public boolean guardar(Jogador jogador);

    public List<Jogador> imprimir();

    public String[] nomes();

}