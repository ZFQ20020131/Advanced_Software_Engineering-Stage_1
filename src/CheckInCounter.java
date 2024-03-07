import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CheckInCounter {
    private String currentReferenceNumber;
    static int totalPassengersCheckedIn = 0;
    static double totalExcessBaggageFeeCollected = 0;
    static int totalBaggageWeightCheckedIn = 0;
    static int totalBaggageVolumeCheckedIn = 0;
    static Map<String, ticket> ticketsMap = new HashMap<>();
    static Map<String, flight> flightDetailsMap = new HashMap<>();

    // Initializes the application by loading data and opening the GUI.
    public static void main(String[] args) {
        try {
            URL bookingFilePath = CheckInCounter.class.getResource("BookingDetails.csv");
            URL flightDetailsFilePath = CheckInCounter.class.getResource("FlightDetails.csv");
            loadDataFromFiles(bookingFilePath.getFile(), flightDetailsFilePath.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        new GUI().createWindowOne();
    }

    // Loads booking and flight details from CSV files.
    private static void loadDataFromFiles(String bookingsFile, String flightDetailsFile) throws IOException {
        File bookings = new File(bookingsFile);
        File flightDetails = new File(flightDetailsFile);
        try (BufferedReader bookingsReader = new BufferedReader(new FileReader(bookings));
             BufferedReader flightDetailsReader = new BufferedReader(new FileReader(flightDetails))) {
            bookingsReader.lines().forEach(CheckInCounter::handleTicket);
            flightDetailsReader.lines().forEach(CheckInCounter::handleFlightDetail);
        }
    }

    // Parses and stores information for each ticket from the bookings file.
    private static void handleTicket(String booking) {
        String[] details = booking.split(",");
        ticket newTicket = new ticket();
        newTicket.setReferenceCode(details[0]);
        newTicket.setName(new Name(details[1]));
        newTicket.setFlightCode(details[2]);
        newTicket.setIsCheckedIn(Boolean.parseBoolean(details[3]));
        ticketsMap.put(details[0], newTicket);
    }

    // Parses and stores flight details from the flight details file.
    private static void handleFlightDetail(String detail) {
        String[] data = detail.split(",");
        flight newFlight = new flight();
        newFlight.setFlightCode(data[0]);
        newFlight.setDAirport(data[1]);
        newFlight.setCarrier(data[2]);
        newFlight.setMaxPassengersCount(Integer.parseInt(data[3]));
        newFlight.setChargedBaggageWeight(Integer.parseInt(data[4]));
        newFlight.setMaxBaggageVolume(Integer.parseInt(data[5]));
        newFlight.setMaxBaggageWeight(Integer.parseInt(data[6]));
        flightDetailsMap.put(data[0], newFlight);
    }

    // Verifies if the entered reference number is valid.
    public boolean verifyReferenceNumber(String enteredReferenceNumber) {
        return ticketsMap.containsKey(enteredReferenceNumber);
    }

    // Checks if the passenger has already checked in.
    public boolean isCheckin(String enteredReferenceNumber) {
        return ticketsMap.get(enteredReferenceNumber).getIsCheckedIn();
    }

    // Validates the last name of the passenger with the entered reference number.
    public boolean checkLastName(String enteredReferenceNumber, String enteredLastName) {
        return ticketsMap.get(enteredReferenceNumber).getName().getLastName().equalsIgnoreCase(enteredLastName);
    }

    public String getCurrentReferenceNumber() {
        return currentReferenceNumber;
    }

    public void setCurrentReferenceNumber(String enteredReferenceNumber) {
        this.currentReferenceNumber = enteredReferenceNumber;
    }

    public int getMaxPassengers() {
        if (currentReferenceNumber != null && !currentReferenceNumber.isEmpty()) {
            int maxPassengers = flightDetailsMap.get(ticketsMap.get(currentReferenceNumber).getFlightCode()).getMaxPassengersCount();
            return maxPassengers;
        }
        return -1;
    }

    public int getMaxBaggageVolume() {
        if (currentReferenceNumber != null && !currentReferenceNumber.isEmpty()) {
            int maxVolume = flightDetailsMap.get(ticketsMap.get(currentReferenceNumber).getFlightCode()).getMaxBaggageVolume();
            return maxVolume;
        }
        return -1;
    }

    public int getMaxBaggageWeight() {
        if (currentReferenceNumber != null && !currentReferenceNumber.isEmpty()) {
            int maxWeight = flightDetailsMap.get(ticketsMap.get(currentReferenceNumber).getFlightCode()).getMaxBaggageWeight();
            return maxWeight;
        }
        return -1;
    }

    // Calculates extra charges based on baggage weight and volume, updating totals accordingly.
    public String calcExtraCharge(String enteredReferenceNumber, String enteredBaggageWeight, String vol) {
        //currentFlight = flightDetailsMap.get(ticketsMap.get(enteredReferenceNumber).getFlightCode());
        int chargedWeight = flightDetailsMap.get(ticketsMap.get(enteredReferenceNumber).getFlightCode()).getChargedBaggageWeight();
        double charge = Double.parseDouble(vol);

        double extraWeightage = Double.parseDouble(enteredBaggageWeight) - chargedWeight;
        double chargePayable = extraWeightage > 0 ? extraWeightage * charge : 0;

        String chargeLabel = String.valueOf(chargePayable);

        totalExcessBaggageFeeCollected += chargePayable;
        totalBaggageWeightCheckedIn += Double.parseDouble(enteredBaggageWeight);
        totalBaggageVolumeCheckedIn += Double.parseDouble(vol);

        return chargeLabel;
    }
}
