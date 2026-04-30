package ua.khpi.oop.lab04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ClientTest {

    @Test(groups = {"smoke", "domain"})
    public void createClientSuccess() {
        Client client = new Client("C-1", "Іван Кобєлєв");

        assertEquals(client.getClientId(), "C-1");
        assertEquals(client.getFullName(), "Іван Кобєлєв");
    }

    @DataProvider(name = "invalidClients")
    public Object[][] invalidClients() {
        return new Object[][]{
                {null, "Іван"},
                {"", "Іван"},
                {"C-1", null},
                {"C-1", ""}
        };
    }

    @Test(dataProvider = "invalidClients", groups = {"negative"},
            expectedExceptions = IllegalArgumentException.class)
    public void createClientWithInvalidArgumentsThrowsException(String id, String fullName) {
        new Client(id, fullName);
    }
}