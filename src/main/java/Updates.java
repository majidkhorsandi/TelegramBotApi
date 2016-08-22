/**
 * Created by majid on 21/08/16.
 */
public class Updates {

    private static final String BOT_PATH = "https://api.telegram.org/bot250024402:AAErvbeFLpIEC-Oe-yjCneU7SgPu7RdTwDM";
    public String getUpdates() {
        return NetClient.get(BOT_PATH + "/getUpdates");
    }
}
