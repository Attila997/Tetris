package com.attila.logic;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Score {

    private final IntegerProperty score = new SimpleIntegerProperty(0);

    public IntegerProperty getPropertyOfScore(){
        return score;
    }

    public void reset(){
        score.setValue(0);
    }

    public void add(int a){
        score.setValue(score.getValue() + a);
    }
}
