package VSC_Volley.springboot_backend.servico;

import VSC_Volley.springboot_backend.modelo.Admin;

public interface Adminservico {

    public Admin pin(Admin admin);
    public boolean verificar(Admin admin);
}
