package critter.crazeproject.models;

public class UnitLocation {
    private int xPosition;
    private int yPosition;

    public UnitLocation(){}
    public UnitLocation(int x, int y){
        this.xPosition = x;
        this.yPosition = y;
    }


    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
