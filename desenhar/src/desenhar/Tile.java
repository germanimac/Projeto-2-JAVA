/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenhar;
//serve como molde para o quadro
abstract class Tile {
    int x,y,valor;
    abstract boolean collision(quadro[] q, int k, int num);
    abstract int slide(int x,quadro[]q,int num);
   
   
}