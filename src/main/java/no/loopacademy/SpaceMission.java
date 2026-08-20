package no.loopacademy;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class SpaceMission {

    private DataReader client;

    public SpaceMission() {
        this.client = new TelemetryClient();
    }

    public SpaceMission(DataReader dataReaderClient) {
        this.client = dataReaderClient;
    }

    public void runMission(Writer fw) {
        for (int i = 0; i < 5; i++) {
            TelemetryReading r = client.read();

            if ("TEMP".equals(r.type)) {
                fw.write(
                    "Temperature: " + r.value + " C at " + r.timestamp + "\n"
                );
            } else if ("PRESSURE".equals(r.type)) {
                fw.write(
                    "Pressure: " + r.value + " kPa at " + r.timestamp + "\n"
                );
            } else {
                fw.write("Unknown reading " + r.type + "\n");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void emergencyLog(String message) {
        try (FileWriter fw = new FileWriter(Config.logFile, true)) {
            fw.write(
                "EMERGENCY: " + message + " at " + LocalDateTime.now() + "\n"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
