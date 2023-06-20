package VSC_Volley.springboot_backend.controle;

import VSC_Volley.springboot_backend.modelo.Admin;
import VSC_Volley.springboot_backend.servico.Adminservico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Admin")
@CrossOrigin
public class ControlAdmin {
    @Autowired
    private Adminservico Adminservico;

    @PostMapping("/pin")
    public boolean pin (@RequestBody Admin admin){
        return verificar(Adminservico.pin(admin));
    }

    @GetMapping("/verificar")
    public boolean verificar(Admin admin){
        return Adminservico.verificar(admin);
    }

}