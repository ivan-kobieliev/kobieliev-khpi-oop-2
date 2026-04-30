package ua.khpi.oop.lab01;

public class Main {
    public static void main(String[] args) {
        ServiceCenter serviceCenter = new ServiceCenter(
                "SC01",
                "FreshIT",
                "м. Харків, вул. Свободи, 24",
                "+380123123123"
        );

        Client client = new Client(
                "CL01",
                "Іван Кобєлєв",
                "+380123456789",
                "Ivan.Kobieliev@cs.khpi.edu.ua"
        );

        Device device = new Device(
                "DV01",
                "Ноутбук",
                "Lenovo",
                "LOQ 15IAX9"
        );

        Technician technician = new Technician(
                "TC01",
                "Олександр Бондаренко",
                "Ремонт ноутбуків",
                "+380987654321"
        );

        RepairRequest request = new RepairRequest(
                "RQ01",
                "Ноутбук не вмикається",
                "Зареєстровано",
                "21.04.2026"
        );

        System.out.println("Лабораторна робота №1");
        System.out.println("Предметна галузь: реєстрація заявок на ремонт техніки");
        System.out.println();

        serviceCenter.printCenterInfo();
        client.printClientInfo();
        device.printDeviceInfo();
        technician.printTechnicianInfo();
        request.printRequestInfo();

        System.out.println();
        System.out.println("Повний вивід об'єктів:");
        System.out.println(serviceCenter);
        System.out.println(client);
        System.out.println(device);
        System.out.println(technician);
        System.out.println(request);
    }
}