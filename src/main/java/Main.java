import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        List<ImageWordPair> pairs = new ArrayList<>();
        pairs.add(new ImageWordPair(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Google_2015_logo.svg/2000px-Google_2015_logo.svg.png"), "Google"));
        pairs.add(new ImageWordPair(new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/2000px-Facebook_f_logo_%282019%29.svg.png"), "Facebook"));

        SpellingTrainer trainer = new SpellingTrainer(pairs, new JsonPersistMethod("save.json"));
        trainer.start();
    }
}
