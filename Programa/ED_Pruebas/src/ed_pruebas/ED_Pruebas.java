/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_pruebas;

import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class ED_Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JOptionPane.showMessageDialog(null, insertar());
        
    }
    
    public static String insertar(){
        
        int x,y;
        x = Integer.parseInt(JOptionPane.showInputDialog("numero 1"));
        y = Integer.parseInt(JOptionPane.showInputDialog("numero 2"));
        
        return calcular(x,y);
        
    }
    
    public static String calcular(int x, int y){
        String dato="";
        
        if(x>y){
            dato = "numero 1 es mayor que el numero 2";
        }
        else if(y>x){
            dato = "numero 2 es mayor que el numero 1";
        }
        else if(x==y){
            dato = "son iguales";
        }
        
        return dato;
    }
    
}
