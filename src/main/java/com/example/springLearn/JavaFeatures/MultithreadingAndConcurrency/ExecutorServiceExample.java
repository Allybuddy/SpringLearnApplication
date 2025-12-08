package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws Exception {
        System.out.println("=== ExecutorService examples starting ===\n");

        exampleFixedThreadPool();
        exampleCachedThreadPool();
        exampleSingleThreadExecutor();
        exampleScheduledThreadPool();

        exampleWorkStealingPool();
        exampleCustomThreadPoolExecutor();
        exampleForkJoinPool();

        System.out.println("\n=== All examples submitted (main may have awaited where appropriate) ===");
    }

    // 1) Fixed thread pool
    private static void exampleFixedThreadPool() throws InterruptedException {
        System.out.println("-- fixed thread pool example --");
        ExecutorService ex = Executors.newFixedThreadPool(3);

        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            ex.submit(() -> {
                try {
                    Thread.sleep(300);
                    System.out.println("[fixed] task " + id + " running on " + Thread.currentThread().getName());
                } catch (InterruptedException ignored) {
                } finally {
                    latch.countDown();
                }
            });
        }

        // Wait for tasks to finish then shutdown
        latch.await();
        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("[fixed] done\n");
    }

    // 2) Cached thread pool
    private static void exampleCachedThreadPool() throws InterruptedException, ExecutionException {
        System.out.println("-- cached thread pool example --");
        ExecutorService ex = Executors.newCachedThreadPool();

        List<Future<String>> futures = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            final int id = i;
            futures.add(ex.submit(() -> {
                Thread.sleep(200);
                String msg = "[cached] task " + id + " on " + Thread.currentThread().getName();
                System.out.println(msg);
                return msg;
            }));
        }

        // Demonstrate that get() blocks the caller — but we can also check completion without blocking using isDone()
        for (Future<String> f : futures) {
            // blocking get
            System.out.println("[cached] future result: " + f.get());
        }

        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("[cached] done\n");
    }

    // 3) Single thread executor
    private static void exampleSingleThreadExecutor() throws InterruptedException {
        System.out.println("-- single thread executor example --");
        ExecutorService ex = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 3; i++) {
            final int id = i;
            ex.execute(() -> System.out.println("[single] task " + id + " on " + Thread.currentThread().getName()));
        }

        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("[single] done\n");
    }

    // 4) Scheduled thread pool (scheduling tasks)
    private static void exampleScheduledThreadPool() throws InterruptedException {
        System.out.println("-- scheduled thread pool example --");
        ScheduledExecutorService sched = Executors.newScheduledThreadPool(2);

        // schedule a one-shot
        ScheduledFuture<?> oneShot = sched.schedule(() -> System.out.println("[sched] one-shot executed on " + Thread.currentThread().getName()), 300, TimeUnit.MILLISECONDS);

        // schedule a repeating task
        final ScheduledFuture<?> repeating = sched.scheduleAtFixedRate(() -> System.out.println("[sched] repeating on " + Thread.currentThread().getName()), 100, 250, TimeUnit.MILLISECONDS);

        // wait a bit to observe runs
        Thread.sleep(900);

        // cancel the repeating task and shutdown
        repeating.cancel(false);
        sched.shutdown();
        sched.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println("[sched] oneShot done? " + oneShot.isDone());
        System.out.println("[sched] done\n");
    }

    // 5) Work-stealing pool (note: uses daemon threads; use invokeAll or join to keep JVM alive)
    private static void exampleWorkStealingPool() throws InterruptedException {
        System.out.println("-- work-stealing (ForkJoin) pool example --");
        ExecutorService ex = Executors.newWorkStealingPool(4);

        // Submit a few tasks that sleep so we can observe them stealing work
        List<Callable<String>> callables = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            final int id = i;
            callables.add(() -> {
                Thread.sleep(150 + (id * 50));
                String msg = "[ws] task " + id + " on " + Thread.currentThread().getName();
                System.out.println(msg);
                return msg;
            });
        }

        // invokeAll will block until all complete — demonstrates one way to wait for completion
        try {
            List<Future<String>> results = ex.invokeAll(callables);
            System.out.println("[ws] invokeAll completed with " + results.size() + " results");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Because Executors.newWorkStealingPool creates a ForkJoinPool with daemon threads,
        // we don't strictly need to call shutdown here, but we'll call it for completeness.
        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("[ws] done\n");
    }

    // 6) Custom ThreadPoolExecutor example with bounded queue and rejection policy
    private static void exampleCustomThreadPoolExecutor() throws InterruptedException {
        System.out.println("-- custom ThreadPoolExecutor example --");
        int core = 2, max = 4;
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor ex = new ThreadPoolExecutor(core, max, 500, TimeUnit.MILLISECONDS, queue, new ThreadPoolExecutor.AbortPolicy());

        // Submit more tasks than the queue+max threads to cause rejection if any
        for (int i = 1; i <= 8; i++) {
            final int id = i;
            try {
                ex.execute(() -> {
                    try {
                        System.out.println("[custom] running task " + id + " on " + Thread.currentThread().getName());
                        Thread.sleep(200);
                    } catch (InterruptedException ignored) {
                    }
                });
            } catch (RejectedExecutionException ree) {
                System.out.println("[custom] task " + id + " was rejected");
            }
        }

        ex.shutdown();
        ex.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("[custom] done\n");
    }

    // 7) ForkJoinPool example (RecursiveTask) for divide-and-conquer
    private static void exampleForkJoinPool() {
        System.out.println("-- ForkJoinPool example --");
        ForkJoinPool fjp = new ForkJoinPool(4);
        int[] data = new int[20];
        for (int i = 0; i < data.length; i++) data[i] = i + 1; // 1..20

        SumTask task = new SumTask(data, 0, data.length);
        Integer result = fjp.invoke(task); // blocks until complete
        System.out.println("[fj] sum result = " + result);

        fjp.shutdown();
        System.out.println("[fj] done\n");
    }

    // RecursiveTask to sum an int array
    private static class SumTask extends RecursiveTask<Integer> {
        private static final int THRESHOLD = 5;
        private final int[] arr;
        private final int start;
        private final int end;

        SumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int length = end - start;
            if (length <= THRESHOLD) {
                int s = 0;
                for (int i = start; i < end; i++) s += arr[i];
                System.out.println("[fj] computed sum from " + start + " to " + (end - 1) + " = " + s + " on " + Thread.currentThread().getName());
                return s;
            }
            int mid = start + length / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);
            left.fork();
            int rightResult = right.compute();
            int leftResult = left.join();
            return leftResult + rightResult;
        }
    }
}
