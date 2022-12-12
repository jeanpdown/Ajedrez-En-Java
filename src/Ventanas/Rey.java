
package Ventanas;

import java.util.ArrayList;
import javax.swing.JButton;

public class Rey extends Ficha{

    
    
    public Rey(String color, String direccionImagen, JButton boton) {
        super(color, direccionImagen, boton);
    }

    @Override
    public void movimientosPosibles(ArrayList<String> posicionesPosibles,Ficha fichas[][],int YultimoMov,int XultimoMov){
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,-1,0);//↑
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,0,1);//→
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,0,-1);//←
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,1,0);//↓
        
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,-1,-1);//↖
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,-1,1);//↗
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,1,-1);//↙
        movimientoFichaSegunVariacion(posicionesPosibles,fichas,1,1);//↘
        
        //enroque
        if(this.getMovimientosRealizados()==0 && fichas[getPosY()][0]!=null && fichas[getPosY()][0].getMovimientosRealizados()==0)
            if(fichas[getPosY()][1]==null && fichas[getPosY()][2]==null && fichas[getPosY()][3]==null){
                movimientoFichaSegunVariacion(posicionesPosibles,fichas,0,-2);
            }
        
        if(this.getMovimientosRealizados()==0 && fichas[getPosY()][7]!=null && fichas[getPosY()][7].getMovimientosRealizados()==0)
            if(fichas[getPosY()][5]==null && fichas[getPosY()][6]==null ){
                movimientoFichaSegunVariacion(posicionesPosibles,fichas,0,2);
            }
            
    }
 
}
