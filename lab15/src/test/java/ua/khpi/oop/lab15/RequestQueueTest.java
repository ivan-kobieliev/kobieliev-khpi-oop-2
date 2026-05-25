package ua.khpi.oop.lab15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestQueueTest {

    @Test
    void requestShouldStoreDataCorrectly() {
        Request request = new Request(1, "Ivan", "Internet problem");

        assertEquals(1, request.getId());
        assertEquals("Ivan", request.getClientName());
        assertEquals("Internet problem", request.getText());
    }

    @Test
    void requestShouldRejectInvalidData() {
        assertThrows(IllegalArgumentException.class,
                () -> new Request(0, "Ivan", "Text"));

        assertThrows(IllegalArgumentException.class,
                () -> new Request(1, "", "Text"));

        assertThrows(IllegalArgumentException.class,
                () -> new Request(1, "Ivan", ""));
    }

    @Test
    void safeQueueShouldAddAndProcessRequest() {
        SafeRequestQueue queue = new SafeRequestQueue();

        queue.addRequest(new Request(1, "Ivan", "First request"));

        assertEquals(1, queue.getQueueSize());

        Request processed = queue.processRequest();

        assertNotNull(processed);
        assertEquals(0, queue.getQueueSize());
        assertEquals(1, queue.getProcessedCount());
    }

    @Test
    void safeQueueShouldReturnNullWhenQueueIsEmpty() {
        SafeRequestQueue queue = new SafeRequestQueue();

        Request processed = queue.processRequest();

        assertNull(processed);
        assertEquals(0, queue.getQueueSize());
        assertEquals(0, queue.getProcessedCount());
    }

    @Test
    void safeQueueShouldWorkCorrectlyWithSeveralThreads() throws InterruptedException {
        SafeRequestQueue queue = new SafeRequestQueue();

        int threadCount = 4;
        int operationsPerThread = 100_000;
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(
                    new OperatorTask(queue, operationsPerThread)
            );
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int expected = threadCount * operationsPerThread;

        assertEquals(expected, queue.getProcessedCount());
        assertEquals(0, queue.getQueueSize());
    }
}