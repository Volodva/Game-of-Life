package base;

import java.awt.*;

public class Config {

    public static final int SIZE = 10;
    public static final int WIDTH = 80;
    public static final int HEIGHT = 60;
    public static final int SLEEP_MS = 500;

    public static Color getColor(Status status) {

        switch (status) {
            default:
            case NONE:
                return Color.black;
            case BORN:
                return Color.gray;
            case LIVE:
                return Color.BLUE;
            case DIED:
                return Color.black;
        }
    }
}
