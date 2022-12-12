
package Ventanas;

import java.util.ArrayList;
import javax.swing.JButton;


public class Peon extends Ficha{

    public Peon(String color, String direccionImagen, JButton boton) {
        super(color, direccionImagen, boton);
    }
    

    
    @Override
    public void movimientosPosibles(ArrayList<String> posicionesPosibles,Ficha fichas[][],int YultimoMov,int XultimoMov){
        
        
        
        if(getColor().equals("blanco")){
            if(comprobarRangoIndice(getPosY()-2,getPosX()) && getPosY()==6 && fichas[getPosY()-2][getPosX()]==null && fichas[getPosY()-1][getPosX()]==null){
                posicionesPosibles.add(""+(getPosY()-2)+" "+getPosX());
            }
            //movimiento especial peon
            if(comprobarRangoIndice(getPosY(),getPosX()+1) && fichas[getPosY()][getPosX()+1]!=null && getPosY()==3 && fichas[getPosY()][getPosX()+1] instanceof Peon){
                if(fichas[getPosY()][getPosX()+1].getMovimientosRealizados()==1 && fichas[getPosY()][getPosX()+1].getPosY()==YultimoMov && fichas[getPosY()][getPosX()+1].getPosX()==XultimoMov){
                    posicionesPosibles.add(""+(getPosY()-1)+" "+(getPosX()+1));
                }
            }
            if(comprobarRangoIndice(getPosY(),getPosX()-1) && fichas[getPosY()][getPosX()-1]!=null && getPosY()==3 && fichas[getPosY()][getPosX()-1] instanceof Peon){

                if(fichas[getPosY()][getPosX()-1].getMovimientosRealizados()==1 && fichas[getPosY()][getPosX()-1].getPosY()==YultimoMov && fichas[getPosY()][getPosX()-1].getPosX()==XultimoMov){
                    posicionesPosibles.add(""+(getPosY()-1)+" "+(getPosX()-1));
                }
            }//termina mov especial
            if(comprobarRangoIndice(getPosY()-1,getPosX()) && fichas[getPosY()-1][getPosX()]==null){
                posicionesPosibles.add(""+(getPosY()-1)+" "+getPosX());
            }
            if(comprobarRangoIndice(getPosY()-1,getPosX()+1) && fichas[getPosY()-1][getPosX()+1] != null){
                if(fichas[getPosY()-1][getPosX()+1].getColor().equals("negro")){
                    posicionesPosibles.add(""+(getPosY()-1)+" "+(getPosX()+1));
                }
            }
            if(comprobarRangoIndice(getPosY()-1,getPosX()-1) && fichas[getPosY()-1][getPosX()-1] != null){
                if(fichas[getPosY()-1][getPosX()-1].getColor().equals("negro")){
                    posicionesPosibles.add(""+(getPosY()-1)+" "+(getPosX()-1));
                }
            }
        }else{
            if(comprobarRangoIndice(getPosY()+2,getPosX()) && getPosY()==1 && fichas[getPosY()+2][getPosX()]==null && fichas[getPosY()+1][getPosX()]==null){
                posicionesPosibles.add(""+(getPosY()+2)+" "+getPosX());
            }
            if(comprobarRangoIndice(getPosY()+1,getPosX()) && fichas[getPosY()+1][getPosX()]==null){
                posicionesPosibles.add(""+(getPosY()+1)+" "+getPosX());
            }
            //movimiento especial peon
            if(comprobarRangoIndice(getPosY(),getPosX()+1) && fichas[getPosY()][getPosX()+1]!=null && getPosY()==4 && fichas[getPosY()][getPosX()+1] instanceof Peon){
                if(fichas[getPosY()][getPosX()+1].getMovimientosRealizados()==1 && fichas[getPosY()][getPosX()+1].getPosY()==YultimoMov && fichas[getPosY()][getPosX()+1].getPosX()==XultimoMov){
                    posicionesPosibles.add(""+(getPosY()+1)+" "+(getPosX()+1));
                }
            }
            if(comprobarRangoIndice(getPosY(),getPosX()-1) && fichas[getPosY()][getPosX()-1]!=null && getPosY()==4 && fichas[getPosY()][getPosX()-1] instanceof Peon){

                if(fichas[getPosY()][getPosX()-1].getMovimientosRealizados()==1 && fichas[getPosY()][getPosX()-1].getPosY()==YultimoMov && fichas[getPosY()][getPosX()-1].getPosX()==XultimoMov){
                    posicionesPosibles.add(""+(getPosY()+1)+" "+(getPosX()-1));
                }
            }//termina mov especial
            if(comprobarRangoIndice(getPosY()+1,getPosX()+1) && fichas[getPosY()+1][getPosX()+1] != null){
                if(fichas[getPosY()+1][getPosX()+1].getColor().equals("blanco")){
                    posicionesPosibles.add(""+(getPosY()+1)+" "+(getPosX()+1));
                }
            }
            if(comprobarRangoIndice(getPosY()+1,getPosX()-1) && fichas[getPosY()+1][getPosX()-1] != null){
                if(fichas[getPosY()+1][getPosX()-1].getColor().equals("blanco")){
                    posicionesPosibles.add(""+(getPosY()+1)+" "+(getPosX()-1));
                }
            }
        }
        
    }
    
}
