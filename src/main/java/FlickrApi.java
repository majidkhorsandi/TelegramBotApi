import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.test.TestInterface;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by majid on 27/08/16.
 */
public class FlickrApi {

    private static final String USER_ID = "146540219@N08";
    private static final String PHOTO_URL = "https://farm{0}.staticflickr.com/{1}/{2}_{3}.{4}";

    private Flickr flickr;
    public FlickrApi()  {
        String apiKey = "1c0ed08683964b16689c412a2eebd00b";
        String sharedSecret = "f8393783f3067a3b";
        flickr = new Flickr(apiKey, sharedSecret, new REST());
    }

    public String getPhotoLink () throws FlickrException {
        List<Photo> photos = flickr.getPeopleInterface().getPhotos(USER_ID,null,null,null,null,null,null,null,null,1,1);
        Photo photo = photos.get(0);
        return MessageFormat.format(PHOTO_URL, photo.getFarm(), photo.getServer(), photo.getId(), photo.getSecret(), photo.getOriginalFormat());
    }
}

