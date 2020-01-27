package wsserver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Logger;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;

@ServerWebSocket("/go/{gameid}")
public class WebSocketEndpoint {
	private WebSocketBroadcaster broadcaster;
	private Map<String, String> gameid2password = new HashMap<String, String>();
	private Map<String, Boolean> gameid2initialised = new HashMap<String, Boolean>();
	
	private final static Logger LOGGER = Logger.getLogger(WebSocketEndpoint.class.getName());

	public WebSocketEndpoint(WebSocketBroadcaster broadcaster) {
		this.broadcaster = broadcaster;
	}

	@OnOpen
	public void onOpen(String gameid, WebSocketSession session) {
		LOGGER.info(String.format("Made a connection for %s", gameid));
	}

	@OnMessage
	public void onMessage(String gameid, String message, WebSocketSession session) {
		if (message.startsWith("password") && !gameid2password.containsKey(gameid)) {
			LOGGER.info(String.format("Game %s does exist", gameid));
			gameid2password.put(gameid, message);
			session.put("authorised", true);
			return;
		}
		if (message.startsWith("password") && gameid2password.getOrDefault(gameid, "").equals(message)
				&& !gameid2initialised.containsKey(gameid)) {
			LOGGER.info(String.format("Game %s is initialised", gameid));
			gameid2initialised.put(gameid, true);
			session.put("authorised", true);
			return;
		}
		if(session.get("authorised", Boolean.TYPE).isPresent() && !message.startsWith("password")) {
			LOGGER.info(String.format("Message for %s: %s", gameid, message));
			broadcaster.broadcastSync(message, isValid(gameid, session));
		}
	}

	@OnClose
	public void onClose(String gameid, WebSocketSession session) {
		LOGGER.info(String.format("Closed a connection for %s", gameid));
		if(session.get("authorised", Boolean.TYPE).isPresent() && gameid2initialised.containsKey(gameid)) {
			LOGGER.info(String.format("Game %s is not initialised anymore", gameid));
			gameid2initialised.remove(gameid);
			return;
		}
		if(session.get("authorised", Boolean.TYPE).isPresent() && !gameid2initialised.containsKey(gameid)) {
			LOGGER.info(String.format("Game %s does not exists anymore", gameid));
			gameid2password.remove(gameid);
			return;
		}
	}

	private Predicate<WebSocketSession> isValid(String gameid, WebSocketSession session) {
		return s -> s != session && gameid.equalsIgnoreCase(s.getUriVariables().get("gameid", String.class, null));
	}
}