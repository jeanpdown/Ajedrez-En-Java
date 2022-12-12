
package Ventanas;

import java.util.ArrayList;
import javax.swing.JButton;


public class Caballo extends Ficha{

    public Caballo(String color, String direccionImagen, JButton boton) {
        super(color, direccionImagen, boton);
    }
    
    
    @Override
    public void movimientosPosibles(ArrayList<String> posicionesPosibles,Ficha fichas[][],int YultimoMov,int XultimoMov){
        
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,-2,1);
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,-2,-1);
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,-1,-2);
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,-1,2);
        
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,2,1);
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,2,-1);
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,1,-2);
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,1,2);
        
    }
   
}
