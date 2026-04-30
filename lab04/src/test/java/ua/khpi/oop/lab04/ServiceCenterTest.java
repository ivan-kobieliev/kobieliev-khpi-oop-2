package ua.khpi.oop.lab04;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.*;

public class ServiceCenterTest {

    private ServiceCenter center;
    private Client client;
    private Device device;
    private Technician technician;
    private RepairRequest request;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        center = new ServiceCenter("FreshIT");
        client = new Client("C-1", "Іван Кобєлєв");
        device = new Device("D-1", "Lenovo LOQ");
        technician = new Technician("T-1", "Олександр Бондаренко");
        request = new RepairRequest("R-1", client, device, "Ноутбук не вмикається");
    }

    @Test(groups = {"smoke", "domain"})
    public void registerRequestAddsRequest() {
        center.registerRequest(request);
        assertEquals(center.getRequests().size(), 1);
    }

    @Test(groups = {"domain"})
    public void startRepairCreatesRecord() {
        center.registerRequest(request);
        RepairRecord record = center.startRepair(request, technician, LocalDate.now());

        assertNotNull(record);
        assertEquals(center.getRecords().size(), 1);
        assertTrue(request.hasStatus("ВИКОНУЄТЬСЯ"));
    }

    @Test(groups = {"domain"})
    public void finishRepairCompletesRecord() {
        center.registerRequest(request);
        RepairRecord record = center.startRepair(request, technician, LocalDate.now());
        center.finishRepair(record, LocalDate.now().plusDays(1));

        assertTrue(record.isFinished());
        assertTrue(request.hasStatus("ЗАВЕРШЕНО"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"negative"})
    public void startRepairWithNullThrowsException() {
        center.startRepair(null, technician, LocalDate.now());
    }
}