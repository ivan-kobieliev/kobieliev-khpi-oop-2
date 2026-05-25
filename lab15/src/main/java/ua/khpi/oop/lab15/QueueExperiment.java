package ua.khpi.oop.lab15;

public class QueueExperiment {
    public void runUnsafeExperiment(int threadCount, int operationsPerThread) {
        UnsafeRequestQueue queue = new UnsafeRequestQueue();
        Thread[] threads = new Thread[threadCount];

        long start = System.nanoTime();

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(
                    new OperatorTask(queue, operationsPerThread),
                    "UnsafeOperator-" + (i + 1)
            );
        }

        startAndJoinAll(threads);

        long end = System.nanoTime();

        int expected = threadCount * operationsPerThread;

        System.out.println("=== Unsafe request queue ===");
        System.out.println("Threads: " + threadCount);
        System.out.println("Operations per thread: " + operationsPerThread);
        System.out.println("Expected processed requests: " + expected);
        System.out.println("Actual processed requests: " + queue.getProcessedCount());
        System.out.println("Final queue size: " + queue.getQueueSize());
        System.out.println("Time: " + ((end - start) / 1_000_000) + " ms");
        System.out.println();
    }

    public void runSafeExperiment(int threadCount, int operationsPerThread) {
        SafeRequestQueue queue = new SafeRequestQueue();
        Thread[] threads = new Thread[threadCount];

        long start = System.nanoTime();

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(
                    new OperatorTask(queue, operationsPerThread),
                    "SafeOperator-" + (i + 1)
            );
        }

        startAndJoinAll(threads);

        long end = System.nanoTime();

        int expected = threadCount * operationsPerThread;

        System.out.println("=== Safe request queue ===");
        System.out.println("Threads: " + threadCount);
        System.out.println("Operations per thread: " + operationsPerThread);
        System.out.println("Expected processed requests: " + expected);
        System.out.println("Actual processed requests: " + queue.getProcessedCount());
        System.out.println("Final queue size: " + queue.getQueueSize());
        System.out.println("Time: " + ((end - start) / 1_000_000) + " ms");
        System.out.println();
    }

    public void runSequentialExperiment(int operationsCount) {
        SafeRequestQueue queue = new SafeRequestQueue();

        long start = System.nanoTime();

        for (int i = 0; i < operationsCount; i++) {
            Request request = new Request(
                    i + 1,
                    "SequentialOperator",
                    "Request text " + i
            );

            queue.addRequest(request);
            queue.processRequest();
        }

        long end = System.nanoTime();

        System.out.println("=== Sequential request queue ===");
        System.out.println("Operations: " + operationsCount);
        System.out.println("Expected processed requests: " + operationsCount);
        System.out.println("Actual processed requests: " + queue.getProcessedCount());
        System.out.println("Final queue size: " + queue.getQueueSize());
        System.out.println("Time: " + ((end - start) / 1_000_000) + " ms");
        System.out.println();
    }

    private void startAndJoinAll(Thread[] threads) {
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}