import com.flickr4java.flickr.FlickrException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by majid on 25/08/16.
 */
public final class Bot {
    private final String endpoint = "https://api.telegram.org/bot";
    private final String token;

    public Bot(String token) {
        this.token = token;
    }

    public HttpResponse<JsonNode> sendMessage(Integer chatId, String text) throws UnirestException {
        return Unirest.post(endpoint + token + "/sendMessage")
                .field("chat_id", chatId)
                .field("text", text)
                .asJson();
    }

    public HttpResponse<JsonNode> sendPhoto(Integer chatId, String text) throws UnirestException {
        return Unirest.post(endpoint + token + "/sendPhoto")
                .field("chat_id", chatId)
                .field("photo", text)
                .field("caption", "Another cool abdaly pic")
                .asJson();
    }

    public HttpResponse<JsonNode> getUpdates(Integer offset) throws UnirestException {
        HttpResponse<String> response = Unirest.post(endpoint + token + "/getUpdates")
                .field("offset", offset).asString();
        return Unirest.post(endpoint + token + "/getUpdates")
                .field("offset", offset)
                .asJson();
    }

    public void run() throws UnirestException {
            int last_update_id = 802127658; // last processed command

            HttpResponse<JsonNode> response;
            while (true) {
                response = getUpdates(last_update_id++);

                if (response.getStatus() == 200) {
                    JSONArray responses = response.getBody().getObject().getJSONArray("result");
                    if (responses.isNull(0)) continue;
                    else last_update_id = responses
                            .getJSONObject(responses.length() - 1)
                            .getInt("update_id") + 1;

                    for (int i = 0; i < responses.length(); i++) {
                        JSONObject message = responses
                                .getJSONObject(i)
                                .getJSONObject("message");

                        int chat_id = message
                                .getJSONObject("chat")
                                .getInt("id");



                        String text = message
                                .getString("text");

                        if (text.contains("/start")) {
                            String reply = "Hi, this is an example bot\n" +
                                    "Your chat_id is " + chat_id + "\n" +
                                    "Your title is ";
                            sendMessage(chat_id, reply);
                        } else if (text.contains("/echo")) {
                            sendMessage(chat_id, "Received " + text);
                        } else if (text.contains("/toupper")) {
                            String param = text.substring("/toupper".length(), text.length());
                            sendMessage(chat_id, param.toUpperCase());
                        } else if (text.contains("/giphy")) {
                            GiphyApi giphy = new GiphyApi();
                            String giphyImagePath = giphy.getGiphy(text);
                            sendMessage(chat_id, giphyImagePath);
                        } else if (text.contains("/picture")) {
                            FlickrApi flickrApi = new FlickrApi();
                            try {
                                sendPhoto(chat_id, flickrApi.getPhotoLink());
                            } catch (FlickrException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
}