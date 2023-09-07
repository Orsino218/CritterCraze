package critter.crazeproject.models;

public enum DialogueLines {
    TROLL_GREETING("I'm hungry, and you are a scrumptious critter!"),
    TROLL_BATTLE("RAWR! I am going to eat you!"),
    TROLL_VICTORY("BUUUURP! My tummy is full!"),
    TROLL_DEFEAT("OH NO!!!! You have defeated me! This won't be the last time you see me, critter!"),
    TROLL_FINAL_WORDS("GRRRR! I'll get you next time!"),
    ;
    private final String script;
    DialogueLines(String characterDialogue) {
        this.script = characterDialogue;
  }
}
