import com.flickr4java.flickr.FlickrException;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Start {

    private static final String BOT_PATH = "https://api.telegram.org/bot250024402:AAErvbeFLpIEC-Oe-yjCneU7SgPu7RdTwDM/sendMessage";
    public static void main(String[] args) {

        FlickrApi flickrApi = new FlickrApi();


        Bot bot = new Bot("250024402:AAErvbeFLpIEC-Oe-yjCneU7SgPu7RdTwDM");
        try {
            bot.run();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
