import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CallCenter {
    private final BlockingQueue<String> queue =
            new LinkedBlockingQueue<>();

    public void addCall(String call) throws InterruptedException {
        queue.put(call);
    }

    public String takeCall() throws InterruptedException {
        return queue.take();
    }
}
