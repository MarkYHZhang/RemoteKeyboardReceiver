import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mark on 2016-11-13.
 */
public class Window extends WindowAdapter{

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Closed");
        try {
            new PrintWriter(RKReceiver.socket.getOutputStream()).println("END");
            RKReceiver.socket.close();
        }catch (IOException ee){
            ee.printStackTrace();
        }
        e.getWindow().dispose();
        System.exit(0);
    }

}
