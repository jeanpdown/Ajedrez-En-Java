
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
        for(int i=1;i<8;i++){
            movimientoFichaSegunVariacion(posicionesPosibles,fichas,0,i);
            if(comprobarRangoIndice(getPosY(),getPosX()+i) && fichas[getPosY()][getPosX()+i]!=null){
                break;
            }
        }
        //  ←←←←←←
        for(int i=-1;i>-8;i--){
            movimientoFichaSegunVariacion(posicionesPosibles,fichas,0,i);
            if(comprobarRangoIndice(getPosY(),getPosX()+i) && fichas[getPosY()][getPosX()+i]!=null){
                break;
            }
        }
        //  ↑↑↑↑↑↑
        for(int i=1;i<8;i++){
            movimientoFichaSegunVariacion(posicionesPosibles,fichas,i,0);
            if(comprobarRangoIndice(getPosY()+i,getPosX()) && fichas[getPosY()+i][getPosX()]!=null){
                break;
            }
        }
        //  ↓↓↓↓↓↓
        for(int i=-1;i>-8;i--){
            movimientoFichaSegunVariacion(posicionesPosibles,fichas,i,0);
            if(comprobarRangoIndice(getPosY()+i,getPosX()) && fichas[getPosY()+i][getPosX()]!=null){
                break;
            }
        }
    }

}
