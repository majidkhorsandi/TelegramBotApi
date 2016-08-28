import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by majid on 27/08/16.
 */
public class FlickrApi {

    private static String userID;
    private static final String PHOTO_URL = "https://farm{0}.staticflickr.com/{1}/{2}_{3}.{4}";
    private Flickr flickr;

    public FlickrApi(String userID)  {
        this.userID = userID;
        String apiKey = "1c0ed08683964b16689c412a2eebd00b";
        String sharedSecret = "f8393783f3067a3b";
        flickr = new Flickr(apiKey, sharedSecret, new REST());
    }

    public String getPhotoLink () throws FlickrException {
        List<Photo> photos = flickr.getPeopleInterface().getPhotos(userID,null,null,null,null,null,null,null,null,1,1);
        if (photos.size() > 0) {
            Photo photo = photos.get(0);
            return MessageFormat.format(PHOTO_URL, photo.getFarm(), photo.getServer(), photo.getId(), photo.getSecret(), photo.getOriginalFormat());
        } else {
            return "No photo returned from Flickr";
        }
    }
}

