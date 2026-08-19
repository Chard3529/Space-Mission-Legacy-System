package no.loopacademy.tests;

import no.loopacademy.TelemetryClient;
import no.loopacademy.TelemetryReading;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class SpaceTests {

    @Test
    public void check_If_type_Is_pressure_Or_temp(){

        String temp = "TEMP";
        String pressure = "PRESSURE";

        TelemetryClient telemetryClient = new TelemetryClient();
        TelemetryReading reading= telemetryClient.read();

        String actualType = reading.type;

        assert actualType == temp || actualType == pressure;
    }

    @Test
    public void check_If_type_Is_pressure_Or_temp_bool(){
        List<String> excpectedTypeList = new ArrayList<>();

        String temp = "TEMP";
        String pressure = "PRESSURE";
        excpectedTypeList.add(temp);
        excpectedTypeList.add(pressure);
        boolean expected_result = true;

        TelemetryClient telemetryClient = new TelemetryClient();
        TelemetryReading reading= telemetryClient.read();
        boolean actual_result = excpectedTypeList.contains(reading.type);


        assert actual_result == expected_result;
    }
}
