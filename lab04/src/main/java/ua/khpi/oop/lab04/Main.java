package ua.khpi.oop.lab04;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ServiceCenter center = new ServiceCenter("FreshIT");
        Client client = new Client("C-1", "Іван Кобєлєв");
        Device device = new Device("D-1", "Lenovo LOQ 15IAX9");
        Technician technician = new Technician("T-1", "Олександр Бондаренко");

        RepairRequest request = new RepairRequest(
                "R-1",
                client,
                device,
                "Ноутбук не вмикається"
        );

        center.registerRequest(request);
        RepairRecord record = center.startRepair(request, technician, LocalDate.now());
        center.finishRepair(record, LocalDate.now().plusDays(2));

        System.out.println(center);
        System.out.println(request);
        System.out.println(record);
    }
}