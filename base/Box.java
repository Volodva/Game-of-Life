package base;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Box extends JPanel {

    private Cell cell;

    public Box(int width, int height) {
        super();
        cell = new Cell();
        setBounds(width * Config.SIZE, height * Config.SIZE, Config.SIZE, Config.SIZE);
        setBackground(Config.getColor(Status.NONE));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cell.turn();
            }
        });
    }

    public Cell getCell() {
        return cell;
    }

    public void setColor() {
        setBackground(Config.getColor(cell.getStatus()));
    }

    public void step1() {
        cell.step1();
        setColor();
    }

    public void step2() {
        cell.step2();
        setColor();
    }
}
