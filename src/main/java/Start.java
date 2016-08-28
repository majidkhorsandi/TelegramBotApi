import com.flickr4java.flickr.FlickrException;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Start {

    private static final String BOT_PATH = "https://api.telegram.org/bot250024402:AAErvbeFLpIEC-Oe-yjCneU7SgPu7RdTwDM/sendMessage";
    private static final String FLICKR_USER_ID = "146540219@N08";
    public static void main(String[] args) {

        FlickrApi flickrApi = new FlickrApi(FLICKR_USER_ID);

        Bot bot = new Bot("250024402:AAErvbeFLpIEC-Oe-yjCneU7SgPu7RdTwDM");
        try {
            bot.run();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
