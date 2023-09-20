import java.net.URL;

/**
 * Represents an image-word pair
 *
 * @author Manuel Glenk
 * @version 2023-09-20
 */
public class ImageWordPair {
    private URL imageUrl; // The URL of the image
    private String word; // The word

    /**
     * Creates a new ImageWordPair
     *
     * @param imageUrl The URL of the image
     * @param word The word
     */
    public ImageWordPair(URL imageUrl, String word) {
        this.imageUrl = imageUrl;
        this.word = word;
    }

    public URL getImageUrl() {
        return imageUrl;
    }

    public String getWord() {
        return word;
    }
}
