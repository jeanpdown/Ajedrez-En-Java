
package Ventanas;

import java.util.ArrayList;
import javax.swing.JButton;

public class Torre extends Ficha{

    public Torre(String color, String direccionImagen, JButton boton) {
        super(color, direccionImagen, boton);
    }

    @Override
    public void movimientosPosibles(ArrayList<String> posicionesPosibles,Ficha fichas[][],int YultimoMov,int XultimoMov){
        //  →→→→→→
        movimientoRecto(posicionesPosibles,fichas,0,1);
        //  ←←←←←←
        movimientoRecto(posicionesPosibles,fichas,0,-1);
        //  ↑↑↑↑↑↑
        movimientoRecto(posicionesPosibles,fichas,1,0);
        //  ↓↓↓↓↓↓
        movimientoRecto(posicionesPosibles,fichas,-1,0);
    }

    public void movimientoRecto(ArrayList<String> posicionesPosibles,Ficha fichas[][],int variacionY,int variacionX){
        for(int i=1;i<8;i++){
            if(!movimientoFichaSegunVariacion(posicionesPosibles,fichas,i*variacionY,i*variacionX)){
                break;
            }
        }
    }

}
