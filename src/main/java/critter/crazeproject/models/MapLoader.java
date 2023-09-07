package critter.crazeproject.models;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MapLoader {
    public Map loadMap(String mapName) {
        URL returnedResource = getClass().getResource("/Maps/" + mapName);
        File file;
        try {
            file = new File(returnedResource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        List<char[]> mapRows = new ArrayList<>();
        try (FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) !=null) {
                mapRows.add(line.toCharArray());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        char[][] tiles = mapRows.toArray(new char[0][0]);
        return new Map(tiles);
    }
}
