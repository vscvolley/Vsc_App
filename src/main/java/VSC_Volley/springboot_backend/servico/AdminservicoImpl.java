package VSC_Volley.springboot_backend.servico;

import VSC_Volley.springboot_backend.modelo.Admin;
import VSC_Volley.springboot_backend.repositorio.Adminrepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminservicoImpl implements Adminservico {
    @Autowired
    private Adminrepositorio adminRepositorio;
    @Override
    public Admin pin(Admin admin){
        return admin;
    }
    @Override
    public boolean verificar(Admin admin) {
        List<Admin> lista= adminRepositorio.findAll();
        int i=0;
        boolean a =false;
        while(i<lista.size()){
            if (lista.get(i).getPin().equals(admin.getPin())){
                a = true;
                break;
            }
            i++;
        }
        return a;
    }
}
