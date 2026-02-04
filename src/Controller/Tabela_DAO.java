


package Controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class Tabela_DAO {
    
    public static void exportarTabelaParaCSV(JTable tabela, String caminhoArquivo) {
    try (FileWriter csv = new FileWriter(caminhoArquivo)) {
        int colunas = tabela.getColumnCount();
        int linhas = tabela.getRowCount();

        // Cabeçalho
        for (int i = 0; i < colunas; i++) {
            csv.write(tabela.getColumnName(i));
            if (i < colunas - 1) csv.write(";");
        }
        csv.write("\n");

        // Dados
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Object valor = tabela.getValueAt(i, j);
                csv.write(valor != null ? valor.toString() : "");
                if (j < colunas - 1) csv.write(";");
            }
            csv.write("\n");
        }

        csv.flush();
        javax.swing.JOptionPane.showMessageDialog(null, "Tabela exportada com sucesso!");
    } catch (IOException e) {
        e.printStackTrace();
JOptionPane.showMessageDialog(null, "Erro ao exportar: " + e.getMessage());

    }
}
    
    
    public static void abrir_btnActionPerformed(java.awt.event.ActionEvent evt) {                                          
    try {
        // Caminho do arquivo exportado
        String caminho = "C:\\Users\\Alunos\\Documents\\exportacao\\tabela.csv";

        File arquivo = new File(caminho);
        if (arquivo.exists()) {
            Desktop.getDesktop().open(arquivo); // abre o documento
        } else {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado. Exporte primeiro.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: " + e.getMessage());
    }
}

    
     public static void abrir(java.awt.event.ActionEvent evt) {                                          
    try {
        // Caminho do arquivo exportado
        String caminho = "C:\\Users\\Alunos\\Documents\\exporta\\tabela.csv";

        File arquivo = new File(caminho);
        if (arquivo.exists()) {
            Desktop.getDesktop().open(arquivo); // abre o documento
        } else {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado. Exporte primeiro.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: " + e.getMessage());
    }
}
    
}
