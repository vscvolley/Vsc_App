package VSC_Volley.springboot_backend.modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Ficheiros")
public class Ficheiros {
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid2")
        private String id;

        private String nome;

        private String type;

        @Lob
        @Column(name = "data", columnDefinition="MEDIUMBLOB")
        private byte[] data;

        public Ficheiros() {
        }

        public Ficheiros(String nome, String type, byte[] data) {
            this.nome = nome;
            this.type = type;
            this.data = data;
        }

        public String getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }


}
