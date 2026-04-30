package ua.khpi.oop.lab04;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RepairRequestTest {

    private Client client;
    private Device device;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        client = new Client("C-1", "Іван Кобєлєв");
        device = new Device("D-1", "Lenovo LOQ");
    }

    @Test(groups = {"smoke", "domain"})
    public void createRepairRequestSuccess() {
        RepairRequest request = new RepairRequest("R-1", client, device, "Проблема");

        assertNotNull(request);
        assertEquals(request.getStatus(), "ЗАРЕЄСТРОВАНО");
    }

    @Test(groups = {"domain"})
    public void repairRequestChangesStatusToInProgress() {
        RepairRequest request = new RepairRequest("R-1", client, device, "Проблема");

        request.markInProgress();

        assertTrue(request.hasStatus("ВИКОНУЄТЬСЯ"));
    }

    @Test(groups = {"domain"})
    public void repairRequestChangesStatusToCompleted() {
        RepairRequest request = new RepairRequest("R-1", client, device, "Проблема");

        request.markCompleted();

        assertTrue(request.hasStatus("ЗАВЕРШЕНО"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"negative"})
    public void createRepairRequestWithNullId() {
        new RepairRequest(null, client, device, "Проблема");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"negative"})
    public void createRepairRequestWithBlankProblem() {
        new RepairRequest("R-1", client, device, "");
    }
}