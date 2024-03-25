/*
 * Course: CS1021 - 021
 * Winter 2022
 * Lab 6 - Exceptions
 * Name: Hudson Arney
 * Created: 1/17/2022
 * Updated: 1/24/2022
 */

package arneyh;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import edu.msoe.se1021.Lab6.WebsiteTester;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

/**
 * Lab6 Controller Class
 * Holds all the necessary FXML
 */
public class Lab6Controller implements Initializable {

    @FXML private TextField urlTextField;
    @FXML private TextField sizeTextField;
    @FXML private TextField downloadTextField;
    @FXML private TextField portTextField;
    @FXML private TextField hostTextField;
    @FXML private TextField timeoutTextField;
    @FXML private TextArea website;
    @FXML private Button analyzeButton;
    @FXML private Button setButton;
    WebsiteTester websiteTester = new WebsiteTester();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        urlTextField.setText("https://google.com");
        timeoutTextField.setText((websiteTester.getTimeout()));

        try {
            websiteTester.openURL("https://google.com");
        } catch (MalformedURLException e) {
            Alert urlError = new Alert(Alert.AlertType.ERROR);
            urlError.setHeaderText("URL ERROR");
            urlError.setContentText("The URL entered in the text box is invalid");
            urlTextField.setText("");
        }
    }

    /**
     * setTimeout Method used for the button to set a time limit to search for a website
     * @param actionEvent actionEvent
     */
    @FXML
    public void setTimeout(ActionEvent actionEvent) {
        String text = timeoutTextField.getText();

        try {
            websiteTester.setTimeout(text);
        } catch(NumberFormatException e) {
            Alert timeoutError = new Alert(Alert.AlertType.ERROR);
            timeoutError.setHeaderText("Invalid Timeout Error");
            timeoutError.setContentText("Timeout must be greater than or equal to 0.");
            timeoutError.showAndWait();
            websiteTester.setTimeout(websiteTester.getTimeout());
            timeoutTextField.setText(websiteTester.getTimeout());
        }
    }

    @FXML
    private void analyze(ActionEvent actionEvent) {
        String url = urlTextField.getText();
        try {
            websiteTester.openURL(url);
            websiteTester.openConnection();
            websiteTester.downloadText();
            sizeTextField.setText("" + websiteTester.getSize());
            hostTextField.setText(websiteTester.getHostname());
            downloadTextField.setText("" + websiteTester.getDownloadTime() + " ms");
            portTextField.setText("" + websiteTester.getPort());
            website.setText(websiteTester.getContent());
        } catch(MalformedURLException e) {
            Alert urlError = new Alert(Alert.AlertType.ERROR);
            urlError.setHeaderText("URL ERROR");
            urlError.setContentText("The URL entered in the text box is invalid");
            urlError.showAndWait();
            urlTextField.setText("");
        } catch(SocketTimeoutException e) {
            Alert socketError = new Alert(Alert.AlertType.CONFIRMATION);
            socketError.setHeaderText("Wait longer?");
            socketError.setContentText("There has been a timeout reaching the site. " +
                    "Click OK to extend the timeout period");
            socketError.showAndWait().ifPresent(response -> {
                if(response == ButtonType.OK) {
                    boolean invalidInput = true;

                    do {
                        TextInputDialog timeOut = new TextInputDialog();
                        timeOut.setHeaderText("Set extended timeout");
                        timeOut.setContentText("Desired timeout");
                        timeOut.showAndWait();

                        try {
                            websiteTester.setTimeout(timeOut.getResult());
                            timeoutTextField.setText(websiteTester.getTimeout());
                            analyze(actionEvent);
                            invalidInput = false;
                        } catch(NumberFormatException exception) {
                        }
                    } while(invalidInput);
                }
            });

        } catch(UnknownHostException e) {
            Alert hostError = new Alert(Alert.AlertType.ERROR);
            hostError.setHeaderText("Unknown Host Error");
            hostError.setContentText("The host you are trying to reach does not exist");
            hostError.showAndWait();
        } catch (IOException e) {
            Alert fileError = new Alert(Alert.AlertType.ERROR);
            fileError.setHeaderText("File Error");
            fileError.setContentText("Error: File not found on server\n" + urlTextField.getText());
            fileError.showAndWait();
        }
    }

}
