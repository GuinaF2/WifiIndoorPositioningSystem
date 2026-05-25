package com.example.andreseidel.interculturel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.andreseidel.interculturel.Room;
import com.example.andreseidel.interculturel.RouterInRoom;

public class RoomIntegrationTest {

    @Test
    public void testRoomAndRouterDataIntegration() {
        Room labRoom = new Room("Lab_01");

        RouterInRoom router1 = new RouterInRoom("00:14:22:01:23:45", -45);
        RouterInRoom router2 = new RouterInRoom("0A:1B:2C:3D:4E:5F", -70);
        RouterInRoom router3 = new RouterInRoom("00:14:22:01:23:45", -42);

        labRoom.add(router1);
        labRoom.add(router2);
        labRoom.add(router3);

        String actualCsvOutput = labRoom.toCSV();

        assertNotNull(actualCsvOutput);
        assertTrue(actualCsvOutput.contains("Lab_01"));
        assertTrue(actualCsvOutput.contains("00:14:22:01:23:45"));
        assertTrue(actualCsvOutput.contains("0A:1B:2C:3D:4E:5F"));
    }
}