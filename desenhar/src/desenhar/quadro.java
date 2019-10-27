/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenhar;

//quadro é o bloco ou a peça que esta sendo trabalhada

import java.awt.Color;
import java.awt.Graphics;

class quadro extends Tile {
    int x,y,valor;
    boolean merging;
    int num;
    Color c;
    boolean moved = false;
    boolean block_collided = false;
    
    public quadro(int x, int y,int valor) {
        this.x = x;
        this.y = y;
        this.valor=valor;
        this.merging = false;
        this.generate_color();
    }

    public quadro() {
        this.merging = false;
    }
   
    //de acordo com a direção verifica se há colisão entre os blocos
    //e se houver, verifica se eles podem se juntar(mergir)
    public boolean collision(quadro[] q,int k, int num){
        for(int i=0;i<this.num;i++){
            switch (k){
                case 0:
                    if(this.y == q[i].y +100 && this.x == q[i].x){
                        if(this.merging == false && this.valor == q[i].valor && !q[i].merging){
                            merge(q,i,this.num);
                            i=0;
                           
                           
                        }
                        else
                            if(!this.merging && this.moved)
                                this.block_collided=true;
                       
                        return true;}
                    break;
                case 1:
                    if(this.x == q[i].x +100 && this.y == q[i].y){
                        if(this.valor == q[i].valor && !this.merging && !q[i].merging){
                            merge(q,i,this.num);
                            i=0;
                           
                        }
                        else
                            if(!this.merging && this.moved)
                                this.block_collided=true;
                        return true;}
                    break;
                   
                case 2:
                    if(this.x+100 == q[i].x && this.y == q[i].y){
                        if(this.valor == q[i].valor && !this.merging && !q[i].merging){
                            merge(q,i,this.num);
                            i=0;
                           
                        }
                        else
                            if(!this.merging && this.moved)
                                this.block_collided=true;
                        return true;}
                    break;
                case 3:
                    if(this.y+100 == q[i].y && this.x == q[i].x){
                        if(this.valor == q[i].valor && !this.merging && !q[i].merging){
                            merge(q,i,this.num);
                            i=0;
                           
                        }
                        else
                            if(!this.merging && this.moved)
                                this.block_collided=true;
                        return true;}
                    break;
           
            }
        }
        return false;}
                     
   
    //de acordo com a direção, movimenta todos os blocos 
    //naquela direção, até que haja uma colisão entre blocos ou se chegar na border
    public int slide(int x,quadro[] q,int num){
        this.num = num;
        switch(x){
            case 0:
                while(this.y>71 && !this.collision(q,0,this.num)){
                    this.y = this.y - 100;
                    this.moved = true;
                }
                return this.num;
            case 1:
                while(this.x>61 && !this.collision(q,1,this.num)){
                    this.x = this.x - 100;
                    this.moved = true;
                }
               
                return this.num;
            case 2:
                while(this.x<361&& !this.collision(q,2,this.num)){
                    this.x = this.x + 100;
                    this.moved = true;
                }
               
                return this.num;
            case 3:
                while(this.y<371 && !this.collision(q,3,this.num)){
                    this.y = this.y + 100;
                    this.moved = true;
                }
               
                return this.num;
               
        }
        return num;
    }
    //faz a união entre dois quadros
    public void merge(quadro[] q,int i,int num){
        this.valor = 2*this.valor;
        this.merging = true;
        for(;i<num;i++)
            q[i] = q[i+1];
        this.num --;
        this.generate_color();
        
    }
   
    //desenha os quadros
    public void draw(Graphics g){
       
        g.setColor(c);
        g.fillRect(this.x, this.y, 80, 80);
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, 80, 80);
        if(this.valor == 2 || this.valor == 4)
            g.setColor(Color.BLACK);
        else
            g.setColor(Color.WHITE);
        g.drawString("" + this.valor, this.x+40, this.y +40);
    }
   
    //gera as cores para os quadros
    public void generate_color(){
        switch(this.valor){
            case 2:
                this.c = Color.decode("#eee4da");
                break;
            case 4:
                this.c = Color.decode("#ede0c8");
                break;
            case 8:
                this.c = Color.decode("#f2b179");
                break;
            case 16:
                this.c = Color.decode("#f59563");
                break;
            case 32:
                this.c = Color.decode("#f67c5f");
                break;
            case 64:
                this.c = Color.decode("#f65e3b");
                break;
            case 128:
                this.c = Color.decode("#edcf72");
                break;
            case 256:
                this.c = Color.decode("#edcc61");
                break;
            case 512:
                this.c = Color.decode("#edc850");
                break;
            case 1024:
                this.c = Color.decode("#edc53f");
                break;
            case 2048:
                this.c = Color.decode("#edc22e");
                break;
       
       
        }
    }
   
    //realiza a animacao entre dois blocos juntando
    public void animate_merge(Graphics g){
        int k = 0;
        for(k=0;k<1000;k++){
            g.setColor(c);
            g.fillRect(this.x-5*k/500, this.y-5*k/500, 80 + 10*k/500, 80 + 10*k/500);
        }
        
       
    }
    
    //realiza a animação entre dois blocos colidindo
    public void animate_collision(Graphics g){
        int k = 0;
        for(k=k;k<250;k++){
            g.setColor(c);
            g.fillRect(this.x-10*k/250,this.y-10*k/250,80,80);
            g.setColor(Color.BLACK);
            g.drawRect(this.x-10*k/250,this.y-10*k/250,80,80);
            k++;
            g.setColor(c);
            g.fillRect(this.x+10*k/250,this.y+10*k/250,80,80);
            g.setColor(Color.BLACK);
            g.drawRect(this.x+10*k/250,this.y+10*k/250,80,80);
        }
    }
    
    //verifica se existe um movimento possivel 
    public boolean possible_move(quadro[] q){
        int i;
        try{
            for(i=0;i<q.length;i++){
                if(     (q[i].x == this.x && q[i].y == this.y+100 && q[i].valor == this.valor)||
                        (q[i].x == this.x && q[i].y == this.y-100 && q[i].valor == this.valor)||
                        (q[i].x == this.x-100 && q[i].y == this.y && q[i].valor == this.valor)||
                        (q[i].x == this.x+100 && q[i].y == this.y && q[i].valor == this.valor))
                    return true;
            }
        }catch(Exception e){}
        return false;
    }
}