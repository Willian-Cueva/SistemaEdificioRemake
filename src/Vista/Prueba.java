/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorDepartamentos;
import Controlador.Utiles.Utiles;

/**
 *
 * @author Willian
 */
public class Prueba {
    public static void main(String[] args) {
        ControladorDepartamentos cd = new ControladorDepartamentos();
        cd.setListaDepartamentos(Utiles.cargar_Lista_Departamentos());
        cd.setListaPropietarios(Utiles.cargarListaPropietarios());
        System.out.println(cd.getListaDepartamentos());
        System.out.println("000000000000000000000000000000000000000000000000");
        
//        cd.setDepartamento(null);
//        cd.getDepartamento().setCodigo("0");
//        cd.getDepartamento().setContrasena("123david1");
//        cd.getDepartamento().setCapacidad(3);
//        cd.getDepartamento().setNombre("cristopher");
//        cd.getDepartamento().setTipo("Departamento");
//        if (cd.ingresarDepartamento()) {
//            System.out.println("Se ingreso el departamento correctamente");
//        } else {
//            System.err.println("No se ingreso el departamento");
//        }
//        System.out.println(cd.getListaDepartamentos());
//        System.out.println("000000000000000000000000000000000000000000000000");
        
        System.out.println("0000000000 Ingresando Departamentos 00000000000");
        cd.setDepartamento(null);
        String[] s=new String[4];
        s[0]="123davidGay";
        s[1]="3";
        s[2]="Depa Cris";
        s[3]="Departamento";
        if (cd.ingresarDepartamento(s)) {
            System.out.println("Se ingreso el departamento correctamente");
        } else {
            System.err.println("No se ingreso el departamento");
        }
        cd.setDepartamento(null);
        cd.mostrarDepartamentos();
        System.out.println("000000000000000000000000000000000000000000000000");
        
        System.out.println("><><><>>< Insertando un Propietario <><><><>><");
        cd.setPropietario(null);
        String[] p = new String[2];
        p[0]="Usuario";
        p[1]="Cedula";
        if (cd.ingresarPropietario(p,cd.getListaDepartamentos().get(1))) {
            System.out.println("Propietario Ingresado");
        } else {
            System.err.println("No se ingreso el Propietario");
        }
        System.out.println(cd.getListaPropietarios());
        cd.setPropietario(null);
        System.out.println("><><><>><>><><><>><><<><><><><><<><><><><>><");
        
        
    }
}
