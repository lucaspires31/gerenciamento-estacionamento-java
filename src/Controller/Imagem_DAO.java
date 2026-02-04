package Controller;
import Controller.Imagem_DAO;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.edisoncor.gui.panel.PanelImage; // importa o PanelImage

public class Imagem_DAO {

    // Variável para armazenar o caminho da imagem
    public static String caminhoImagem = "";

    // Método para escolher e exibir a imagem no PanelImage
    public static void abrirFoto(PanelImage img) {
        JFileChooser arquivo = new JFileChooser();
        arquivo.setDialogTitle("Selecione a foto do visitante");
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int retorno = arquivo.showOpenDialog(null);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = arquivo.getSelectedFile();
            caminhoImagem = file.getAbsolutePath();

            // Mostra o caminho (só pra debug, pode tirar)
            JOptionPane.showMessageDialog(null, "Imagem selecionada: " + caminhoImagem);

            // Carrega e redimensiona a imagem pro tamanho do PanelImage
            ImageIcon icon = new ImageIcon(caminhoImagem);
            Image imgEscalada = icon.getImage().getScaledInstance(
                    img.getWidth(),
                    img.getHeight(),
                    Image.SCALE_SMOOTH
            );

            // Define a imagem no PanelImage
            img.setIcon(new ImageIcon(imgEscalada));

            // Atualiza o painel
            img.repaint();

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma imagem selecionada.");
        }
    }
}
