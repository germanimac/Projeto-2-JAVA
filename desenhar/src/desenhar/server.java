package desenhar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class server extends janela {

    public server() {

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static String readFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return jsonText;
        } finally {
            is.close();
        }
    }

    public void getMsg(janela jogo) throws IOException, JSONException {
        while (true) {
            try {

                ServerSocket s = new ServerSocket(12345);
                Socket client = s.accept();
                Scanner sc = new Scanner(client.getInputStream());
                String mov = new String();
                while (sc.hasNextLine()) {
                     mov=(sc.nextLine());
                }
                if (mov.equals("cima")) {
                    jogo.Update(1);
                };
                if (mov.equals("baixo")) {
                    jogo.Update(4);
                }
                if (mov.equals("esquerda")) {
                    jogo.Update(2);
                }
                if (mov.equals("direita")) {
                    jogo.Update(3);
                }
                Thread.sleep(100);
                sc.close();
                s.close();
                client.close();
            } catch (InterruptedException ex) {
                Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
     
}
