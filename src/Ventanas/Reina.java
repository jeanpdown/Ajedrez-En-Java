
package Ventanas;

import java.util.ArrayList;
import javax.swing.JButton;


public class Reina extends Ficha{

    public Reina(String color, String direccionImagen, JButton boton) {
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
            movimientoFichaSegunVariacion(posicionesPosibles,fichas,i*variacionY,i*variacionX);
            if(comprobarRangoIndice(getPosY()+i*variacionY,getPosX()+i*variacionX) && fichas[getPosY()+i*variacionY][getPosX()+i*variacionX]!=null){
                break;
            }
        }
    }
    public void movimientoRecto(ArrayList<String> posicionesPosibles,Ficha fichas[][],int variacionY,int variacionX){
        for(int i=1;i<8;i++){
            movimientoFichaSegunVariacion(posicionesPosibles,fichas,i*variacionY,i*variacionX);
            if(comprobarRangoIndice(getPosY()+i*variacionY,getPosX()+i*variacionX) && fichas[getPosY()+i*variacionY][getPosX()+i*variacionX]!=null){
                break;
            }
        }
    }
}
