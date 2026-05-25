package ua.khpi.oop.lab15;

public class OperatorTask implements Runnable {
    private final UnsafeRequestQueue unsafeQueue;
    private final SafeRequestQueue safeQueue;

    private final int operationsCount;
    private final boolean safeMode;

    public OperatorTask(UnsafeRequestQueue unsafeQueue, int operationsCount) {
        this.unsafeQueue = unsafeQueue;
        this.safeQueue = null;
        this.operationsCount = operationsCount;
        this.safeMode = false;
    }

    public OperatorTask(SafeRequestQueue safeQueue, int operationsCount) {
        this.unsafeQueue = null;
        this.safeQueue = safeQueue;
        this.operationsCount = operationsCount;
        this.safeMode = true;
    }

    @Override
    public void run() {
        for (int i = 0; i < operationsCount; i++) {

            Request request = new Request(
                    i + 1,
                    Thread.currentThread().getName(),
                    "Request text " + i
            );

            if (safeMode) {
                safeQueue.addRequest(request);
                safeQueue.processRequest();
            } else {
                unsafeQueue.addRequest(request);
                unsafeQueue.processRequest();
            }
        }
    }
}