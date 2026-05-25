package ua.khpi.oop.lab15;

public class Main {
    public static void main(String[] args) {
        QueueExperiment experiment = new QueueExperiment();

        int threads = 4;
        int operationsPerThread = 100_000;

        experiment.runUnsafeExperiment(threads, operationsPerThread);

        experiment.runSafeExperiment(threads, operationsPerThread);

        experiment.runSequentialExperiment(
                threads * operationsPerThread
        );
    }
}