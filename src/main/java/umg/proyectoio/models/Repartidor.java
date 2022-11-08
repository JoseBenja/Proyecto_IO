package umg.proyectoio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="repartidor")
public class Repartidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_rep")
    private int idRep;

    @Getter @Setter @Column(name = "nom_rep")
    private String nombreRep;

    @Getter @Setter @Column(name = "estado_rep")
    private boolean estadoRep;

    @Getter @Setter @Column(name = "capacidad")
    private int capacidadRep;

    @Getter @Setter @Column(name = "nombre_usuario")
    private String nombreUsuarioRep;
}
