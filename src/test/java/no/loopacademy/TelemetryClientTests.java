package no.loopacademy;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class TelemetryClientTests {

    @Test
    public void connectsToConfiguredTelemetryEndpointWhenCreated() {
        String expectedResult =
            "Connecting to telemetry at " + Config.telemetryEndpoint;

        PrintStream originalOutput = System.out;
        var output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));

            new TelemetryClient();

            String actualResult = output.toString().trim();

            assertEquals(expectedResult, actualResult);
        } finally {
            System.setOut(originalOutput);
        }
    }

    @Test
    public void readTelemetryReadingTypeIsTempOrPressure() {
        boolean expectedResult = true;

        String temp = "TEMP";
        String pressure = "PRESSURE";

        var telemetryClient = new TelemetryClient();

        TelemetryReading telemetryReading = telemetryClient.read();

        boolean actualResult =
            telemetryReading.type.equals(temp) ||
            telemetryReading.type.equals(pressure);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void readTelemetryReadingTimeStampIsWithinOneSecondOfCurrentTime() {
        long expectedResult = System.currentTimeMillis();
        int variance = 1000;

        var telemetryClient = new TelemetryClient();
        TelemetryReading telemetryReading = telemetryClient.read();

        long actualResult = telemetryReading.timestamp;

        assertEquals(expectedResult, actualResult, variance);
    }

    @Test
    public void readTelemetryReadingValueIsBetweenZeroAndHundred() {
        boolean expectedResult = true;

        var telemetryClient = new TelemetryClient();
        TelemetryReading telemetryReading = telemetryClient.read();

        double value = telemetryReading.value;

        double lowerLimit = 0;
        double highestLimit = 100;

        boolean actualResult = value > lowerLimit && value < highestLimit;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void runMission_checkForPassedString_aPassedStringValue() {
        SpaceMission mission = new SpaceMission();
        TestWrite writer = new TestWrite();
        mission.runMission(writer);

        String unexpectedWrittenResult = "";
        String actualWrittenResult = writer.getTest_field();

        assertNotEquals(unexpectedWrittenResult, actualWrittenResult);
    }
    
}
