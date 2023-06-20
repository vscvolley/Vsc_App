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
@Table(name= "Jogos")
public class Jogos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "equipa1", nullable = false)
    private String Equipa1;

    @Column(name = "equipa2", nullable = false)
    private String Equipa2;

    @Column(name = "resul1", nullable = false)
    private int Resul1;

    @Column(name = "resul2", nullable = false)
    private int Resul2;

    @Column(name = "jogador1", nullable = true)
    private String jogador1;

    @Column(name = "tempojogo1", nullable = true)
    private String tempojogo1;

    @Column(name = "numPontos1", nullable = true)
    private int numPontos1;

    @Column(name = "jogador2", nullable = true)
    private String jogador2;

    @Column(name = "tempojogo2", nullable = true)
    private String tempojogo2;

    @Column(name = "numPontos2", nullable = true)
    private int numPontos2;

    @Column(name = "jogador3", nullable = true)
    private String jogador3;

    @Column(name = "tempojogo3", nullable = true)
    private String tempojogo3;

    @Column(name = "numPontos3", nullable = true)
    private int numPontos3;

    @Column(name = "jogador4", nullable = true)
    private String jogador4;

    @Column(name = "tempojogo4", nullable = true)
    private String tempojogo4;

    @Column(name = "numPontos4", nullable = true)
    private int numPontos4;

    @Column(name = "jogador5", nullable = true)
    private String jogador5;

    @Column(name = "tempojogo5", nullable = true)
    private String tempojogo5;

    @Column(name = "numPontos5", nullable = true)
    private int numPontos5;

    @Column(name = "jogador6", nullable = true)
    private String jogador6;

    @Column(name = "tempojogo6", nullable = true)
    private String tempojogo6;

    @Column(name = "numPontos6", nullable = true)
    private int numPontos6;

}