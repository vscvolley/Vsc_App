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
@Table(name= "Jogador")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false)
    private String Nome;

    @Column(name = "numJogador", nullable = false)
    private int NumJogador;

    @Column(name = "posicao", nullable = false)
    private String Posicao;

    @Column(name = "tempoJogo", nullable = true)
    private int TempoJogo;
}
