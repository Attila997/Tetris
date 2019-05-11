package com.attila.logic.shapes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ShapeGenerator {

    /**
     * a formák listája
     */
    private final List<Shape> shapeList;

    /**
     * Több a következő formáknak
     */
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
     * Kiveszi a nextShape tömbből a legfelső elemet majd törli
     * @return
     */
    public Shape getShape(){
        if (nextShape.size() <= 1){
            nextShape.add(shapeList.get(ThreadLocalRandom.current().nextInt(shapeList.size())));
        }
        return nextShape.poll();
    }

    /**
     *
     * @return vissza adja a következő formát
     */
    public Shape getNextShape(){
        return nextShape.peek();
    }
}
