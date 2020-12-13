/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Utiles;

import Controlador.Utiles.Utiles;
import javax.swing.JComboBox;

/**
 *
 * @author Willian
 */
public class UtilidadesComponentes {
    public static void cargarTipos(JComboBox cbx){
        cbx.removeAllItems();
        for (int i = 0; i < Utiles.obtenerTipos().length; i++) {
            cbx.addItem(Utiles.obtenerTipos()[i]);
        }
    }
}
