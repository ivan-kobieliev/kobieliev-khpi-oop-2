package ua.khpi.oop.lab04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceCenter {
    private final String name;
    private final List<RepairRequest> requests = new ArrayList<>();
    private final List<RepairRecord> records = new ArrayList<>();

    public ServiceCenter(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Назва сервісного центру не може бути порожньою");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<RepairRequest> getRequests() {
        return requests;
    }

    public List<RepairRecord> getRecords() {
        return records;
    }

    public void registerRequest(RepairRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Заявка не може бути порожньою");
        }
        requests.add(request);
    }

    public RepairRecord startRepair(RepairRequest request, Technician technician, LocalDate startDate) {
        if (request == null || technician == null || startDate == null) {
            throw new IllegalArgumentException("Аргументи не можуть бути порожніми");
        }
        request.markInProgress();
        RepairRecord record = new RepairRecord(request, technician, startDate);
        records.add(record);
        return record;
    }

    public void finishRepair(RepairRecord record, LocalDate endDate) {
        if (record == null) {
            throw new IllegalArgumentException("Запис ремонту не може бути порожнім");
        }
        record.finish(endDate);
    }

    @Override
    public String toString() {
        return "СервіснийЦентр[назва=%s, заявки=%d, записи=%d]".formatted(
                name, requests.size(), records.size()
        );
    }
}