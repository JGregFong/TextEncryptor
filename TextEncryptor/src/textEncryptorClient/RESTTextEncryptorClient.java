package textEncryptorClient;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RESTTextEncryptorClient extends Application{
	
	Button encryptButton = new Button("Encrypt");
	Button decryptButton = new Button("Decrypt");
	TextField textToEncrypt = new TextField();
	TextField dataToDecrypt = new TextField();
	
	Label encryptText = new Label("Text To Encrypt");
	Label decryptText = new Label("Data to Decrypt");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		HBox hbox1 = new HBox(10, encryptButton, decryptButton);
		HBox hbox2 = new HBox(10, textToEncrypt, dataToDecrypt);
		
		VBox vbox = new VBox(10, hbox2, hbox1);
		
		primaryStage.setTitle("Text Encryptor");
		Scene myScene = new Scene (vbox);
		
		primaryStage.setScene(myScene);
		primaryStage.show();
	}

}
