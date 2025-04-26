package org.rajesh;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerformanceServiceTest {


    PerformanceService service = new PerformanceService();

    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() throws InterruptedException {
        String result = service.LongRunningTask();

        assertEquals("Completed", result);
    }

}
