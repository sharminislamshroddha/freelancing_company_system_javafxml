/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLManagerViewSendMessageController implements Initializable {
    Manager mana = null;
    void initData1(Manager manager) {
        mana = manager;
    }
    
    @FXML
    private TextArea inboxField;
    @FXML
    private TextArea msgBodyField;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    @FXML
    private TextField subjectField;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inboxField.setText("");
        ArrayList<Message>m = Message.listOfMessage();
        for(Message i: m){
            if(i.getToID() == mana.getId()){
                inboxField.appendText(i.toString());
            }
        }
    }    

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLManagerHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXMLManagerHomeSceneController controller1 = loader1.getController();
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickSendButton(ActionEvent event) {
        Message m = new Message(
                Integer.parseInt(to.getText()),
                Integer.parseInt(from.getText()),
                date.getValue(),
                msgBodyField.getText(),
                subjectField.getText()
            );
        m.addMessage();
    }

    
    
}
