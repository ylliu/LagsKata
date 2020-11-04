
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbeasCrop {
    private List<Flight> flightList = new ArrayList<Flight>();

    public AbeasCrop(Flight... flights) {
        flightList.addAll(Arrays.asList(flights));
    }

    public List<Flight> getFlights() {
        return flightList;
    }

    public int maxGain() {
        mergeFlights();
        return getMaxGain();
    }

    private int getMaxGain() {
        int maxGain = 0;
        for (Flight flight : flightList) {
            maxGain += flight.getCost();
        }
        return maxGain;
    }

    private void mergeFlights() {
        for (int i = 0; i < flightList.size() - 1; ) {
            if (isCrossed(i)) {
                remainHighCostFlight(i);
                continue;
            }
            i++;
        }
    }

    private void remainHighCostFlight(int i) {
        if (flightList.get(i).getCost() > flightList.get(i + 1).getCost()) {
            flightList.remove(i + 1);
            return;
        }
        flightList.remove(i);
    }

    private boolean isCrossed(int i) {
        return flightList.get(i).getEnd() > flightList.get(i+1).getStart();
    }
}

