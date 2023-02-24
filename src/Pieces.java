public abstract class Pieces {
    private int locationX;
    private int locationY;
    private String name;
    private String color;

    public Pieces(String name, String color, int LocationX, int LocationY) {
        this.name = name;
        this.color = color;
        this.locationX = locationY;
        this.locationY = locationY;
    }

    abstract void move();

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
