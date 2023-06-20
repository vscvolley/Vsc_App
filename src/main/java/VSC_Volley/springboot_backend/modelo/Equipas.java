package VSC_Volley.springboot_backend.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "EQUIPAS")
public class Equipas {

    @Id //primary
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "nomeE", nullable = false)
    private String NomeE;

    @Column(name = "numjogadores", nullable = false)
    private int Numjogadores;

    @Column(name = "pontos", nullable = false)
    private int Pontos;

    @Column(updatable = false)
    private boolean Resultado;

    @Column(name = "nJogos", nullable = false)
    private int nJogos;

    @Column(name = "vitorias", nullable = false)
    private int Vitorias;

    @Column(name = "derrotas", nullable = false)
    private int Derrotas;

    public boolean isEmpty() {
        return false;
    }
}