/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelo;

import Modelo.Departamento;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Willian
 */
public class ModeloTablaVentanaPropietarios extends AbstractTableModel{
    private ArrayList<Departamento> lista = new ArrayList<>();

    public ArrayList<Departamento> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Departamento> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        if (lista==null) {
            return 0;
        } 
        return (lista.isEmpty()) ? 0 : lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Departamento d=lista.get(i);
        switch(i1){
            case 0: return d.getNombre();
            case 1: return d.getTipo();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "Nombre";
            case 1:return "Tipo";
            default:return null;
        }
    }
}
