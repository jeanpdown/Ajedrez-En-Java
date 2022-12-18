
package Ventanas;

import java.util.ArrayList;
import javax.swing.JButton;


public class Ficha {
    private String color;
    private String direccionImagen;
    private JButton boton;
    private int posY;
    private int posX;
    private boolean vive=true;
    private int movimientosRealizados=0;
    public static boolean ataque=false;

    public Ficha(String color, String direccionImagen, JButton boton) {
        this.color = color;
        this.direccionImagen = direccionImagen;
        this.boton = boton;
        this.posX=(int)(boton.getAlignmentX()*10);
        this.posY=(int)(boton.getAlignmentY()*10);
    }


    public void movimientosPosibles(ArrayList<String> posiciones,Ficha fichas[][],int YultimoMov,int XultimoMov){
        System.out.println("Ficha");
    }
    public boolean movimientoFichaSegunVariacion(ArrayList<String> posicionesPosibles,Ficha fichas[][],int variacionY,int variacionX){
        
        if(comprobarRangoIndice(getPosY()+variacionY,getPosX()+variacionX)){
            if(fichas[getPosY()+variacionY][getPosX()+variacionX]==null) {
                    posicionesPosibles.add(""+(getPosY()+variacionY)+" "+(getPosX()+variacionX));
            } else if(!fichas[getPosY()+variacionY][getPosX()+variacionX].getColor().equals(this.getColor())) {
                    probarJaque(posicionesPosibles, fichas, variacionY, variacionX);
                    return false;
            } else {
                    return false;
            }
        }else{
            return false;
        }
        return true;
        
    }
    
    public void probarJaque(ArrayList<String> posicionesPosibles,Ficha fichas[][],int variacionY,int variacionX){
            if(fichas[getPosY()+variacionY][getPosX()+variacionX] instanceof Rey){//probar que el rey esté en jaque
                    Ficha.ataque=true;
                    posicionesPosibles.add(""+(getPosY()+variacionY)+" "+(getPosX()+variacionX));
            }else{
                    posicionesPosibles.add(""+(getPosY()+variacionY)+" "+(getPosX()+variacionX));
            }
    }
    
    public String getColor() {
        return color;
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public JButton getBoton() {
        return boton;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }
    
    public boolean comprobarRangoIndice(int x,int y){
        if(x>=0 && x<8 && y>=0 && y<8)
            return true;
        else
            return false;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }
    public boolean getVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public int getMovimientosRealizados() {
        return movimientosRealizados;
    }

    public void setMovimientosRealizados(int movimientosRealizados) {
        this.movimientosRealizados = movimientosRealizados;
    }
    
    
}
