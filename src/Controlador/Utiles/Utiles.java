/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Utiles;

import Modelo.Departamento;
import Modelo.Enums.Tipo;
import Modelo.Propietario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Willian
 */
public class Utiles {

    public static Tipo[] obtenerTipos() {
        return Tipo.values();
    }

    public static Boolean autenticar_Propietario(Departamento departamento, String usuario, String contrasenia) {
        ArrayList<Propietario> pro = cargarListaPropietarios();
        Boolean chis = false;
        for (Propietario propietario : pro) {
            if (departamento.getCodigo().equals(propietario.getCodigoDepartamento()) && 
                    departamento.getContrasena().equals(contrasenia) &&
                        propietario.getUsuario().equals(usuario)) {
                chis=true;
                break;
            }
        }
        return chis;
    }

    public static void eliminarPropietarios(ArrayList<Propietario> listaPropietarios, Departamento departamento) {
        ArrayList<Integer> cont = new ArrayList<>();
        for (int i = 0; i < listaPropietarios.size(); i++) {
            if (listaPropietarios.get(i).getCodigoDepartamento().equals(departamento.getCodigo())) {
                cont.add(i);
            }
        }
        for (int i = 0; i < cont.size(); i++) {
            listaPropietarios.remove(cont.get(i) - i);
        }
    }

    public static void actualizarPropietarios(ArrayList<Propietario> listaPropietarios) {
        File f = new File("Propietarios.txt");
        try {
            FileWriter fw = new FileWriter(f);
            for (Propietario listaPropietario : listaPropietarios) {
                String[] p = new String[4];
                p[0] = listaPropietario.getCodigoDepartamento() + ",";
                p[1] = listaPropietario.getContrasena() + ",";
                p[2] = listaPropietario.getUsuario() + ",";
                p[3] = listaPropietario.getCedula();
                String linea = "";
                for (int i = 0; i < 4; i++) {
                    linea += p[i];
                }
                fw.write(linea + "\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error al cargar Propietarios.txt\n" + ex);
        }

    }

    public static void actualizarDepartamentos(ArrayList<Departamento> listaDepartamentos) {
        File f = new File("Departamentos.txt");
        try {
            FileWriter fw = new FileWriter(f);
            for (Departamento departamento : listaDepartamentos) {
                String[] l = new String[5];
                l[0] = departamento.getCodigo() + ",";
                l[1] = departamento.getContrasena() + ",";
                l[2] = departamento.getCapacidad() + ",";
                l[3] = departamento.getNombre() + ",";
                l[4] = departamento.getTipo();
                String linea = "";
                for (int i = 0; i < 5; i++) {
                    linea += l[i];
                }
                fw.write(linea + "\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error al cargar Departamentos.txt\n" + ex);
        }
    }

    public static int obtenerNumeroPropietarios(Departamento d) {
        int cont = 0;
        File f = new File("Propietarios.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = null;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                if (d.getCodigo().equals(st.nextToken())) {
                    cont++;
                }
            }
            return cont;
        } catch (FileNotFoundException ex) {
            System.err.println("Error al cargar el archivo Propietarios.txt\n" + ex);
            return -1;
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo Propietarios.txt (while)\n" + ex);
            return -1;
        }

    }

    public static String obtenerIdDepertamento(ArrayList<Departamento> ld) {
        if (ld == null) {
            return "0";
        }
        int n = ld.size();
        String s = String.valueOf(n);
        return s;
    }

    public static Boolean autenticar_admin(String u, String p) {
        //u usuario
        //p contrasenia
        String user = "", pas = "";
        File f = new File("Administrador.txt");
        Boolean verif = false;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                String linea = br.readLine();
                StringTokenizer st = new StringTokenizer(linea, ",");
                user = st.nextToken();
                pas = st.nextToken();
                if (user.equals(u) && pas.equals(p)) {
                    verif = true;
                }
                fr.close();
            } catch (IOException ex) {
//                Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error al leer la linea dentro de Administrador.txt\n" + ex);
                return false;
            }
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al cargar el Archivo Administradr.tx\n" + ex);
            return false;
        }
        return verif;
    }

//    public Boolean permitirAcceso(String codigo,String usuario,String pas){
//        Boolean acc=false;
//        
//    }
    public static ArrayList<Departamento> cargar_Lista_Departamentos() {
        ArrayList<Departamento> lista = new ArrayList<>();

        File f = new File("Departamentos.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = null;
            try {
                while ((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");
                    Departamento d = new Departamento();
                    d.setCodigo(st.nextToken());
                    d.setContrasena(st.nextToken());
                    d.setCapacidad(Integer.parseInt(st.nextToken()));
                    d.setNombre(st.nextToken());
                    d.setTipo(st.nextToken());
                    lista.add(d);
                }
                fr.close();
            } catch (IOException ex) {
//                Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error al leer el archivo Departamentos.txt\n" + ex);
                return null;
            }
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al cargar el archivo Departamentos.txt\n" + ex);
            return null;
        }
        return (lista.isEmpty()) ? null : lista;
    }

    public static ArrayList<Propietario> cargarListaPropietarios() {
        ArrayList<Propietario> lista = new ArrayList<>();
        File f = new File("Propietarios.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String linea = null;
            try {
                while ((linea = bf.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");
                    Propietario p = new Propietario();
                    p.setCodigoDepartamento(st.nextToken());
                    p.setContrasena(st.nextToken());
                    p.setUsuario(st.nextToken());
                    p.setCedula(st.nextToken());
                    lista.add(p);
                }
                fr.close();
            } catch (IOException ex) {
//                Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error al leer el archivo Propietarios.txt \n" + ex);
                return null;
            }
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Utiles.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al cargar el archivo Propietarios.txt\n " + ex);
            return null;
        }
        return (lista.isEmpty()) ? null : lista;
    }

    public static ArrayList<Propietario> obtenerPropietarios_de_un_Departamento(Departamento d, ArrayList<Propietario> lp) {
        if (lp == null) {
            return null;
        }
        ArrayList<Propietario> lista = new ArrayList<>();
        for (Propietario propietario : lp) {
            if (d.getCodigo().equals(propietario.getCodigoDepartamento())) {
                lista.add(propietario);
            }
        }
        return lista;
    }
}
