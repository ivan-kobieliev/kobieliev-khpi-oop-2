package ua.khpi.oop.lab03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServiceCenterTest {

    private ServiceCenter center;
    private Client client;
    private Device device;
    private Technician technician;
    private RepairRequest request;

    @BeforeEach
    void setUp() {
        center = new ServiceCenter("FreshIT");
        client = new Client("C-1", "Іван Кобєлєв");
        device = new Device("D-1", "Lenovo");
        technician = new Technician("T-1", "Майстер");

        request = new RepairRequest(
                "R-1",
                client,
                device,
                "Не вмикається"
        );
    }

    @Test
    void registerRequestAddsRequest() {
        center.registerRequest(request);
        assertEquals(1, center.getRequests().size());
    }

    @Test
    void startRepairCreatesRecord() {
        center.registerRequest(request);

        RepairRecord record = center.startRepair(
                request,
                technician,
                LocalDate.now()
        );

        assertNotNull(record);
        assertEquals(1, center.getRecords().size());
        assertTrue(request.hasStatus("ВИКОНУЄТЬСЯ"));
    }

    @Test
    void finishRepairCompletesRecord() {
        center.registerRequest(request);

        RepairRecord record = center.startRepair(
                request,
                technician,
                LocalDate.now()
        );

        center.finishRepair(record, LocalDate.now().plusDays(1));

        assertTrue(record.isFinished());
        assertTrue(request.hasStatus("ЗАВЕРШЕНО"));
    }

    @Test
    void startRepairWithNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                center.startRepair(null, technician, LocalDate.now())
        );
    }
}