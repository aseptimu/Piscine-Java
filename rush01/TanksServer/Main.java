public class Main {
    public static void main(String[] args) throws Exception {
        // Game init
        Game game = new Game();

        // Server init which will wait for two clients
         Server server = new Server();
         server.connect();
        // Since two clients connected, we can start the game
        // game.start(server);
    }
}
