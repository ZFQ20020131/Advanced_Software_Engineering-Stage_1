public class Name {
    // Fields to store the first, middle, and last names
    private String firstName;
    private String middleName;
    private String lastName;

    // Constructor that parses the full name into its components
    public Name(String fullName) {
        parseFullName(fullName);
    }

    // Parses the full name into first, middle, and last names
    private void parseFullName(String fullName) {
        String[] parts = fullName.split(" ");
        switch (parts.length) {
            case 1:
                this.firstName = parts[0];
                this.middleName = "";
                this.lastName = "";
                break;
            case 2:
                this.firstName = parts[0];
                this.middleName = "";
                this.lastName = parts[1];
                break;
            default:
                this.firstName = parts[0];
                // Joins the middle parts of the name if more than 3 parts exist
                this.middleName = String.join(" ", java.util.Arrays.copyOfRange(parts, 1, parts.length - 1));
                this.lastName = parts[parts.length - 1];
                break;
        }
    }

    // Sets the first name
    public void setFirstName(String fn) { this.firstName = fn; }

    // Sets the middle name
    public void setMiddleName(String mn) { this.middleName = mn; }

    // Sets the last name
    public void setLastName(String ln) { this.lastName = ln; }

    // Returns the first name
    public String getFirstName() { return this.firstName; }

    // Returns the middle name
    public String getMiddleName() { return this.middleName; }

    // Returns the last name
    public String getLastName() { return this.lastName; }

    // Returns the first and last name combined
    public String getFirstAndLastName() { return this.firstName + " " + this.lastName; }

    // Returns the last name followed by a comma and the first name
    public String getLastCommaFirst() { return this.lastName + ", " + this.firstName; }

    // Returns the full name, correctly formatted
    public String getFullName() {
        return this.firstName + (this.middleName.isEmpty() ? "" : " " + this.middleName) + " " + this.lastName;
    }

    // Returns the initials of the first, middle, and last names
    public String getInitials() {
        return (this.firstName.isEmpty() ? "" : this.firstName.substring(0, 1)) +
                (this.middleName.isEmpty() ? "" : this.middleName.substring(0, 1)) +
                (this.lastName.isEmpty() ? "" : this.lastName.substring(0, 1));
    }
}
