
package com.mycompany.carniceria1.logica;

import com.mycompany.carniceria1.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public Usuario validarUsuario(String nombre, String contrasenia) {
        //creo una lista de tipo usuario para busar el usuairo ingresado por IGU
        return controlPersis.validarUsuario(nombre, contrasenia);
    }

    public List<Producto> traerProductos() {
        return controlPersis.traerProductos();
    }

    public void crearProducto(String nombre, double precio, double stock, String descripcion) {
        Producto produ = new Producto();
        produ.setNombre(nombre);
        produ.setPrecio(precio);
        produ.setStock(stock);
        produ.setDescripcion(descripcion);
        int id = this.buscarUltimaIdProducto();
        produ.setId(id+1);
        controlPersis.crearProducto(produ);
        
    }

    private int buscarUltimaIdProducto() {
    /*
      List <Usuario> listaUsuarios = this.traerUsuarios();
        Usuario usu = listaUsuarios.get(listaUsuarios.size()-1);
        return usu.getId();   
        */
        List <Producto> listaProductos = this.traerProductos();
        Producto produ = listaProductos.get(listaProductos.size()-1);
        return produ.getId();
    }

    public void borrarProducto(int id_producto) {
        controlPersis.borrarProducto(id_producto);
    }

    public Producto traerProducto(int id_producto) {
        return controlPersis.traerProducto(id_producto);
    }

    public void editarProducto(Producto produ, String nombre, double precio, double stock, String descripcion) {
        produ.setNombre(nombre);
        produ.setPrecio(precio);
        produ.setStock(stock);
        produ.setDescripcion(descripcion);
        controlPersis.editarProducto(produ);
    }

    public Producto buscarProductoPorNombre(String nombreProducto) {
        List<Producto> lista = controlPersis.traerProductos();
    for (Producto p : lista) {
        if (p.getNombre().trim().equalsIgnoreCase(nombreProducto.trim())) {
            System.out.println("Producto encontrado: " + p.getId());  // <-- verificación
            return p;
        }
    }
    System.out.println("Producto no encontrado: " + nombreProducto);
    return null;
    }

    public void guardarCompra(Compra compra) {
        controlPersis.guardarCompra(compra);
    }


      
}
