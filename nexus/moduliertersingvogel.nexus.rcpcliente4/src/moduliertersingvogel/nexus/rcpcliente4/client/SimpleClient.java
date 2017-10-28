package moduliertersingvogel.nexus.rcpcliente4.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import moduliertersingvogel.nexus.model.Spiel;
import moduliertersingvogel.nexus.model.Zugliste;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class SimpleClient {
	
	private Client client;

	public SimpleClient(){
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		client = Client.create(clientConfig);
	}
	
	public URI createNewGame() {
		try {
			ClientResponse string = client.resource(
					new URI("http://localhost:8080/nexus/new")).post(
					ClientResponse.class);
			return string.getLocation();
			
		} catch (UniformInterfaceException | ClientHandlerException
				| URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Zugliste getZuege(URI spiel, String spielerID){
		try {
			String string = client.resource(
					new URI(spiel.toString()+"/"+spielerID+"/zuege")).get(
					String.class);
			try {
				return new ObjectMapper().readValue(string,Zugliste.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (UniformInterfaceException | ClientHandlerException
				| URISyntaxException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Spiel getSpiel(URI uri) {
		try {
			System.out.println(uri);
			String string = client.resource(
					uri).get(
					String.class);
			System.out.println("out: "+string);
			return new ObjectMapper().readValue(string,
					Spiel.class);
		} catch (UniformInterfaceException | ClientHandlerException
				| IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void createNewSpieler(URI newGame, String spielerName) {
		try {
			System.out.println(newGame.toString()+"/"+spielerName);
			client.resource(new URI(newGame.toString()+"/"+spielerName)).post();
		} catch (UniformInterfaceException | ClientHandlerException
				| URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
