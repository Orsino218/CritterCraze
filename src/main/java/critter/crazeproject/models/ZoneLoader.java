package critter.crazeproject.models;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.yaml.snakeyaml.constructor.Constructor;

public class ZoneLoader {
    Yaml npcYaml = new Yaml(new Constructor(NPC.class, new LoaderOptions()));
    public Zone loadZone(String mapName) {
        URL returnedResource = getClass().getResource("/Zones/" + mapName);
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
        return new Zone(tiles);
    }
    public List<NPC> loadNPC(String characterName){
        List<NPC> npcList = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream("/NPC/NPC_Zone1.yaml")) {
            Iterable<Object> result = npcYaml.loadAll(inputStream);
            for (Object npc : result) {
                npcList.add((NPC) npc);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } return npcList;
    }
}