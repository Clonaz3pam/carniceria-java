
package com.mycompany.carniceria1.logica;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compra implements Serializable {
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private int id;
    private Date fecha;
    private LocalTime hora;
    
    private Usuario usuario;
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List <DetalleCompra> listaDetalles;

    public Compra() {
    }

    public Compra(int id, Date fecha, LocalTime hora, Usuario usuario, List<DetalleCompra> listaDetalles) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.usuario = usuario;
        this.listaDetalles = listaDetalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetalleCompra> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetalleCompra> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
    
    
}
