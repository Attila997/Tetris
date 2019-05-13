package com.attila.logic;

import com.attila.logic.shapes.ShapeGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardGeneratorTest {
    private BoardGenerator boardGenerator;
    private ShapeGenerator shapeGenerator;

    @Before
    public void setUp() throws Exception {
        boardGenerator = new BoardGenerator(24,10);
        shapeGenerator = new ShapeGenerator();
    }

    @After
    public void tearDown() throws Exception {
        boardGenerator = null;
        shapeGenerator = null;
    }

    @Test
    public void createNewShape() {
        assertEquals(false, boardGenerator.createNewShape());
    }

    @Test
    public void moveShapeLeft() {
    }

    @Test
    public void moveShapeRight() {
    }

    @Test
    public void moveShapeDown() {
    }

    @Test
    public void rotateShapeLeft() {
    }

    @Test
    public void getShapeData() {
    }

    @Test
    public void getGameBoard() {
    }

    @Test
    public void getScore() {
    }
}