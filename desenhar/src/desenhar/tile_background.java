/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenhar;
class tile_background {
    public int x,y;
    //gera a posição dos blocos azul-claros
    public tile_background(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public tile_background() {
    }
    //verifica se é posivel colocar um bloco em cima do tile que está na posição(X,Y)   
    public boolean isopen(quadro[] q){
        try{
        for (int i=0;i<q.length;i++){
            if (q[i].x == this.x && q[i].y==this.y)
                return false;
        }
        }
        catch(Exception e){}
        return true;
    }  
}