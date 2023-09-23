package critter.crazeproject.managers;

import critter.crazeproject.models.NPC;
import critter.crazeproject.models.Zone;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.constructor.Constructor;

public class ZoneManager {
    public static final ZoneManager manager = new ZoneManager();
    private ZoneManager(){};
    Yaml yaml = new Yaml(new Constructor(NPC.class, new LoaderOptions()));
    public Zone loadZone(String zoneName) {
        try(InputStream mapStream = getClass().getResourceAsStream("/Zones/" + zoneName);
            InputStreamReader reader = new InputStreamReader(mapStream);
            BufferedReader bReader = new BufferedReader(reader))
        {
            List<char[]> zoneLayout = new ArrayList<>();
            String line;
            while((line = bReader.readLine()) != null ) {
                zoneLayout.add(line.toCharArray());
            }
            return new Zone(zoneLayout.toArray(new char[0][]), loadZoneNPCs(zoneName));
        }
        catch(Exception e){
            throw new RuntimeException("Unable to load zone", e);
        }
    }
    public List<NPC> loadZoneNPCs(String zoneName){
        List<NPC> npcList = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream("/NPC/" + zoneName + ".yaml")) {
            Iterable<Object> result = yaml.loadAll(inputStream);
            for (Object npc : result) {
                npcList.add((NPC) npc);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } return npcList;
    }
}