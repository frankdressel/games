package moduliertersingvogel.nexus.basics.webservice;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import org.codehaus.jackson.map.ObjectMapper;

import moduliertersingvogel.nexus.basics.generator.Generator;
import moduliertersingvogel.nexus.basics.machine.SimpleDataBase;
import moduliertersingvogel.nexus.model.Ebene;
import moduliertersingvogel.nexus.model.Nexus;
import moduliertersingvogel.nexus.model.Spiel;
import moduliertersingvogel.nexus.model.Spieler;
import moduliertersingvogel.nexus.model.SpielerStates;
import moduliertersingvogel.nexus.model.Zug;
import moduliertersingvogel.nexus.model.Zugliste;

@Path("/")
public class WebService {
	@Context
	UriInfo uriInfo;

	@Path("/new")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response newGame() {

		Spiel random = new Generator().generateRandom(5);

		SimpleDataBase.INSTANCE.addSpiel(random);

		Response response;
		try {
			response = Response.created(
					new URI(uriInfo.getBaseUri() + "spiel/" + random.getId()))
					.build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}

	@Path("/spiel/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getGame(@PathParam("id") String id) {
		Spiel spiel = SimpleDataBase.INSTANCE.getSpiel(id);

		Response response;
		if (spiel == null) {
			response = Response.status(Status.NOT_FOUND).build();

		} else {
			// In principal, Jersey should use JAXB to create the JSon-string.
			// This leads to strange results in cases of lists with just 1
			// element (see
			// http://jersey.java.net/nonav/documentation/latest/json.html,
			// chapter 5.2.2).
			ObjectMapper mapper = new ObjectMapper();
			try {
				String spielRepresentation = mapper.writeValueAsString(spiel);
				ResponseBuilder builder = Response.ok(spielRepresentation,
						MediaType.APPLICATION_JSON);
				// This is the magic line, which avoids problems with the
				// same-origin
				// policy. Normally, this would be configured in the web.xml.
				// But I
				// have
				// definitely no clue, where to find this file for the
				// eclipese-started
				// gyrex jetty.
				builder.header("Access-Control-Allow-Origin", "*");
				response = builder.build();
			} catch (IOException e) {
				e.printStackTrace();
				response = Response.serverError().build();
			}
		}
		return response;
	}

	@Path("/spiel/{id}/{spielerid}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPlayer(@PathParam("id") String id,
			@PathParam("spielerid") String spielerid) {
		Response response = null;

		Spiel spiel = SimpleDataBase.INSTANCE.getSpiel(id);
		for (Spieler spieler : spiel.getBeteiligteSpieler()) {
			if (spieler.getName().equalsIgnoreCase(spielerid)) {
				response = Response.status(Status.CONFLICT).build();
				return response;
			}
		}

		Spieler spieler = new Spieler();
		spieler.setName(spielerid);

		spiel.getBeteiligteSpieler().add(spieler);

		try {
			return Response.created(
					new URI(uriInfo.getBaseUri() + "spiel/" + id + "/"
							+ spielerid)).build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return Response.serverError().build();
	}

	@Path("/spiel/{id}/{spielerid}/zuege")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getZuege(@PathParam("id") String id,
			@PathParam("spielerid") String spielerid) {
		Response response = null;

		Spiel spiel = SimpleDataBase.INSTANCE.getSpiel(id);
		Spieler spieler = null;
		for (Spieler s : spiel.getBeteiligteSpieler()) {
			if (s.getName().equalsIgnoreCase(spielerid)) {
				spieler = s;
				break;
			}
		}
		if (spieler == null) {
			return Response.serverError().build();
		}

		if (spieler.getState() == SpielerStates.CANMOVEFIGURE) {
			if (spieler.getTurnPlayedByThisPlayer() == 0) {
				Nexus nexus = new Nexus();
				Zugliste zugListe = new Zugliste();
				for (Ebene ebene : spiel.getEbenen()) {
					Zug zug = new Zug();
					zug.setZiel(ebene);
					zug.setGestalt(nexus);
					zugListe.getZuege().add(zug);
				}
				try {
					response = Response.ok(new ObjectMapper().writeValueAsString(zugListe)).build();
				} catch (IOException e) {
					e.printStackTrace();
					response=Response.serverError().build();
				}
			}

		}

		return response;
	}
}
