package critter.crazeproject.models;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitLocation that = (UnitLocation) o;
        return xPosition == that.xPosition && yPosition == that.yPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPosition, yPosition);
    }
}
