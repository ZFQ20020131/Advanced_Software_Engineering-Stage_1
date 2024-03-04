public class flight {

    private String flightCode;
    private String carrier;
    private int maxPassengersCount;
    private int maxBaggageWeight;
    private String dAirport;
    private int extraBaggageCharge;

    public flight() {}

    public flight(String flightCode, String carrier, int maxPassengersCount, int maxBaggageWeight, String dAirport, int extraBaggageCharge) {
        this.flightCode = flightCode;
        this.carrier = carrier;
        this.maxPassengersCount = maxPassengersCount;
        this.maxBaggageWeight = maxBaggageWeight;
        this.dAirport = dAirport;
        this.extraBaggageCharge = extraBaggageCharge;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setMaxPassengersCount(int maxPassengersCount) {
        this.maxPassengersCount = maxPassengersCount;
    }

    public int getMaxPassengersCount() {
        return maxPassengersCount;
    }

    public void setMaxBaggageWeight(int maxBaggageWeight) {
        this.maxBaggageWeight = maxBaggageWeight;
    }

    public int getMaxBaggageWeight() {
        return maxBaggageWeight;
    }

    public void setDAirport(String dAirport) {
        this.dAirport = dAirport;
    }

    public String getDAirport() {
        return dAirport;
    }

    public void setExtraBaggageCharge(int extraBaggageCharge) {
        this.extraBaggageCharge = extraBaggageCharge;
    }

    public int getExtraBaggageCharge() {
        return extraBaggageCharge;
    }

}