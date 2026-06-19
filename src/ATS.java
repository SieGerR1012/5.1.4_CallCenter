public class ATS extends Thread {
    private final CallCenter callCenter;

    public ATS(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    @Override
    public void run() {

        try {
            for (int i = 1; i <= Constants.CALLS_COUNT; i++) {

                String call = "Звонок #" + i;

                System.out.println("АТС: создан " + call);

                callCenter.addCall(call);
                Thread.sleep(Constants.CALL_INTERVAL_MS);
            }

            // сигнал завершения для специалистов
            callCenter.addCall(Constants.POISON_PILL);

        } catch (InterruptedException e) {
            interrupt();
        }
    }
}
