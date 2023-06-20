package VSC_Volley.springboot_backend.repositorio;

import VSC_Volley.springboot_backend.modelo.Ficheiros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ficheirosrepositorio extends JpaRepository<Ficheiros, String> {
}
