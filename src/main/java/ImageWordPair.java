import java.net.URL;

public class ImageWordPair {
    private URL imageUrl;
    private String word;

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
