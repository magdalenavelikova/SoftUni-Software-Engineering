package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {
    private static final double LOW_PRESSURE = 10;
    private static final double HIGH_PRESSURE = 25;
    private static final double NORMAL_PRESSURE = 20;
    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void prepare() {
        sensor = mock(Sensor.class);
        alarm=new Alarm(sensor);
    }

    @Test
    public void testAlarmShouldBeOnBecauseOfLowPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOnBecauseOfHighPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void testAlarmShouldBeOffBecauseOfNormalPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}