package VSC_Volley.springboot_backend.servico;

import VSC_Volley.springboot_backend.modelo.Admin;
import VSC_Volley.springboot_backend.modelo.Clientes;
import VSC_Volley.springboot_backend.modelo.Reverse;
import VSC_Volley.springboot_backend.repositorio.Adminrepositorio;
import VSC_Volley.springboot_backend.repositorio.ClientesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientesServicoImpl implements ClientesServico{
    @Autowired
    private ClientesRepositorio clientesRepositorio;
    @Autowired
    private Adminrepositorio adminRepositorio;
    private int id=0;
    private int id1=0;

    public int getId() {
        return id;
    }
    @Override
    public boolean guardar(Clientes clientes) {
        if(clientes.getNome().isEmpty()|| clientes.getPassword().isEmpty() ||clientes.getEmail().isEmpty()){
            return false;
        }
        else{clientesRepositorio.save(clientes);}
        return true;
    }

    @Override
    public List<Clientes> imprimir(){
        return clientesRepositorio.findAll();
    }

    public int pesquiza(Clientes clientes){
        List<Clientes> lista= imprimir();
        int i=0;
        while(i<lista.size()){
            if (lista.get(i).getEmail().equals(clientes.getEmail()) || lista.get(i).getPassword().equals(clientes.getPassword())|| lista.get(i).getNome().equals(clientes.getNome())) {
                id=i;
            }
            i++;
        }
        return id;
    }

    @Override
    public boolean delete( Reverse reverse){
        if(reverse.getId()==0){
            return false;
        }
        clientesRepositorio.deleteById(reverse.getId());
        return !clientesRepositorio.existsById(reverse.getId());
    }
    @Override
    public Clientes dados(Clientes clientes){
        return clientes;
    }
    @Override
    public boolean login(Clientes clientes){
        List<Clientes> lista= imprimir();
        int i=0;
        while(i<lista.size()){
            if (lista.get(i).getEmail().equals(clientes.getEmail()) && lista.get(i).getPassword().equals(clientes.getPassword())) {
                id1=i;
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean recuperar(Clientes clientes){
        List<Clientes> lista= imprimir();
        int j=0;

            while(j<lista.size()){
                if (lista.get(j).getEmail().equals(clientes.getEmail()) && !(clientes.getEmail().isEmpty())){
                   id=j;
                   return true;
                }
            j++;
            }
        return false;
    }

    public boolean saveall(Clientes clientes,int id){
        List<Clientes> lista= clientesRepositorio.findAll();
        if(!(clientes.getPassword().isEmpty())){
            lista.get(id).setPassword(clientes.getPassword());
            clientesRepositorio.saveAll(lista);
            return true;
        }
        return false;
    }

    public String email(){
        List<Clientes> l=clientesRepositorio.findAll();
        return l.get(id1).getEmail();
    }
    public String nome(){
        List<Clientes> l=clientesRepositorio.findAll();
        return l.get(id1).getNome();
    }

    public boolean admin(){
        List<Clientes> l=clientesRepositorio.findAll();
        List<Admin> a=adminRepositorio.findAll();
        int w=0;
        while(w<a.size()){
            if(a.get(w).getEmail().equals(l.get(id1).getEmail()))
                return true;
        }
        return false;
    }

}
