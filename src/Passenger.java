public class Passenger {
    // Variable to store the name of the traveler
    private Name personName;
    // Variable to store the check-in status of the traveler
    private boolean hasCheckedIn;

    // Default constructor
    public Passenger() {}

    // Constructor with parameters to initialize the traveler's name and check-in status
    public Passenger(String fullName, boolean isChecked) {
        this.personName = new Name(fullName);
        this.hasCheckedIn = isChecked;
    }

    // Method to get the check-in status of the traveler
    public boolean checkInStatus() {
        return this.hasCheckedIn;
    }

    // Method to set the check-in status of the traveler
    public void updateCheckInStatus(boolean status) {
        this.hasCheckedIn = status;
    }

    // Method to get the name of the traveler
    public Name passengerName() {
        return this.personName;
    }

    // Method to set the name of the traveler
    public void updateName(Name newName) {
        this.personName = newName;
    }
}
