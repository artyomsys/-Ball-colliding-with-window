package collision;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame("Collusion");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Paint pnt = new Paint(40, 40, 40, 5, 5);
        Paint pnt = new Paint();
        pnt.startTread();
        frame.addWindowListener(new ClosingWindowsListener(pnt.trd));

        frame.add(pnt);
        frame.setVisible(true);
        frame.setResizable(true);


        while (true) {
            if (pnt != null) //мне так спокойней
            pnt.run();
        }
    }

}
