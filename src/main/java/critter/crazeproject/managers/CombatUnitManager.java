package critter.crazeproject.managers;

import critter.crazeproject.models.battle.CombatUnit;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CombatUnitManager {
    public static final CombatUnitManager manager = new CombatUnitManager();
    private final Map<String, CombatUnit> units;

    private CombatUnitManager() {
        this.units = new HashMap<>();
        try(InputStream inputStream = getClass().getResourceAsStream("/Combat/Units");
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader bReader = new BufferedReader(inputReader)){

            String line;
            while ( (line = bReader.readLine()) != null   ) {
                String[] csvLine = line.split(",");

                CombatUnit newUnit = new CombatUnit(
                        csvLine[0],
                        Integer.parseInt(csvLine[1]),
                        Integer.parseInt(csvLine[2]),
                        Integer.parseInt(csvLine[3]),
                        Double.parseDouble(csvLine[4]),
                        csvLine[5]);

                units.put(csvLine[0], newUnit);
            }
        }
        catch(Exception e){}
    }

    public CombatUnit getUnitByName(String unitName) {
        return units.get(unitName);
    }
}
