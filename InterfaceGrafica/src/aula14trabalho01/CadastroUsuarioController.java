package aula14trabalho01;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class CadastroUsuarioController implements Initializable {
    String nacionalidade = "Outra Nacionalidade";
    String data = "";
    String dataFormatada;
    String armazenarCNH = "";
    String escolaridade = "Fundamental";
    int valorEscolaridade = 0;

    //Botões
    @FXML
    Button btnSair;
    @FXML
    Button btnSalvar;
    
    //Caixa de Texto
    @FXML
    TextField txtComplemento;
    @FXML
    TextField txtEstadoCivil;
    
    //CheckBox
    @FXML
    CheckBox checkBoxNacio;
    
    //DatePicker
    @FXML
    DatePicker dataNascimento;
    
    //Radio
    @FXML
    RadioButton radioSim;
    @FXML
    RadioButton radioNao;
    
    //Slider
    @FXML
    Slider sliderEscolaridade;
    
    //Botão de sair
    @FXML
    private void btnSairClick(ActionEvent event){
        System.exit(0);
    }
    
    //Botão Salvar
    @FXML
    private void btnSalvarClick(ActionEvent event){
        if((txtComplemento.getText().equals("")) || (txtEstadoCivil.getText().equals("")) || (data.equals("")) || (armazenarCNH.equals(""))){
            JOptionPane.showMessageDialog(null, "Existem campos vazios!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else{
            Object[] options = { "OK", "CANCELAR" };
            JOptionPane.showOptionDialog(null, "Nome: "+txtComplemento.getText()+"\nEstado Civil: "+txtEstadoCivil.getText()+"\nNacionalidade: "+nacionalidade+"\nData de Nascimento: "+dataFormatada+"\nPossui CNH: "+armazenarCNH+"\nEscolaridade: "+escolaridade, "Salvar",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        }    
    }
    
    //MenuButton
    @FXML
    private void casado(ActionEvent event){
        txtEstadoCivil.setText("Casado");
    }
    @FXML
    private void solteiro(ActionEvent event){
        txtEstadoCivil.setText("Solteiro");
    }
    
    //Armazenar informação do checkbox
    @FXML
    private void CheckBoxActionNacio(ActionEvent event){
        if(checkBoxNacio.isSelected()){
            nacionalidade = "Brasileiro";
        }else{
            nacionalidade = "Outra Nacionalidade";
        }
    }
    
    //Armazenar informação do DatePicker
    @FXML
    private void dataActionNascimento(ActionEvent event){
        LocalDate hoje = LocalDate.now();
        LocalDate minhaData = dataNascimento.getValue();
        
        if((minhaData == null) || (minhaData.isAfter(hoje))){
            JOptionPane.showMessageDialog(null, "Selecione uma data válida!", "Alerta", JOptionPane.ERROR_MESSAGE);
            data = "";
        }else{
            data = String.valueOf(minhaData);
            dataFormatada = minhaData.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        }
    }
    
    //Armazenar informação se possui CNH ou não
    public void possuirCNH(ActionEvent event){
	if(radioSim.isSelected()){
		armazenarCNH = radioSim.getText();
	}else if(radioNao.isSelected())
		armazenarCNH = radioNao.getText();
	}
    
    //Armazenar informações do Slider
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sliderEscolaridade.valueProperty().addListener(new ChangeListener<Number>(){
            
            @Override
            public void changed(ObservableValue<? extends Number> url, Number rb, Number newValue) {
                valorEscolaridade = (int) sliderEscolaridade.getValue();
                if((valorEscolaridade >= 0) && (valorEscolaridade <= 20)){
                    escolaridade = "Fundamental";
                }else if((valorEscolaridade > 20) && (valorEscolaridade <= 40)){
                    escolaridade = "Médio";
                }else if((valorEscolaridade > 40) && (valorEscolaridade <= 60)){
                    escolaridade = "Superior";
                }else if ((valorEscolaridade > 60) && (valorEscolaridade <= 80)){
                    escolaridade = "Mestrado";
                }else if((valorEscolaridade > 80) && (valorEscolaridade <= 100)){
                    escolaridade = "Doutorado";
                }
            }
            
        });

    }    
    
}
