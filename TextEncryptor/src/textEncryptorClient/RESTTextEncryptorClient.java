package textEncryptorClient;



import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class RESTTextEncryptorClient extends Application{
	
	Button encryptButton = new Button("Encrypt");
	Button decryptButton = new Button("Decrypt");
	TextField textToEncrypt = new TextField();
	TextField dataToDecrypt = new TextField();
	
	Label encryptText = new Label("Text To Encrypt ->");
	Label decryptText = new Label("<- Data to Decrypt");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		HBox hbox1 = new HBox(10, encryptButton, decryptButton);
		HBox hbox2 = new HBox(10, textToEncrypt, dataToDecrypt);
		HBox hbox3 = new HBox(10, encryptText, decryptText);
		
		VBox vbox = new VBox(10, hbox3, hbox2, hbox1);
		
		primaryStage.setTitle("Text Encryptor");
		Scene myScene = new Scene (vbox, 500,300);
		
		vbox.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setAlignment(Pos.CENTER);
		
		
		
		encryptButton.setOnAction(event ->{
			
			String message = textToEncrypt.getText();
			
			String result = transmit(true, message);
			
			dataToDecrypt.setText(result);
			
		});
		
		decryptButton.setOnAction(event-> {
			
			String message = dataToDecrypt.getText();
			
			String result = transmit(false, message);
			
			textToEncrypt.setText(result);
			
		});
		
		primaryStage.setScene(myScene);
		primaryStage.show();
	}
	
	public String transmit(boolean getsEncryption, String message) {
		String result = "";
		try {
			
			
			if(getsEncryption) {
				try {
					URL encryptURL = new URL("http://localhost:8080/TextEncryptor/api/encryptor");
					URLConnection connection = encryptURL.openConnection();
					connection.setDoOutput(true);
					connection.setRequestProperty("Content-Type", "application/json");
					connection.setConnectTimeout(5000);
					connection.setReadTimeout(5000);
					OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
					out.write(message);
					out.close();
					
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					String received = null;
					while ((received = in.readLine()) != null) {
						System.out.println(received);
						result = received;
					}
					System.out.println("Encrypted Message Received.");
					in.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			else {
				try {
					URL decryptURL = new URL("http://localhost:8080/TextEncryptor/api/decryptor");
					URLConnection connection = decryptURL.openConnection();
					connection.setDoOutput(true);
					connection.setRequestProperty("Content-Type", "application/json");
					connection.setConnectTimeout(5000);
					connection.setReadTimeout(5000);
					OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
					out.write(message);
					out.close();
					
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					String received = null;
					while ((received = in.readLine()) != null) {
						System.out.println(received);
						result = received;
					}
					System.out.println("Decrypted Message Received.");
					in.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
