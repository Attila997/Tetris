package com.attila.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BoardGeneratorTest {
    private BoardGenerator boardGenerator;



    @Before
    public void setUp() throws Exception {
        boardGenerator = new BoardGenerator(24,10);
    }

    @After
    public void tearDown() throws Exception {
        boardGenerator = null;
    }

    @Test
    public void createNewShapeTest() {
        assertFalse(boardGenerator.createNewShape());
    }


}