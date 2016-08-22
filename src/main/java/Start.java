import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchFeed;
import at.mukprojects.giphy4j.exception.GiphyException;

public class Start {

    public static void main(String[] args) {
        Updates updates = new Updates();
       // System.out.println(updates.getUpdates());
        Giphy giphy = new Giphy("dc6zaTOxFJmzC");
        SearchFeed feed = null;
        try {
            feed = giphy.search("cat", 1, 0);
        } catch (GiphyException e) {
            e.printStackTrace();
        }
        System.out.println(feed.getDataList().get(0).getImages().getOriginal().getUrl());
    }
}
