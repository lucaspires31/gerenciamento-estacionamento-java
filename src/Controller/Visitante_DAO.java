
package Controller;
import Controller.Visitante_DAO;
import static Controller.Funcoes_DAO.url2;
import static Controller.Funcoes_DAO.username;
import static View.CadVi_GUI.col5_txt;
import static View.CadVi_GUI.doc5_txt;
import static View.CadVi_GUI.emp5_txt;
import static View.CadVi_GUI.mot5_txt;
import static View.CadVi_GUI.nom5_txt;
import View.Consult_GUI;
import static View.Consult_GUI.cod3_txt;
import static View.Consult_GUI.col6_txt;
import static View.Consult_GUI.data_txt;
import static View.Consult_GUI.doc6_txt;
import static View.Consult_GUI.emp6_txt;
import static View.Consult_GUI.hora_txt;
import static View.Consult_GUI.lbnfoto;
import static View.Consult_GUI.mot6_txt;
import static View.Consult_GUI.nom6_txt;
import static View.Consult_GUI.status_txt;
import static View.ConsultarFunc_GUI.cod11_txt;
import static View.EntradaVis_GUI.cod9_txt;
import static View.ExcluirVis_GUI.cod6_txt;
import static View.HistóricoVis_GUI.cod119_txt;
import static View.HistóricoVis_GUI.de_txt;
import static View.HistóricoVis_GUI.ds_txt;
import static View.HistóricoVis_GUI.he_txt;
import static View.HistóricoVis_GUI.hs_txt;
import View.Inicio_GUI;
import static View.Inicio_GUI.cod1_txt;
import static View.Inicio_GUI.cod2_txt;
import static View.Inicio_GUI.email2_txt;
import static View.Inicio_GUI.email_txt;
import static View.Inicio_GUI.end1_txt;
import static View.Inicio_GUI.end_txt;
import static View.Inicio_GUI.nome1_txt;
import static View.Inicio_GUI.nome_txt;
import static View.Inicio_GUI.tel1_txt;
import static View.Inicio_GUI.tel_txt;
import static View.SaidaVis_GUI.cod112_txt;
import java.awt.Image;
import java.sql.Connection;          // ✅ usa o pacote JDBC padrão
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class Visitante_DAO {
    
 static int cod;
 static String nom;
 static String doc;
 static String emp;
 static String mot;
 static String col;
 static String dat;
 static String hor;
    
public static String url2 = "jdbc:mysql://localhost:3306/aprender"
        + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";

  static String username = "root";        //nome de um usuário de seu BD
  static String password = "";  // senha do BD

    
    public static void cadastrar(){
        //INICIO---------------->
        
        
nom = nom5_txt.getText(); 
doc = doc5_txt.getText(); 
emp = emp5_txt.getText();
mot = mot5_txt.getText();
col = col5_txt.getText();


Model.Conecta_DB.carregaDriver();

       
       
      try { 
               
                   
               
            Connection con = null;
            
            
    try {
    con = (Connection) DriverManager.getConnection(url2, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(Inicio_GUI.class.getName()).log(Level.SEVERE, null, ex);

            
                   }
            String caminhoCorrigido = Imagem_DAO.caminhoImagem.replace("\\", "\\\\");
            // Recebendo os dados a serem inseridos na tabela
            String sql = "INSERT INTO visitante(nome,documento,empresa,motivo_empresa,colaborador, foto, status) values('"+nom+"','"+doc+"','"+emp+"','"+mot+"','"+col+"','"+caminhoCorrigido+"','dentro')";
     
            try { // Tratamento de Erros para inserção

                // Criando varialvel que executara a inserção
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

  JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                nom5_txt.setText("");
                doc5_txt.setText("");
                emp5_txt.setText("");
                mot5_txt.setText("");
                col5_txt.setText("");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            doc5_txt.setText("");
        }
      }
      
      


    public static void consultar() {
    //--Inicio
    try {     
        
        String documento = cod3_txt.getText().trim(); 

       
        if (documento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um documento (RG) válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;  
        }

      
        Model.Conecta_DB.carregaDriver(); 

        try {
            Connection con = DriverManager.getConnection(url2, username, password); 

           
            String sql = "SELECT nome, documento, empresa, motivo_empresa, colaborador, data, horario, foto, status " +
                         "FROM visitante WHERE documento = ?";

           
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, documento); 

          
            ResultSet rs = stmt.executeQuery();

            
            if (rs.next()) {
                String nome = rs.getString("nome");
                String doc = rs.getString("documento");
                String empresa = rs.getString("empresa");
                String motivo = rs.getString("motivo_empresa");
                String colaborador = rs.getString("colaborador");
                String data = rs.getString("data");
                String hora = rs.getString("horario");
                String status = rs.getString("status");
                String foto = rs.getString("foto");

              
                nom6_txt.setText(nome);
                doc6_txt.setText(doc);
                emp6_txt.setText(empresa);
                mot6_txt.setText(motivo);
                col6_txt.setText(colaborador);
                data_txt.setText(data);
                hora_txt.setText(hora);
                status_txt.setText(status);

               
                if (foto != null && !foto.isEmpty()) {
                    try {
                        ImageIcon icon = new ImageIcon(foto);
                        Image imgEscalada = icon.getImage().getScaledInstance(lbnfoto.getWidth(), lbnfoto.getHeight(), Image.SCALE_SMOOTH);
                        lbnfoto.setIcon(new ImageIcon(imgEscalada));
                        lbnfoto.repaint(); 
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + e.getMessage());
                    }
                } else {
                    lbnfoto.setIcon(null);
                    lbnfoto.repaint();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Visitante não encontrado", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                nom6_txt.setText("");
                doc6_txt.setText("");
                emp6_txt.setText("");
                mot6_txt.setText("");
                col6_txt.setText("");
                data_txt.setText("");
                hora_txt.setText("");
                status_txt.setText("");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException erro) {
        JOptionPane.showMessageDialog(null, "Digite um RG válido!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}


        
        
        
        //--Fim
        
        
        
        public static void alterar(){
        //---inicio  
      nom = nom6_txt.getText(); 
      doc = doc6_txt.getText(); 
      emp = emp6_txt.getText();
      mot = mot6_txt.getText();
      col = col6_txt.getText();
      dat = data_txt.getText();
      hor = hora_txt.getText();

       Model.Conecta_DB.carregaDriver();
       
      try {     
            Connection con = null;
      try {
            con = (Connection) DriverManager.getConnection(url2, username, password);
      }catch (Exception ex) {
            Logger.getLogger(Consult_GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
            String sql = "UPDATE visitante SET nome='"+nom+"', documento='"+doc+"',empresa='"+emp+"',motivo_empresa='"+mot+"',colaborador='"+col+"' WHERE visitante_id="+cod3_txt.getText();
            
     
            try { 
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

                JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                cod3_txt.setText("");
                nom6_txt.setText("");
                doc6_txt.setText("");
                emp6_txt.setText("");
                mot6_txt.setText("");
                col6_txt.setText("");
                data_txt.setText("");
                hora_txt.setText("");
                status_txt.setText("");


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            doc6_txt.setText("");
        }    

        
        
       //-- Fim     

        
        
       
    }
        
        
            public static void excluir(){
     //---Inicio
         
         
        Model.Conecta_DB.carregaDriver();
            try {// Tratamento de erro para a conexao
            // Declarando  a variavel de conexão con
            // e estabelendo a conexão
            Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url2, username, password);
                } catch (Exception ex) {
                    Logger.getLogger(Consult_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
           

            // Criando String com comando SQL para exclusão
            String sql = "DELETE FROM visitante WHERE visitante_id = "+cod6_txt.getText();

            try // Tratamento de erros para exclusão
            {// Criando Variavel para executar a ação
                PreparedStatement excluir = (PreparedStatement) con.prepareStatement(sql);
                excluir.execute();// Executando a exclusão

                JOptionPane.showMessageDialog(null,"\nExclusão realizada com sucesso!!!\n","",-1);
                cod3_txt.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na exclusão!","ERRO!",0);
            }

        } catch(NumberFormatException erro){ // Codigo digitado com caracteres não numericos
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod3_txt.setText("");

        }

        
    //---Fim    
    }
    
           public static void registrarSaida() {
    try {
        int codigo = Integer.parseInt(cod112_txt.getText().trim());

        Model.Conecta_DB.carregaDriver();

        try (Connection con = DriverManager.getConnection(url2, username, password)) {
            // Verifica status atual
            String checkSql = "SELECT status FROM visitante WHERE visitante_id = ?";
            try (PreparedStatement checkStmt = con.prepareStatement(checkSql)) {
                checkStmt.setInt(1, codigo);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        String statusAtual = rs.getString("status");
                        if ("fora".equalsIgnoreCase(statusAtual)) {
                            JOptionPane.showMessageDialog(null, "Este visitante já está com status 'fora'.");
                            cod112_txt.setText("");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Visitante não encontrado!");
                        cod112_txt.setText("");
                        return;
                    }
                }
            }

            // Atualiza status e grava data/horario de saída
            String updateSql = "UPDATE visitante SET status = 'fora', data_saida = CURRENT_DATE, horario_saida = CURRENT_TIME WHERE visitante_id = ?";
            try (PreparedStatement updateStmt = con.prepareStatement(updateSql)) {
                updateStmt.setInt(1, codigo);
                int rows = updateStmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Saída registrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao registrar a saída.");
                }
            }

            cod112_txt.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar/atualizar: " + ex.getMessage());
            cod112_txt.setText("");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Digite um código válido!");
        cod112_txt.setText("");
    }
}

            
  public static void registrarEntrada() {
    try {
        int codigo = Integer.parseInt(cod9_txt.getText());

        Model.Conecta_DB.carregaDriver();
        Connection con = DriverManager.getConnection(url2, username, password);

        String checkSql = "SELECT status FROM visitante WHERE visitante_id = ?";
        PreparedStatement checkStmt = con.prepareStatement(checkSql);
        checkStmt.setInt(1, codigo);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            String statusAtual = rs.getString("status");

            if ("dentro".equalsIgnoreCase(statusAtual)) {
                JOptionPane.showMessageDialog(null, "Este carro já está com status 'dentro'.");
                cod112_txt.setText("");
            } else {
                String updateSql = "UPDATE visitante SET status = 'dentro' WHERE visitante_id = ?";
                PreparedStatement updateStmt = con.prepareStatement(updateSql);
                updateStmt.setInt(1, codigo);
                int rows = updateStmt.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Entrada registrada com sucesso!");
                    cod112_txt.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao registrar a entrada.");
                    cod112_txt.setText("");
                }
                updateStmt.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Carro não encontrado!");
            cod112_txt.setText("");
        }

        rs.close();
        checkStmt.close();
        con.close();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Digite um código válido!");
        cod112_txt.setText("");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao registrar entrada: " + e.getMessage());
        cod112_txt.setText("");
    }
}
  
  
  
  
  
  
  public static void consultarHorarios() {
    try {
        int codigo = Integer.parseInt(cod119_txt.getText().trim());

        Model.Conecta_DB.carregaDriver();
        try (Connection con = DriverManager.getConnection(url2, username, password)) {

            String sql = "SELECT data, horario, data_saida, horario_saida FROM visitante WHERE visitante_id = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {

                    if (rs.next()) {
                        String dataEntrada = rs.getString("data");
                        String horaEntrada = rs.getString("horario");
                        String dataSaida = rs.getString("data_saida");
                        String horaSaida = rs.getString("horario_saida");

                        // Preenche os campos da tela
                        de_txt.setText(dataEntrada != null ? dataEntrada : "");
                        he_txt.setText(horaEntrada != null ? horaEntrada : "");
                        ds_txt.setText(dataSaida != null ? dataSaida : "");
                        hs_txt.setText(horaSaida != null ? horaSaida : "");

                    } else {
                        JOptionPane.showMessageDialog(null, "Visitante não encontrado!");
                        de_txt.setText("");
                        he_txt.setText("");
                        ds_txt.setText("");
                        hs_txt.setText("");
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Digite um código válido!");
    }
}



    
        
    
      
      
      
      
      

    }

