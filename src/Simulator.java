import java.awt.*;

/**
 * Created by Mark on 2016-11-13.
 */
public class Simulator {

    private Robot robot;

    Simulator(){
        try {
            robot = new Robot();
        }catch (AWTException e){
            e.printStackTrace();
        }
    }

    void press(int key){
        robot.keyPress(key);
    }

    void release(int key){
        robot.keyRelease(key);
    }

}
