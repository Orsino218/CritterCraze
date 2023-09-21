package critter.crazeproject;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.BiConsumer;

public class MouseReader implements MouseListener {
    private final BiConsumer<Integer, Integer> consumer;

    public MouseReader (BiConsumer<Integer, Integer> consumer) {
        this.consumer = consumer;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        consumer.accept(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
