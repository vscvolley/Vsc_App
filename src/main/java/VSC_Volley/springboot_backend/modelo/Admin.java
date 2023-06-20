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
@Table(name= "Admin")

public class Admin {
    @Id     //primary
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    private int id;
    @Column(name = "password", nullable = false)
    private Double Pin;
    @Column(name = "email", nullable = false)
    private String Email;

}