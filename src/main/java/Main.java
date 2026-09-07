import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

	public static void main(String[] args) {
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder(
		        URI.create("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson")
		    )
		    .GET()
		    .header("accept", "application/json")
		    .build();
		
		try {
			HttpResponse<String> response = client.send(
				    request,
				    HttpResponse.BodyHandlers.ofString()
				);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
