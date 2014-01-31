/*
 * FxHelloWorld
 */

package fxhelloworld;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

/**
 *
 * @author Sandro
 */
public class FxHelloWorld extends Application {

    int count = 0;
    Stage stage = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("FX Application starting ... ");
        launch(args);
        System.out.println("FX Application started!");
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        open("fxhelloworld.fxml");
    }
 
    void open(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root, 480, 320);
            stage.setTitle(fxml);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.printf("FXML %s non trovato!\n[%s]\n", fxml, ex.getMessage());
        }
    }

    @FXML private Text status;
    @FXML private TextField txtOne, txtTwo;
    @FXML private TextArea txtArea;

    @FXML
    private void actionOne(ActionEvent event) {
        String msg = "Pulsante Uno cliccato!";
        txtTwo.appendText("X");
        count++;
        txtArea.appendText("[" + count + "] " + msg + "\n");
        status.setText(msg);
    }
    
    @FXML
    private void actionTwo(ActionEvent event) {
        String msg = "Pulsante Due cliccato!";
        String one = txtOne.getText();
        String two = txtTwo.getText();
        String tmp=one; one=two; two=tmp;
        txtOne.setText(one);
        txtTwo.setText(two);
        count++;
        txtArea.appendText("[" + count + "] " + msg + "\n");
        status.setText(msg);
    }
    
    
}
