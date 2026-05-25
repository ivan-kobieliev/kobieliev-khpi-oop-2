package ua.khpi.oop.lab15;

public class UnsafeRequestQueue {
    private int queueSize;
    private int processedCount;

    public void addRequest(Request request) {
        int currentSize = queueSize;
        queueSize = currentSize + 1;
    }

    public Request processRequest() {
        if (queueSize <= 0) {
            return null;
        }

        int currentSize = queueSize;
        queueSize = currentSize - 1;

        processedCount++;
        return new Request(processedCount, "Operator", "Processed request");
    }

    public int getQueueSize() {
        return queueSize;
    }

    public int getProcessedCount() {
        return processedCount;
    }
}