package VSC_Volley.springboot_backend.repositorio;

import VSC_Volley.springboot_backend.modelo.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepositorio extends JpaRepository<Jogador,Integer> {
}
