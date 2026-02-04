
package Controller;
import Controller.Splashscreen_DAO;

import View.Criar_GUI;
import View.Login_GUI;
import View.Menu_GUI;
import View.SplashLogin_GUI;
import static View.SplashLogin_GUI.mensagem1;
import static View.SplashLogin_GUI.progresso1;
import View.Splash_GUI;
import static View.Splash_GUI.mensagem;
import static View.Splash_GUI.progresso;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities; 

public class Splashscreen_DAO {
    
    public static void carrega(Splash_GUI splash) {

    new Thread() {
        public void run() {
            
            

            for (int i = 0; i < 101; i++) {
                try {
                    sleep(15);

                    progresso.setValue(i);

                    if (progresso.getValue() == 10) {
                        mensagem.setText("Carregando informações");
                        // driver_conexao.carregardriver();
                        sleep(15);

                    } else if (progresso.getValue() <= 30) {
                        mensagem.setText("Carregando o sistema");
                        sleep(15);

                    } else if (progresso.getValue() <= 99) {
                        mensagem.setText("Carregamento quase completo");

                    } else {
                        mensagem.setText("Carregamento completo. Seu programa sera iniciado.");
                        sleep(30);

                        // Executa abertura do Login_GUI na EDT
                        SwingUtilities.invokeLater(() -> {
                            new Login_GUI().setVisible(true);
                            splash.dispose(); // Fecha o Splash_GUI
                        });
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(Splash_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }.start();
}


    
    
     public static void login(SplashLogin_GUI splash) {

    new Thread() {
        public void run() {
            
            

            for (int i = 0; i < 101; i++) {
                try {
                    sleep(15);

                    progresso1.setValue(i);

                    if (progresso1.getValue() == 10) {
                        mensagem1.setText("Carregando informações");
                        // driver_conexao.carregardriver();
                        sleep(15);

                    } else if (progresso1.getValue() <= 30) {
                        mensagem1.setText("Carregando o sistema");
                        sleep(15);

                    } else if (progresso1.getValue() <= 99) {
                        mensagem1.setText("Carregamento quase completo");

                    } else {
                        mensagem1.setText("Carregamento completo. Seu programa sera iniciado.");
                        sleep(30);

                        // Executa abertura do Login_GUI na EDT
                        SwingUtilities.invokeLater(() -> {
                            new Menu_GUI().setVisible(true);
                            splash.dispose(); // Fecha o Splash_GUI
                        });
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(Splash_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }.start();
}

    
}
