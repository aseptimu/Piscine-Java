import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Game {
    public Game() {
        GameData gameData = new GameData();
        gameData.showJsonDbg();
    }



//    public start(Server server) {
//
//    }
}


/*

Наш json
{
  "player": {
    "x": 10,
    "y": 50,
    "hp": 100
  },
  "enemy": {
    "x": 100,
    "y": 300,
    "hp": 50
  },
  "bullet": [
    {
      "index": 1,
      "x": 100,
      "y": 100
    },
    {
      "index": 2,
      "x": 100,
      "y": 150
    }
  ]
}

*/