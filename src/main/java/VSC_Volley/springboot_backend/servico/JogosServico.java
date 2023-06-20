package VSC_Volley.springboot_backend.servico;

import VSC_Volley.springboot_backend.modelo.Jogos;


import java.io.IOException;
import java.util.List;

public interface JogosServico {

    public int getId();

    public boolean guardar(Jogos jogos);

    public List<Jogos> imprimir();

    public Jogos detalhes() throws IOException;
}
