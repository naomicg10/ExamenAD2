package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Long totalVentas;
    private Boolean estado;

    public Cliente(Long id, String nombre, Long totalVentas, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.totalVentas = totalVentas;
        this.estado = estado;
    }

    public Cliente() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(Long totalVentas) {
        this.totalVentas = totalVentas;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", totalVentas=" + totalVentas +
                ", estado=" + estado +
                '}';
    }
}
