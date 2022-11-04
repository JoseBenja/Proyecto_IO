package umg.proyectoio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_user")
    private int idUsuario;

    @Getter @Setter @Column(name = "nom_user")
    private String nombreUsuario;

    @Getter @Setter @Column(name = "rol_user")
    private String rol;

    @Getter @Setter @Column(name = "pass_user")
    private String password;

    @Getter @Setter @Column(name = "estado_user")
    private boolean estado;

}