package ro.ulbs.proiectaresoftware.lab11;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel("Tech Explained");

        MediaInterested media1 = new MediaInterested("CNN");
        MediaInterested media2 = new MediaInterested("FoxNews");

        channel.register(media1);
        channel.register(media2);

        System.out.println("--- Primul Upload (2 observatori) ---");
        String message1 = "Observer Pattern in Java";
        channel.uploadVideo(message1);

        channel.unregister(media2);

        System.out.println("\n--- Al doilea Upload (1 observator) ---");
        String message2 = "Singleton Pattern in Java";
        channel.uploadVideo(message2);
    }
}