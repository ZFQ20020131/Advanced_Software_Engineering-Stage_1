public class ticket {
    private String referenceCode;
    private Name name;
    private String flightCode;
    private boolean isCheckedIn;

    public ticket() {
    }

    public ticket(String referenceCode, Name name, String flightCode, boolean isCheckedIn) {
        this.setReferenceCode(referenceCode);
        this.setName(name);
        this.setFlightCode(flightCode);
        this.setIsCheckedIn(isCheckedIn);
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getReferenceCode() {
        return this.referenceCode;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Name getName() {
        return this.name;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getFlightCode() {
        return this.flightCode;
    }

    public void setIsCheckedIn(boolean isCheckedIn) {
        this.isCheckedIn = isCheckedIn;
    }

    public boolean getIsCheckedIn() {
        return this.isCheckedIn;
    }
}
