/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Willian
 */
public class Departamento {
    private String nombre;
    private String codigo;
    private String contrasena;
    private String tipo;
    private int capacidad;

    public Departamento(String nombre, String codigo, String contrasena, String tipo, int capacidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.contrasena = contrasena;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public Departamento() {
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return codigo+" "+contrasena+" "+capacidad+" "+nombre+" "+tipo;
    }
    
    
}
