package thread.creration.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getPriority());
            throw new RuntimeException();
        });

        thread.setName("New thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Error " + t.getName() + " " + e.getMessage());
        });
        System.out.println(Thread.currentThread().getName());
        thread.start();
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}
