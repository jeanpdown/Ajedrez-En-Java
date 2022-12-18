
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
    public boolean enJaque(Ficha fichas[][]){
            //busca torre o dama
            if(defenzaTotalRecta(fichas, 1, 0)) {
                    return Ficha.ataque;
            }
            if(defenzaTotalRecta(fichas, 0, 1)) {
                    return Ficha.ataque;
            }
            if(defenzaTotalRecta(fichas, 0, -1)){
                    return Ficha.ataque;
            }
            if(defenzaTotalRecta(fichas, -1, 0)){
                    return Ficha.ataque;
            }
            //busca alfil o dama
            if(defenzaTotalDiagonal(fichas, 1, 1)){
                    return Ficha.ataque;
            }
            if(defenzaTotalDiagonal(fichas, 1, -1)){
                    return Ficha.ataque;
            }
            if(defenzaTotalDiagonal(fichas, -1, 1)){
                    return Ficha.ataque;
            }
            if(defenzaTotalDiagonal(fichas, -1, -1)){
                    return Ficha.ataque;
            }
            //busca caballo
            if(defenzaCaballo(fichas, -1,2)){
                    return Ficha.ataque;
            }
            if(defenzaCaballo(fichas, -1,-2)){
                    return Ficha.ataque;
            }
            if(defenzaCaballo(fichas, -2,1)){
                    return Ficha.ataque;
            }
            if(defenzaCaballo(fichas, -2,-1)){
                    return Ficha.ataque;
            }
            if(defenzaCaballo(fichas, 1,2)){
                    return Ficha.ataque;
            }
            if(defenzaCaballo(fichas, 1,-2)){
                    return Ficha.ataque;
            }
            if(defenzaCaballo(fichas, 2,1)){
                    return Ficha.ataque;
            }
            if(defenzaCaballo(fichas, 2,-1)){
                    return Ficha.ataque;
            }
            //busca peon
            if(defenzaPeon(fichas, 1,1)){
                    return Ficha.ataque;
            }
            if(defenzaPeon(fichas, 1,-1)){
                    return Ficha.ataque;
            }
            if(defenzaPeon(fichas, -1,1)){
                    return Ficha.ataque;
            }
            if(defenzaPeon(fichas, -1,-1)){
                    return Ficha.ataque;
            }
            return Ficha.ataque;
    }
    public boolean defenzaTotalRecta(Ficha fichas[][],int variacionY,int variacionX){
            for(int i = 0; i < 8; i++){
                    if(defenzaRecta(fichas,i*variacionY,i*variacionX)){
                            break;
                    }
            }
            return Ficha.ataque;
    }
    public boolean defenzaTotalDiagonal(Ficha fichas[][],int variacionY,int variacionX){
            for(int i = 0; i < 8; i++){
                    if(defenzaDiagonal(fichas,i*variacionY,i*variacionX)){
                            break;
                    }
            }
            return Ficha.ataque;
    }
    public boolean defenzaRecta(Ficha fichas[][],int posY, int posX){
            if(comprobarRangoIndice(getPosY()+posY,getPosX()+posX)){
                    Ficha buscar = fichas[getPosY()+posY][getPosX()+posX];
                    if(buscar!=null) {
                            if(!buscar.getColor().equals(this.getColor())){
                                    if(buscar instanceof Torre || buscar instanceof Reina){
                                            Ficha.ataque = true;
                                            return true;
                                    }else{
                                            Ficha.ataque = false;
                                    }
                            }else{
                                    return true;
                            }
                    }
            }else{
                    return true;
            }
            return false;
    }
    public boolean defenzaDiagonal(Ficha fichas[][],int posY, int posX){
            if(comprobarRangoIndice(getPosY()+posY,getPosX()+posX)){
                    Ficha buscar = fichas[getPosY()+posY][getPosX()+posX];
                    if(buscar!=null) {
                            if(!buscar.getColor().equals(this.getColor())){
                                    if(buscar instanceof Alfil || buscar instanceof Reina){
                                            Ficha.ataque = true;
                                            return true;
                                    }else{
                                            Ficha.ataque = false;
                                    }
                            }else{
                                    return true;
                            }
                    }
            }else{
                    return true;
            }
            return false;
    }
    public boolean defenzaCaballo(Ficha fichas[][],int posY, int posX){
            if(comprobarRangoIndice(getPosY()+posY,getPosX()+posX)){
                    Ficha buscar = fichas[getPosY()+posY][getPosX()+posX];
                    if(buscar!=null) {
                            if(!buscar.getColor().equals(this.getColor())){
                                    if(buscar instanceof Caballo){
                                            Ficha.ataque = true;
                                    }else{
                                            Ficha.ataque = false;
                                    }
                            }
                    }
            }
            return Ficha.ataque;
    }
    public boolean defenzaPeon(Ficha fichas[][],int posY, int posX){
            if(comprobarRangoIndice(getPosY()+posY,getPosX()+posX)){
                    Ficha buscar = fichas[getPosY()+posY][getPosX()+posX];
                    if(buscar!=null) {
                            if(!buscar.getColor().equals(this.getColor())){
                                    if(buscar instanceof Peon){
                                            Ficha.ataque = true;
                                    }else{
                                            Ficha.ataque = false;
                                    }
                            }
                    }
            }
            return Ficha.ataque;
    }
}
