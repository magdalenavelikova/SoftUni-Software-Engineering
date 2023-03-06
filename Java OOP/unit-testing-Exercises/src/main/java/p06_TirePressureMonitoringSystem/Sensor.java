package p06_TirePressureMonitoringSystem;

import java.util.Random;

public class Sensor {
    // The reading of the pressure value from the sensor is simulated in this implementation.
    // Because the focus of the exercise is on the other class.

    private static final double OFFSET = 16;

    private static Random randomPressureSampleSimulator = new Random();

    public double popNextPressurePsiValue() {
        double pressureTelemetryValue = readPressureSample();
        return OFFSET + pressureTelemetryValue;
    }

    private double readPressureSample() {
        // Simulate info read from a real sensor in a real tire
        return 6 * randomPressureSampleSimulator.nextDouble() * randomPressureSampleSimulator.nextDouble();
    }
}
