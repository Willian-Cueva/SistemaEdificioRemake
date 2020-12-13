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
public class Propietario {
    private String usuario;
    private String contrasena;
    private String cedula;
    private String codigoDepartamento;

    public Propietario(String usuario, String contrasena, String cedula, String codigoDepartamento) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.cedula = cedula;
        this.codigoDepartamento = codigoDepartamento;
    }

    public Propietario() {
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    @Override
    public String toString() {
        return codigoDepartamento+" - "+contrasena+" - "+usuario+" - "+cedula+"\n";
    }
}
