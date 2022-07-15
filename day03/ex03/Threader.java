package ex03;

public class Threader implements Runnable {
    private final int threadId;

    public Threader(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        String url;

        while  ((url = FileRetriever.getUrl()) != null) {
            FileRetriever.retrieveFile(url, threadId);
        }
    }
}
