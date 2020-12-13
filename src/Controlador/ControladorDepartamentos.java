/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Utiles.Utiles;
import Modelo.Departamento;
import Modelo.Propietario;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class ControladorDepartamentos {

    private ArrayList<Propietario> listaPropietarios = new ArrayList<>();
    private ArrayList<Departamento> listaDepartamentos = new ArrayList<>();
    private Propietario propietario = new Propietario();
    private Departamento departamento = new Departamento();

    public ArrayList<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void mostrarDepartamentos() {
        if (listaDepartamentos == null) {
            System.out.println("No hay departamentos");
        } else {
            for (Departamento depa : listaDepartamentos) {
                System.out.println(depa.toString());
            }
        }
    }
    
    public Boolean eliminarDepartamento(int s){
        if (s==-1) {
            return false;
        } else {
            try {
            Utiles.eliminarPropietarios(listaPropietarios, listaDepartamentos.get(s));
            Utiles.actualizarPropietarios(listaPropietarios);
            listaDepartamentos.remove(s);
            Utiles.actualizarDepartamentos(listaDepartamentos);
            return true;
                
            } catch (Exception e) {
                System.out.println("Error al actualizar\n"+e);
                return false;
            }
        }
    }
    
    public Boolean ingresarPropietario(String[] p, Departamento d) {
        if (Utiles.obtenerNumeroPropietarios(d) >= d.getCapacidad()) {
            System.out.println("Departamento lleno");
            JOptionPane.showMessageDialog(null, "Departamento Lleno");
            return false;
        } else {
            File f = new File("Propietarios.txt");
            if (propietario == null) {
                this.propietario = new Propietario();
            }
            if (listaPropietarios == null) {
                this.listaPropietarios = new ArrayList<>();
            }
            String[] lp = new String[4];
            lp[0] = d.getCodigo();
            lp[1] = d.getContrasena();
            lp[2] = p[0];
            lp[3] = p[1];
            String linea = "";
            for (int i = 0; i < 4; i++) {
                linea += lp[i] + ",";
            }
            try {

                FileWriter fr = new FileWriter(f.getAbsoluteFile(), true);
                fr.write(linea + "\n");
                fr.close();

                propietario.setCodigoDepartamento(lp[0]);
                propietario.setContrasena(lp[1]);
                propietario.setUsuario(lp[2]);
                propietario.setCedula(lp[3]);

                listaPropietarios.add(propietario);
                return true;

            } catch (IOException ex) {
                System.out.println("NO se encontro el archivo Propietarios.txt\n" + ex);
                return false;
            }
        }

    }

    public Boolean ingresarDepartamento(String[] s) {
        File f = new File("Departamentos.txt");
        if (departamento == null) {
            this.departamento = new Departamento();
        }
        if (listaDepartamentos == null) {
            this.listaDepartamentos = new ArrayList<>();
        }
        departamento.setCodigo(Utiles.obtenerIdDepertamento(listaDepartamentos));
        departamento.setContrasena(s[0]);
        departamento.setCapacidad(Integer.valueOf(s[1]));
        departamento.setNombre(s[2]);
        departamento.setTipo(s[3]);
        String linea = Utiles.obtenerIdDepertamento(listaDepartamentos) + ",";
        for (int i = 0; i < 4; i++) {
            linea += (s[i] + ",");
        }
        try {
            FileWriter fr = new FileWriter(f.getAbsoluteFile(), true);
            fr.write(linea + "\n");
            fr.close();
            listaDepartamentos.add(getDepartamentoClon());
            return true;
        } catch (IOException ex) {
//            Logger.getLogger(ControladorDepartamentos.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al cargar al archivo Departamentos.txt\n" + ex);
            return false;
        }
    }

    public void setListaPropietarios(ArrayList<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }

    public ArrayList<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(ArrayList<Departamento> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public Propietario getPropietarioClon() {
        Propietario x = new Propietario();
        x.setCedula(this.propietario.getCedula());
        x.setCodigoDepartamento(this.propietario.getCodigoDepartamento());
        x.setContrasena(this.propietario.getContrasena());
        x.setUsuario(this.propietario.getUsuario());
        return x;
    }

    public Propietario getPropietario() {
        if (propietario == null) {
            this.propietario = new Propietario();
        }
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Departamento getDepartamentoClon() {
        Departamento x = new Departamento();
        x.setCapacidad(this.departamento.getCapacidad());
        x.setCodigo(this.departamento.getCodigo());
        x.setContrasena(this.departamento.getContrasena());
        x.setNombre(this.departamento.getNombre());
        x.setTipo(this.departamento.getTipo());
        return x;
    }

    public Departamento getDepartamento() {
        if (departamento == null) {
            this.departamento = new Departamento();
        }
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
