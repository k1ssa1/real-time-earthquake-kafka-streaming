import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		
		log.info("Starting earthquake ingestion...");
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder(
		        URI.create("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson")
		    )
		    .GET()
		    .header("accept", "application/json")
		    .build();
		
		try {
			log.info("Sending request to USGS earthquake API...");
			HttpResponse<String> response = client.send(
				    request,
				    HttpResponse.BodyHandlers.ofString()
				);
			log.info("API response received. Status code: {}", response.statusCode());
		} catch (IOException e) {
			log.error("Failed to communicate with USGS API", e);
		} catch (InterruptedException e) {
			log.error("HTTP request was interrupted", e);
		}

	}

}
