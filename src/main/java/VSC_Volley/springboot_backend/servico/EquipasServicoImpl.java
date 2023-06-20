package VSC_Volley.springboot_backend.servico;

import VSC_Volley.springboot_backend.modelo.Equipas;
import VSC_Volley.springboot_backend.modelo.Reverse;
import VSC_Volley.springboot_backend.repositorio.EquipasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipasServicoImpl implements EquipasServico {

    @Autowired
    private EquipasRepositorio equipasRepositorio;

    private int id=0;

    public int getId() {
        return id;
    }

    @Override
    public boolean guardar(Equipas equipas) {
        equipasRepositorio.save(equipas);
        if(equipasRepositorio.findAll().contains(equipas)){
            return true;
        }
        return false;
    }

    @Override
    public List<Equipas> imprimir() {
        return equipasRepositorio.findAll();
    }

    @Override
    public boolean saveall(Equipas equipas, int id) {
        return false;
    }

    public String returnString (Equipas equipas) {
        List<Equipas> lista = imprimir();
        int i = 0;
        while (i < lista.size()) {
            if (lista.get(i).getNomeE().equals(equipas.getNomeE())) {
                return equipas.getNomeE();
            }
            else {
                i++;
            }
        }
        return "Equipa não encontrada";
    }

    public int returnInt (Equipas equipas) {
        List<Equipas> lista = imprimir();
        int i = 0;
        while (i < lista.size()) {
            if (lista.get(i).getNJogos() == equipas.getNJogos()) {
                return equipas.getNJogos() + equipas.getPontos() + equipas.getVitorias() + equipas.getDerrotas();
            }
            i++;
        }
        return 0;
    }

    public boolean apagar(Reverse reverse){
        if(reverse.getId()==0){
            return false;
        }
        equipasRepositorio.deleteById(reverse.getId());
        boolean b = !equipasRepositorio.existsById(reverse.getId());
        return b;
    }

    public String returnNomeE(){
        List<Equipas> l=equipasRepositorio.findAll();
        return l.get(id).getNomeE();
    }

    public int returnNJogos(){
        List<Equipas> l=equipasRepositorio.findAll();
        return l.get(id).getNJogos();
    }



}