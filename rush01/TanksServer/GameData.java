import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class GameData {
    private static final String PLAYER_1_STRING = "player1";
    private static final String PLAYER_2_STRING = "player2";

    private Integer player1X = 10;
    private Integer player1Y = 50;
    private Integer player1HP = 100;
    private Integer player2X = 100;
    private Integer player2Y = 300;
    private Integer player2HP = 100;

    private JSONObject jsonData;

    public void updatePlayerData(String key, int x, int y, int hp) {
        jsonData.put(key, JSONValue.parse("{\"x\": " + x + ", \"y\": " + y + ", \"hp\": " + hp + "}"));
    }

    public void updateBulletData() {

    }

    public void showJsonDbg() {
        System.out.println(jsonData);
    }

    public GameData() {
        jsonData = new JSONObject();
        JSONObject player1 = new JSONObject();
        JSONObject player2 = new JSONObject();
        JSONArray bullets = new JSONArray();
        updatePlayerData(PLAYER_1_STRING, player1X, player1Y, player1HP);
        updatePlayerData(PLAYER_2_STRING, player2X, player2Y, player2HP);
        jsonData.put("bullets", bullets);
//        System.out.println(jsonData);
//        jsonData.put("player", JSONValue.parse("{\"x\": 9, \"y\": 9, \"hp\": 9}"));
//        System.out.println(jsonData);
    }


}
