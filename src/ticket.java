// Custom exception class for handling invalid booking reference codes
class InvalidBookingReferenceException extends Exception {
    public InvalidBookingReferenceException(String message) {
        super(message);
    }
}

// Main class representing a ticket with properties such as reference code, passenger name, flight code, and check-in status
public class ticket {
    private String referenceCode;
    private Name name; // Assuming 'Name' is a class that holds passenger name details
    private String flightCode;
    private boolean isCheckedIn;

    // Default constructor
    public ticket() {
    }

    // Constructor that validates the booking reference code and throws a custom exception if invalid
    public ticket(String referenceCode, Name name, String flightCode, boolean isCheckedIn) throws InvalidBookingReferenceException {
        if (!isValidReferenceCode(referenceCode)) {
            throw new InvalidBookingReferenceException("Invalid booking reference code: " + referenceCode);
        }
        this.setReferenceCode(referenceCode);
        this.setName(name);
        this.setFlightCode(flightCode);
        this.setIsCheckedIn(isCheckedIn);
    }

    // Method to validate the booking reference code; assumes it's valid if not null and has a length of 10
    private boolean isValidReferenceCode(String referenceCode) {
        return referenceCode != null && referenceCode.length() == 10;
    }

    // Setter and getter methods for each property
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
