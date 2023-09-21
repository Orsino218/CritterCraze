package critter.crazeproject.models.battle;

public class Battlefield {
    private Lane laneOne;
    private Lane laneTwo;
    private Lane laneThree;

    public Battlefield() {
        this.laneOne = new Lane();
        this.laneTwo = new Lane();
        this.laneThree = new Lane();
    }

    public Lane getLaneOne() {
        return laneOne;
    }

    public void setLaneOne(Lane laneOne) {
        this.laneOne = laneOne;
    }

    public Lane getLaneTwo() {
        return laneTwo;
    }

    public void setLaneTwo(Lane laneTwo) {
        this.laneTwo = laneTwo;
    }

    public Lane getLaneThree() {
        return laneThree;
    }

    public void setLaneThree(Lane laneThree) {
        this.laneThree = laneThree;
    }
}
