package critter.crazeproject.managers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ImageManager {
    public static final ImageManager manager = new ImageManager();

    private final Map<String, Image> images;


    private ImageManager() {
        this.images = new HashMap<>();
    }

    public Image getAnImage(String imageName) throws IOException {
        Image pic = images.get(imageName);
        if (pic != null) {
            return pic;
        }
        try {
            URL picURL = getClass().getResource("/Images/" + imageName);
            Image newPic = ImageIO.read(picURL);
            images.put(imageName, newPic);
            return newPic;
        }
        catch(IOException e) {
            throw new IOException("Unable to load image");
        }
    }


}
