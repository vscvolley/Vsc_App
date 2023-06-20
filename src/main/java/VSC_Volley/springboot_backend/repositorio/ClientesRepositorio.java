package VSC_Volley.springboot_backend.repositorio;

import VSC_Volley.springboot_backend.modelo.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepositorio extends JpaRepository<Clientes,Integer> {

}
