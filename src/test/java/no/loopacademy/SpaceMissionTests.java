package no.loopacademy;

import static org.junit.jupiter.api.Assertions.*;

import no.loopacademy.mockdata.TelemetryMockClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpaceMissionTests {

    private TestWrite testWriter;
    private SpaceMission defaultMission;

    private SpaceMission testMission;
    private TelemetryMockClient mockClient;

    @BeforeEach
    public void setUp() {
        this.testWriter = new TestWrite();
        this.defaultMission = new SpaceMission();

        this.mockClient = new TelemetryMockClient();
        this.testMission = new SpaceMission(mockClient);
    }

    @Test
    public void runMission_checkForPassedString_aPassedStringValue() {
        String unexpectedWrittenResult = "";

        defaultMission.runMission(testWriter);

        String actualWrittenResult = testWriter.getTest_field();

        assertNotEquals(unexpectedWrittenResult, actualWrittenResult);
    }

    @Test
    public void runMission_checkThatTEMPgivesCorrectOutput_startOfStringIsTemprature() {
        String expectedResult = "Temperature:";

        TelemetryReading reading = new TelemetryReading();
        reading.type = "TEMP";
        mockClient.setReading(reading);

        testMission.runMission(testWriter);

        String writerOutput = testWriter.getTest_field();

        String[] lines = writerOutput.split("\n");
        String[] wordsFirstLine = lines[0].split(" ");
        String actualResult = wordsFirstLine[0];

        assertEquals(expectedResult, actualResult);
    }
}
