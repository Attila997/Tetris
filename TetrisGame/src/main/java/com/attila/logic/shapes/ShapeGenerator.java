package com.attila.logic.shapes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ShapeGenerator {

    private final List<Shape> shapeList;
    private final Deque<Shape> nextShape = new ArrayDeque<>();

    public ShapeGenerator() {
        shapeList = new ArrayList<>();
        shapeList.add(new ShapeI());
        shapeList.add(new ShapeJ());
        shapeList.add(new ShapeO());
        shapeList.add(new ShapeS());
        shapeList.add(new ShapeT());
        shapeList.add(new ShapeZ());
        nextShape.add(shapeList.get(ThreadLocalRandom.current().nextInt(shapeList.size())));
        nextShape.add(shapeList.get(ThreadLocalRandom.current().nextInt(shapeList.size())));
    }

    /**
     * Get the top shape from the {@code nextShape} deque.
     * @return {@link Shape}
     */
    public Shape getShape(){
        if (nextShape.size() <= 1){
            nextShape.add(shapeList.get(ThreadLocalRandom.current().nextInt(shapeList.size())));
        }
        return nextShape.poll();
    }

    /**
     * Get the next shape.
     * @return {@link Shape}
     */
    public Shape getNextShape(){
        return nextShape.peek();
    }
}
