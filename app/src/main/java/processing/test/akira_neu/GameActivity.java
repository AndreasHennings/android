package processing.test.akira_neu;

import java.util.ArrayList;

import objects.Obj;
import processing.core.*;


public class GameActivity extends PApplet
{

    GameEngine gameEngine;
    boolean gameRunning;

    PShape level;
    PImage image;

    String filenameLevel = "testlevel.svg";
    String filenameImage ="testbild.jpg";

    //view parameters

    float scaleFactor;  //scale of view
    float viewX;
    float viewY;

    public void setup()
    {

        image=loadImage(filenameImage);
        level=loadShape(filenameLevel);

        gameEngine = new GameEngine();
        gameRunning = true;


        scaleFactor=(float)0.5;
        viewX=0;
        viewY=0;
    }

    public void draw()
    {
        gameEngine.run();
    }


    public class GameEngine
    {
        ArrayList<Obj>allObjs;      //  a list containing all objects in a level
        ArrayList<Obj>visibleObjs;  //  visible objects for collision testing
        ArrayList<Obj>dynamicObjs;  //  dynamic objects for position updating

        public GameEngine()
        {

        }

        public void run()
        {
            display();
        }


        public void display()
        {
            image(image,0,0);
            scale(scaleFactor);
            shape(level, viewX, viewY);
        }

    }


}