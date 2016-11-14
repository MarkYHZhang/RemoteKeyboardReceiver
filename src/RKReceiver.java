import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Mark on 2016-11-13.
 */
public class RKReceiver {

    static Socket socket;
    static BufferedReader br;

    public static void main(String[] args) {
        JFrame frame = new JFrame("RemoteKeyboard");
        frame.addWindowListener(new Window());
        JLabel msg = new JLabel("To exit RemoteKeyboard close this window", SwingConstants.CENTER);
        frame.setSize(300,100);
        frame.add(msg);
        frame.setVisible(true);
        Simulator simulator = new Simulator();
        try{
            String ip = JOptionPane.showInputDialog("IP: ");
            int port = Integer.parseInt(JOptionPane.showInputDialog("Port: "));
            socket = new Socket(ip, port);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String[] str = br.readLine().split(",");
                System.out.println(Arrays.toString(str));
                if (str[0].equalsIgnoreCase("P")) {
                    simulator.press(Integer.parseInt(str[1]));
                } else {
                    simulator.release(Integer.parseInt(str[1]));
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR!");
            System.exit(1);
        }
    }
}
