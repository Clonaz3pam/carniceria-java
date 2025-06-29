
package com.mycompany.carniceria1.persistencia;

import com.mycompany.carniceria1.logica.Compra;
import com.mycompany.carniceria1.logica.Producto;
import com.mycompany.carniceria1.logica.Usuario;
import com.mycompany.carniceria1.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    ProductoJpaController produJpa = new ProductoJpaController();
    UsuarioJpaController usuJpa = new UsuarioJpaController(); 
    CompraJpaController compraJpa = new CompraJpaController();

    public Usuario validarUsuario(String nombre, String contrasenia) {
        //creo lista
        List <Usuario> listaUsuarios = usuJpa.findUsuarioEntities();
        for (Usuario usu : listaUsuarios) {
            if (usu.getNombreUsuario().equals(nombre) && (usu.getContrasenia().equals(contrasenia))) {
                return usu;
            }
        }
        return null;
    }

    public List<Producto> traerProductos() {
        return produJpa.findProductoEntities();
    }

    public void crearProducto(Producto produ) {
        produJpa.create(produ);
    }

    public void borrarProducto(int id_producto) {
        try {
            produJpa.destroy(id_producto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Producto traerProducto(int id_producto) {
        return produJpa.findProducto(id_producto);
    }

    public void editarProducto(Producto produ) {
        try {
            produJpa.edit(produ);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarCompra(Compra compra) {
        compraJpa.create(compra);
    }



}
