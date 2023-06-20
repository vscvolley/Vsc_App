package VSC_Volley.springboot_backend.controle;

import VSC_Volley.springboot_backend.modelo.Clientes;
import VSC_Volley.springboot_backend.modelo.Reverse;
import VSC_Volley.springboot_backend.servico.ClientesServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Clientes")
@CrossOrigin
public class ControloClientes {
    @Autowired
    private ClientesServico clientesServico;

    @PostMapping("/add")
    public boolean add(@RequestBody Clientes clientes){
        if(!(login(clientes))){
        return clientesServico.guardar(clientes);}

        else return false;
    }

    @GetMapping("/imprimir")
    public List<Clientes> imprir(){
        return clientesServico.imprimir();
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Reverse reverse){
        clientesServico.delete(reverse);
        if(clientesServico.delete(reverse))
        return "Cliente apagado";
        else return "erro";
    }
    @GetMapping("/login")
    public boolean login(Clientes clientes){
        return clientesServico.login(clientes);
    }
    @PostMapping("/dados")
    public boolean dados (@RequestBody Clientes clientes){
        return login(clientesServico.dados(clientes));
    }

    @PostMapping("/dados1")
    public boolean dados1 (@RequestBody Clientes clientes){
        return add(clientes);
    }

    @GetMapping("/recuperar")
    public boolean recuperar(Clientes clientes){
        return clientesServico.recuperar(clientes);
    }

    @PostMapping("/dados2")
    public boolean dados2 (@RequestBody Clientes clientes){
        return recuperar(clientesServico.dados(clientes));
    }

    @GetMapping("/email")
    public String email(){
        return clientesServico.email();
    }

    @GetMapping("/nome")
    public String nome(){
        return clientesServico.nome();
    }

    @GetMapping("/admin")
    public boolean admin(){
        return clientesServico.admin();
    }

    @GetMapping("/saveall")
    public boolean saveall(Clientes clientes,int id){return clientesServico.saveall(clientes,id);}

    @PostMapping("/dados3")
   public boolean dados3(@RequestBody Clientes clientes){return saveall(clientes, clientesServico.getId());}
}
