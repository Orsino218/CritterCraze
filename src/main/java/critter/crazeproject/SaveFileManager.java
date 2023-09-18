package critter.crazeproject;

import com.google.gson.Gson;
import critter.crazeproject.models.GameState;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveFileManager {
    private static final SaveFileManager manager = new SaveFileManager();
    private Gson gson;
    private String SAVE_DIRECTORY = "saves/";

    public SaveFileManager() {
        this.gson = new Gson();

        File file = new File(SAVE_DIRECTORY);
        file.mkdir();
    }

    public void saveGame() {
        GameState state = Game.getGame().getGameState();
        String serializedGameState = gson.toJson(state);

        try (FileWriter writer = new FileWriter(state.getFileName());
                BufferedWriter bWriter = new BufferedWriter(writer)) {
            bWriter.write(serializedGameState);
        }
        catch (Exception e) {
            //Add exception handling here
            return;
        }
    }

    public List<String> getSaves() {
        File[] files = new File(SAVE_DIRECTORY).listFiles();
        List<String> list = new ArrayList<>();

        if (files != null) {
            for (File item : files){
                list.add(item.getName());
            }
        }

        return list;
    }

    public GameState loadGame(String fileName) {
        try (FileReader reader = new FileReader(fileName);
             BufferedReader bReader = new BufferedReader(reader)) {
            String serialized = bReader.readLine();
            return gson.fromJson(serialized, GameState.class);
        }
        catch(Exception e) {
            //Add exception handling
            return null;
        }
    }




}