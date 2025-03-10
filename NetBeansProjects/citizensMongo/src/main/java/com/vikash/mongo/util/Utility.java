package com.vikash.mongo.util;

import java.util.UUID;

public class Utility {

    public static boolean isExist(String checker){ return null !=checker && !checker.isBlank(); }

    public static String generateTrackingId(String requestId, String channelId) {

        return isExist(channelId) && isExist(requestId)
                ? generateUUID(requestId,channelId): generateUUID();

    }

    private static String generateUUID(String requestId, String channelId) {
        byte[] serialized=(channelId+requestId).getBytes();
        return UUID.nameUUIDFromBytes(serialized).toString();
    }

    private static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
