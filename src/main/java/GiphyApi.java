import at.mukprojects.giphy4j.entity.search.SearchFeed;
import at.mukprojects.giphy4j.exception.GiphyException;

import java.util.Random;

/**
 * Created by majid on 22/08/16.
 */
public class GiphyApi {

    public String getGiphy(String subject) {
        at.mukprojects.giphy4j.Giphy giphy = new at.mukprojects.giphy4j.Giphy("dc6zaTOxFJmzC");
        SearchFeed feed = null;
        try {
            feed = giphy.search(subject, 20, 0);
        } catch (GiphyException e) {
            e.printStackTrace();
        }
        int numberOfGiphyPicturesReturned = feed.getDataList().size();
        Random r = new Random();
        int RandomGiphyNumber = r.nextInt(numberOfGiphyPicturesReturned + 1);
        return feed.getDataList().get(RandomGiphyNumber).getImages().getOriginal().getUrl();

    }
}
