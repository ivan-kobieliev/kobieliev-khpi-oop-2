package ua.khpi.oop.lab15;

import java.util.ArrayList;
import java.util.List;

public class SafeRequestQueue {
    private final List<Request> requests = new ArrayList<>();
    private final Object lock = new Object();

    private int processedCount;

    public void addRequest(Request request) {
        synchronized (lock) {
            requests.add(request);
        }
    }

    public Request processRequest() {
        synchronized (lock) {
            if (requests.isEmpty()) {
                return null;
            }

            Request request = requests.remove(0);
            processedCount++;
            return request;
        }
    }

    public int getQueueSize() {
        synchronized (lock) {
            return requests.size();
        }
    }

    public int getProcessedCount() {
        synchronized (lock) {
            return processedCount;
        }
    }
}