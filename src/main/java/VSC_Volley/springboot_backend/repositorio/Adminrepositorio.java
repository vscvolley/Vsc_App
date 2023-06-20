package VSC_Volley.springboot_backend.repositorio;

import VSC_Volley.springboot_backend.modelo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Adminrepositorio extends JpaRepository<Admin,Integer> {

}