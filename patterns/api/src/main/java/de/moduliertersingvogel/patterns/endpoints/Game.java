package de.moduliertersingvogel.patterns.endpoints;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mariadb.jdbc.MariaDbPoolDataSource;

import de.moduliertersingvogel.patterns.model.Cell;
import de.moduliertersingvogel.patterns.model.Coordinate;

@ApplicationScoped
@Path("game")
public class Game {
	private MariaDbPoolDataSource pool;
	protected static final Logger logger = LogManager.getLogger("patterns");

	public Game() {
		try {
			pool = new MariaDbPoolDataSource(
					"jdbc:mariadb://localhost:3306/patterns?user=root&password=root&maxPoolSize=10");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("{gameid}/{time}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTimestepFor(@PathParam("gameid") int gameid, @PathParam("time") int time) {
		List<Cell> cells = new ArrayList<>();
		try (Connection conn = pool.getConnection()) {
			final String query = "select * from patterns where gameid=? and time=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, gameid);
			statement.setInt(2, time);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Coordinate coordinate = new Coordinate(resultSet.getInt("x"), resultSet.getInt("y"), resultSet.getInt("z"));
				cells.add(new Cell(coordinate,
						resultSet.getString("id"), resultSet.getInt("state")));
			}
		} catch (SQLException e) {
			logger.catching(e);
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(cells).build();
	}
}
