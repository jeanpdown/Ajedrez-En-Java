
package Ventanas;

import java.util.ArrayList;
import javax.swing.JButton;

public class Alfil extends Ficha{

    public Alfil(String color, String direccionImagen, JButton boton) {
        super(color, direccionImagen, boton);
    }

    @Override
    public void movimientosPosibles(ArrayList<String> posicionesPosibles,Ficha fichas[][],int YultimoMov,int XultimoMov){
        
        //     ↖↖↖↖↖↖  
        movimientoDiagonal(posicionesPosibles,fichas,-1,-1);
        //     ↗↗↗↗↗↗
        movimientoDiagonal(posicionesPosibles,fichas,-1,1);
        //     ↙↙↙↙↙↙  
        movimientoDiagonal(posicionesPosibles,fichas,1,-1);
        //     ↘↘↘↘↘↘
        movimientoDiagonal(posicionesPosibles,fichas,1,1);
        
    }
    
    public void movimientoDiagonal(ArrayList<String> posicionesPosibles,Ficha fichas[][],int variacionY,int variacionX){
        
        for(int i=1;i<8;i++){
            if(!movimientoFichaSegunVariacion(posicionesPosibles,fichas,i*variacionY,i*variacionX)){
                break;
            }
        }
    }
}
