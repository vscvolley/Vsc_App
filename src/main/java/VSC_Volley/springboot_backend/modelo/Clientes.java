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
@Table(name= "CLIENTES")

public class Clientes {
    @Id     //primary
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    private int id;
    @Column(name = "nome", nullable = false)
    private String Nome;
    @Column(name="password", nullable = false)
    private String Password;
    @Column(name = "email", nullable = false)
    private String Email;

}
