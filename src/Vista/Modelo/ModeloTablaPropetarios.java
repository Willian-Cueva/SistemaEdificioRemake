/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelo;

import Modelo.Propietario;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Willian
 */
public class ModeloTablaPropetarios extends AbstractTableModel {

    private ArrayList<Propietario> alp = new ArrayList<>();

    public ArrayList<Propietario> getAlp() {
        return alp;
    }

    public void setAlp(ArrayList<Propietario> alp) {
        if (alp==null) {
            this.alp=new ArrayList<>();
        }
        this.alp = alp;
    }

    @Override
    public int getRowCount() {
        if (alp==null) {
            return 0;
        }
        return alp.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        if (alp==null) {
            return null;
        }
        Propietario p = alp.get(i);
        if (p == null) {
            return null;
        } else {
            switch (i1) {
                case 0:
                    return p.getCodigoDepartamento();
                case 1:
                    return p.getContrasena();
                case 2:
                    return p.getUsuario();
                case 3:
                    return p.getCedula();
                default:
                    return "null";
            }
        }
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "Codigo";
            case 1:
                return "Contrasenia";
            case 2:
                return "Usuario";
            case 3:
                return "Cedula";
            default:
                return "null";
        }
    }

}
