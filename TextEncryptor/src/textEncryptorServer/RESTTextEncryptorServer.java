package textEncryptorServer;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.print.attribute.standard.Media;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@ApplicationPath("/")

public class RESTTextEncryptorServer {
	@POST
	@Path("/encryptor")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response encryptREST(InputStream incomingData) {
		StringBuilder originalMessage = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				originalMessage.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		
		String encryptionKey = "Merry Christmas, Professor!";
		
		System.out.println("Data Received: " + originalMessage.toString());
		String encryptedMessage = AESnHexConverter.encrypt(originalMessage.toString(), encryptionKey);
		
		System.out.println("Data Encrypted: " + encryptedMessage);
		
		// return HTTP response 200 in case of success
		return Response.status(200).entity(encryptedMessage).build();
	}
 
	@POST
	@Path("/decryptor")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response decryptREST(InputStream incomingData) {
		StringBuilder encryptedMessage = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				encryptedMessage.append(line);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		
		String encryptionKey = "Merry Christmas, Professor!";
		
		System.out.println("Data Received: " + encryptedMessage.toString());
		String decryptedMessage = AESnHexConverter.decrypt(encryptedMessage.toString(), encryptionKey);
		
		System.out.println("Data Decrypted: "+ decryptedMessage);
		
		// return HTTP response 200 in case of success
		return Response.status(200).entity(decryptedMessage).build();
	}
	
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "Service is working";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
	

	
}
