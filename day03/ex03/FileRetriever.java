package ex03;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;

public class FileRetriever {
    private static LinkedList<String> urls;


    public static void setUrls(LinkedList<String> urls) {
        if (urls != null) {
            FileRetriever.urls = urls;
        }
    }

    public static synchronized String getUrl() {
        return urls.poll();
    }

    public static void retrieveFile(String url, int threadId) {
        try {
            URL file = new URL(url);

            System.out.println(Thread.currentThread().getName() + " start download file number " + threadId);
            InputStream in = file.openStream();
            Files.copy(in, Paths.get(url), StandardCopyOption.REPLACE_EXISTING); // TODO: не работает
            System.out.println(Thread.currentThread().getName() + " finish download file number " + threadId);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
