package VSC_Volley.springboot_backend.servico;

import VSC_Volley.springboot_backend.modelo.Clientes;
import VSC_Volley.springboot_backend.modelo.Reverse;

import java.util.List;

public interface ClientesServico {

    public int getId();
    public boolean guardar(Clientes clientes);
    List<Clientes> imprimir();

    int pesquiza(Clientes clientes);

    boolean delete(Reverse reverse);

    Clientes dados(Clientes clientes);
    boolean login(Clientes clientes);

    boolean recuperar(Clientes clientes);

    boolean saveall(Clientes clientes,int id);

    public String nome();

    public String email();

    public boolean admin();

}
