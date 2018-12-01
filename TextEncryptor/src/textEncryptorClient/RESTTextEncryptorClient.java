package textEncryptorClient;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RESTTextEncryptorClient extends Application{
	
	Button encryptButton = new Button("Encrypt");
	Button decryptButton = new Button("Decrypt");
	TextField textToEncrypt = new TextField();
	TextField dataToDecrypt = new TextField();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox vbox = new VBox(10, encryptButton, decryptButton);
		primaryStage.setTitle("Text Encryptor");
		Scene myScene = new Scene (vbox);
		
		
		primaryStage.show();
	}

}
