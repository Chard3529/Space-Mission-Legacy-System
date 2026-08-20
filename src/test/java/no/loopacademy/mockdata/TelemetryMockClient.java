package no.loopacademy.mockdata;

import no.loopacademy.DataReader;
import no.loopacademy.TelemetryReading;

public class TelemetryMockClient implements DataReader {

    public TelemetryReading reading;

    public void setReading(TelemetryReading reading) {
        this.reading = reading;
    }

    @Override
    public TelemetryReading read() {
        return this.reading;
    }
}
