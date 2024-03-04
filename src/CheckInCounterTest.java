import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class CheckInCounterTest {

    private CheckInCounter checkInCounter;

    @BeforeEach
    void setUp() {
        checkInCounter = new CheckInCounter();
        // Directly add test data
        checkInCounter.ticketsMap = new HashMap<>();
        checkInCounter.flightDetailsMap = new HashMap<>();

        // Add a fake ticket and flight details for test data
        ticket testTicket = new ticket();
        testTicket.setReferenceCode("validRef");
        testTicket.setName(new Name("Sarah Brown")); // Note: Based on Name class parsing rules
        testTicket.setFlightCode("FL123");
        testTicket.setIsCheckedIn(false);

        flight testFlight = new flight();
        testFlight.setFlightCode("FL123");
        testFlight.setMaxPassengersCount(200);
        testFlight.setMaxBaggageWeight(20); // Assuming the max baggage weight is 20kg
        testFlight.setExtraBaggageCharge(100); // Extra charge per kg for overweight

        checkInCounter.ticketsMap.put("validRef", testTicket);
        checkInCounter.flightDetailsMap.put("FL123", testFlight);
    }

    @Test
    void verifyReferenceNumber_Valid() {
        assertTrue(checkInCounter.verifyReferenceNumber("validRef"));
    }

    @Test
    void verifyReferenceNumber_Invalid() {
        assertFalse(checkInCounter.verifyReferenceNumber("invalidRef"));
    }

    @Test
    void isCheckin_NotCheckedIn() {
        assertFalse(checkInCounter.isCheckin("validRef"));
    }

    @Test
    void checkLastName_Match() {
        assertTrue(checkInCounter.checkLastName("validRef", "Brown")); // Correct lastName to match
    }

    @Test
    void checkLastName_NoMatch() {
        assertFalse(checkInCounter.checkLastName("validRef", "NonMatchingLastName"));
    }

    @Test
    void calcExtraCharge_NoExtraCharge() {
        assertEquals("0.0", checkInCounter.calcExtraCharge("validRef", "20", "100"));
    }

    @Test
    void calcExtraCharge_WithExtraCharge() {
        // Overweight by 5kg, expected extra charge is 500
        assertEquals("500.0", checkInCounter.calcExtraCharge("validRef", "25", "100"));
    }
}


