package questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a String[][] of available direct flights, a starting and end
 * destination, and an appropriate number of stops, return the cheapest flight
 *
 */
public class GetCheapestFlightOption {

	Map<String, Hubs> flightOptions = new HashMap<>();

	class Hubs {
		String source;
		Map<String, Integer> prices = new HashMap<>();
	}

	class Itinerary {
		List<String> stops;
		String lastLocation;
		int price;
	}

	void backtrace(List<Itinerary> acceptedFlights, Itinerary currentItinerary, String end, int remainingStops) {
		if (remainingStops == 0) {
			return;
		}

		Hubs price = flightOptions.get(currentItinerary.lastLocation);
		
		
	}

	public static void main(String[] args) {
		String[][] flights = {
				{ "Amsterdam", "Sydney", "360"},
				{ "Amsterdam", "Philadelphia", "400"}
		};
	}
	
}
