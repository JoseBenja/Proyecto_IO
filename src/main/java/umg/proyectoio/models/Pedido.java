package umg.proyectoio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="detalle_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_ped")
    private int idPedido;

    @Getter @Setter @Column(name = "nom_rep")
    private String nombreRepartidor;

    @Getter @Setter @Column(name = "dir_ped")
    private String dirPedido;

    @Getter @Setter @Column(name = "nit_cliente_ped")
    private String nitClientePedido;

    @Getter @Setter @Column(name = "correo_cliente_ped")
    private String correoClientePedido;

    @Getter @Setter @Column(name = "estado_ped")
    private boolean estadoPedido;

}

