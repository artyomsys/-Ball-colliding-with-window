package collision;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClosingWindowsListener extends WindowAdapter {
    private Thread trd;

    public ClosingWindowsListener(Thread trd) {
        this.trd = trd;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        trd.interrupt();
        JFrame frm = (JFrame) e.getWindow();
        frm.dispose();
    }
}
