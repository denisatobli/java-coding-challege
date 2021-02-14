package gas.station;

public class GasStationsTour {

    private GasStation[] build(String[] arr, int nrOfGasStations) {
        GasStation[] gasStations = new GasStation[nrOfGasStations];

        for (int i = 1; i <= nrOfGasStations; i++) {
            String[] gasStation = arr[i].split(":");
            gasStations[i - 1] = new GasStation(Integer.parseInt(gasStation[0]), Integer.parseInt(gasStation[1]));
        }
        return gasStations;
    }

    public String getStartingGasStation(String[] arr) {
        int nrOfGasStations = Integer.parseInt(arr[0]);
        GasStation[] gasStations = build(arr, nrOfGasStations);

        int start = 0, end = 1;
        int currAmountOfGallons = gasStations[start].getAmountGallonsOfGas() - gasStations[start].getAmountGallonsOfGasNeeded();

        while (currAmountOfGallons < 0 || end != start) {
            while (currAmountOfGallons < 0 && start != end) {
                currAmountOfGallons -= gasStations[start].getAmountGallonsOfGas() - gasStations[start].getAmountGallonsOfGasNeeded();
                start = (start + 1) % nrOfGasStations;

                if (start == 0) {
                    return "Impossible";
                }
            }
            currAmountOfGallons += gasStations[end].getAmountGallonsOfGas() - gasStations[end].getAmountGallonsOfGasNeeded();
            end = (end + 1) % nrOfGasStations;
        }
        return String.valueOf(start + 1);
    }

}
