package trabs.trab3;

import javax.swing.*;

public class Race {
    public Car car1;
    public Car car2;
    public Car car3;

    private int finnish = 100;

    public Race(){
        car1 = new Sprinter("Sprinter");
        car2 = new Crawler("Crawler");
        car3 = new Robot("Robot");
    }

    public void updateCars(){
        car1.move();
        car2.move();
        car3.move();
        if(car1.getX() >= finnish)
            restart(car1);
        if(car2.getX() >= finnish)
            restart(car2);
        if(car3.getX() >= finnish)
            restart(car3);
    }

    private void restart(Car winner){
        System.out.println(winner.getName() + " Won !!!--------------------------------------");
        car1.reset();
        car2.reset();
        car3.reset();
    }
}