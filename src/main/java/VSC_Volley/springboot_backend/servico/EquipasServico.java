package VSC_Volley.springboot_backend.servico;

import VSC_Volley.springboot_backend.modelo.Equipas;

import java.util.List;

public interface EquipasServico {

    public int getId();

    boolean guardar(Equipas equipas);

    public List<Equipas> imprimir();

    boolean saveall(Equipas equipas, int id);

    String returnString (Equipas equipas);

    public int returnInt (Equipas equipas);


}