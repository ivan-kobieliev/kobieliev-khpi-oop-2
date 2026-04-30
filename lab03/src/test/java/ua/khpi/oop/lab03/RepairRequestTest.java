package ua.khpi.oop.lab03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepairRequestTest {

    private Client client;
    private Device device;
    private RepairRequest request;

    @BeforeEach
    void setUp() {
        client = new Client("C-1", "Іван Кобєлєв");
        device = new Device("D-1", "Lenovo LOQ 15IAX9");
        request = new RepairRequest(
                "R-1",
                client,
                device,
                "Ноутбук не вмикається"
        );
    }

    @Test
    void createRepairRequestWithCorrectArguments() {
        assertEquals("R-1", request.getRequestId());
        assertEquals(client, request.getClient());
        assertEquals(device, request.getDevice());
        assertEquals("Ноутбук не вмикається", request.getProblemDescription());
        assertEquals("ЗАРЕЄСТРОВАНО", request.getStatus());
    }

    @Test
    void repairRequestChangesStatusToInProgress() {
        request.markInProgress();
        assertTrue(request.hasStatus("ВИКОНУЄТЬСЯ"));
    }

    @Test
    void repairRequestChangesStatusToCompleted() {
        request.markCompleted();
        assertTrue(request.hasStatus("ЗАВЕРШЕНО"));
    }

    @Test
    void createRepairRequestWithNullIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new RepairRequest(null, client, device, "Проблема")
        );
    }

    @Test
    void createRepairRequestWithBlankProblemThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new RepairRequest("R-2", client, device, " ")
        );
    }
}