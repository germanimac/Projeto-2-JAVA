//TRABALHO DE PARADIGMAS DE PROGRAMAÇÃO B
//PROFESSOR: LEANDRO AFONSO XASTRE
//ALUNOS:   GABRIEL GONÇALVES MATTOS SANTINI     RA: 18189084
//          MARCELO GERMANI OLMOS                RA: 18048298  
package desenhar;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;
import java.math.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.json.JSONException;

public class Desenhar extends Frame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //inicia o jogo
        janela game = new janela();
        game.show();
        server serv = new server();
        try {
            serv.getMsg(game);
        } catch (IOException ex) {
            Logger.getLogger(Desenhar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Desenhar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
