public class flight {

    private String flightCode;
    private String dAirport;
    private String carrier;
    private int maxPassengersCount;
    private int chargedBaggageWeight;
    private int maxBaggageVolume;
    private int maxBaggageWeight;

    public flight() {}

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setDAirport(String dAirport) {
        this.dAirport = dAirport;
    }

    public String getDAirport() {
        return dAirport;
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

    public void setChargedBaggageWeight(int chargedBaggageWeight) {
        this.chargedBaggageWeight = chargedBaggageWeight;
    }

    public int getChargedBaggageWeight() {
        return chargedBaggageWeight;
    }

    public void setMaxBaggageVolume(int maxBaggageVolume) {
        this.maxBaggageVolume = maxBaggageVolume;
    }

    public int getMaxBaggageVolume() {
        return maxBaggageVolume;
    }

    public void setMaxBaggageWeight(int maxBaggageWeight) {
        this.maxBaggageWeight = maxBaggageWeight;
    }

    public int getMaxBaggageWeight() {
        return maxBaggageWeight;
    }
}