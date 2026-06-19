import java.util.Random;

public class Specialist extends Thread {
    private final CallCenter callCenter;
    private final Random random = new Random();

    public Specialist(String name, CallCenter callCenter) {
        super(name);
        this.callCenter = callCenter;
    }

    @Override
    public void run() {

        try {
            while (true) {

                String call = callCenter.takeCall();

                if (Constants.POISON_PILL.equals(call)) {
                    System.out.println(getName() + " завершает работу");
                    break;
                }

                System.out.println(getName() + " обрабатывает " + call);

                int workTime = Constants.MIN_PROCESS_TIME_MS +
                        random.nextInt(Constants.MAX_PROCESS_TIME_MS - Constants.MIN_PROCESS_TIME_MS);

                Thread.sleep(workTime);

                System.out.println(getName() + " завершил " + call);
            }

        } catch (InterruptedException e) {
            interrupt();
        }
    }
}
