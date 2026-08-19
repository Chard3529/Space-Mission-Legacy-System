package no.loopacademy;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class SpaceTests {

    @Test
    public void connectsToConfiguredTelemetryEndpointWhenCreated(){
        String expectedResult = "Connecting to telemetry at " + Config.telemetryEndpoint;

        PrintStream originalOutput = System.out;
        var output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));

            new TelemetryClient();

            String actualResult = output.toString().trim();

            assertEquals(expectedResult, actualResult);
        }
        finally {
            System.setOut(originalOutput);
        }

    }
}
