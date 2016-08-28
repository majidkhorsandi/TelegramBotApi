import com.flickr4java.flickr.FlickrException;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by majid on 28/08/16.
 */
public class TestFlickrApi {

    private static final String invalidUserId = "invammliduserid";

    @Test
    public void testGetPhotoLinkWithInvalidUserId() {
        FlickrApi flickrApi = new FlickrApi(invalidUserId);
        try {
            String link = flickrApi.getPhotoLink();
            Assert.assertTrue(link.equals("No photo returned from Flickr"));
        } catch (FlickrException e) {
            e.printStackTrace();
        }
    }
}
