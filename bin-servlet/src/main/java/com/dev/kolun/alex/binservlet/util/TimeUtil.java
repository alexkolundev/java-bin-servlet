package com.dev.kolun.alex.binservlet.util;

import lombok.experimental.UtilityClass;

import java.time.Instant;

@UtilityClass
public class TimeUtil {

    public static long startTime() {
        return Instant.now().toEpochMilli();
    }

    public static long endTime(long startTime) {
        return Instant.now().toEpochMilli() - startTime;
    }

}
