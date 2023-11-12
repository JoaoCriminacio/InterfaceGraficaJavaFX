package aula14trabalho01;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {
    String digitado;
    int contador = 0;
    
    //Botões
    @FXML
    Button btnSair;
    @FXML
    Button btnHome;
    @FXML
    Button btnLogin;
    
    //Caixas de Texto
    @FXML
    TextField txtUser;
    
    //Password field
    @FXML
    PasswordField txtSenha;
    
    //Botão de sair
    @FXML
    private void btnSairClick(ActionEvent event){
        System.exit(0);
    }
    
    //Botão de Login e suas validações
    @FXML
    private void btnLoginClick(ActionEvent event)throws IOException{
        while(contador <= 3){
            if((txtUser.getText().equals("admin")) && (txtSenha.getText().equals("admin"))){
                String file = "CadastroUsuario.fxml";
                URL url = getClass().getResource(file);
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Unimater");
                stage.show();
            }else if(!(txtUser.getText().equals("admin")) || !(txtSenha.getText().equals("admin"))){
                contador++;
                JOptionPane.showMessageDialog(null, "Erro!\nLogin ou Senha incorretos!", "Alerta", JOptionPane.ERROR_MESSAGE);
                if(contador >= 3){
                    String file = "Erro.fxml";
                    URL url = getClass().getResource(file);
                    Parent root = FXMLLoader.load(url);
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Erro!");
                    stage.show();
                }
                txtUser.setText("");
                txtSenha.setText("");
                break;
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
