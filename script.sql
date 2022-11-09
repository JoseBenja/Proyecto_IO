CREATE USER pfio WITH PASSWORD 'pfio123';
GRANT CONNECT ON DATABASE proyecto_io TO pfio;
GRANT USAGE ON SCHEMA public TO pfio;
GRANT USAGE, CREATE ON SCHEMA public TO pfio;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO pfio;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA public TO pfio;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT USAGE ON SEQUENCES TO pfio;

CREATE TABLE usuario (
                         id_user serial primary key,
                         nom_user varchar(30),
                         rol_user varchar(20),
                         pass_user varchar(500),
                         estado_user boolean
);

CREATE TABLE repartidor (
                            	id_rep serial primary key,
                            	nom_rep varchar(50),
                            	estado_rep boolean,
                            	capacidad int,
			    	            nombre_usuario varchar(100)
);

CREATE TABLE detalle_producto (
                                  id_prod serial primary key,
                                  nom_prod varchar(30),
                                  desc_prod varchar(100),
                                  precio_prod float,
                                  estado_prod boolean
);

CREATE TABLE detalle_pedido (
                                id_ped serial primary key,
                                nom_rep varchar(100),
                                dir_ped varchar(100),
                                dir_esp_ped varchar(150),
                                nit_cliente_ped varchar(20),
                                correo_cliente_ped varchar(100),
				                fecha_ped date,
				                estado_ped boolean,
				                cantidad_ped int
);

CREATE TABLE producto_shoplist (
                                   id_prod_shoplist serial primary key,
                                   nom_prod varchar(30),
                                   precio_prod float,
                                   estado_shoplist boolean
);

--TRIGGERS
CREATE TABLE bitacora_producto_pedido (
                                          id_bitacora_producto_pedido serial primary key,
                                          usuario varchar(30),
                                          fecha date,
                                          id_prod int,
                                          nom_prod_B varchar(30),
                                          nom_prod_A varchar(30),
                                          desc_prod_B varchar(100),
                                          desc_prod_A varchar(100),
                                          precio_prod_B float,
                                          precio_prod_A float,
                                          estado_prod_B boolean,
                                          estado_prod_A boolean
);

CREATE OR REPLACE FUNCTION funcion_bitacora_prod_ped()
    RETURNS TRIGGER
    LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO bitacora_producto_pedido(usuario,fecha,id_prod,nom_prod_B,nom_prod_A,desc_prod_B,desc_prod_A,precio_prod_B,precio_prod_a,estado_prod_B,estado_prod_A)
    VALUES(user, now(), old.id_prod, old.nom_prod , new.nom_prod, old.desc_prod, new.desc_prod, old.precio_prod, new.precio_prod, old.estado_prod, new.estado_prod);
    RETURN NEW;
END;
$$;

CREATE OR REPLACE TRIGGER bitacora_prod_ped
AFTER INSERT, UPDATE OF nom_prod, desc_prod, precio_prod, estado_prod ON detalle_producto
    FOR EACH ROW
EXECUTE PROCEDURE funcion_bitacora_prod_ped();

