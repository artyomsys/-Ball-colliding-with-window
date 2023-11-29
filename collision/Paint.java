package collision;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Paint extends JPanel implements Runnable {
    Random rnd = new Random();
    public  Thread trd;
    private int r = rnd.nextInt(20, 40);
    private int x = rnd.nextInt(599 - r), y = rnd.nextInt(599 - r);
    private int kx = rnd.nextInt(30), ky = rnd.nextInt(30);

    private int delay = 9 * (kx + ky) / 8;  // Я понимаю, что таким образом "визуальная" скорость будет +/- одинаковой, но с такой задержкой картинка почти не мерцает

    private Color clr = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));

    public Paint() {
        setDoubleBuffered(true);
    }

    public Paint(int r, int x, int y, int kx, int ky) {
        setDoubleBuffered(true);
        this.r = r;
        this.x = x;
        this.y = y;
        this.kx = kx;
        this.ky = ky;
        this.delay = 9 * (this.kx + this.ky) / 8;
    }

    public void startTread(){ // зачем?

        trd = new Thread(this);
        trd.start();

    }

    public void paint(Graphics g){
        super.paint(g);

        g.setColor(clr);
        g.fillOval(x, y, r,r);


    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            if (x + kx + r >= getWidth() || x + kx <= 0) {
                kx *= -1;
            }
            if (y + ky + r >= getHeight() || y + ky <= 0) {
                ky *= -1;
            }

            x += kx;
            y += ky;
            this.repaint();

            try {
                trd.sleep(delay);
            } catch (InterruptedException e) {
                running = false;
                throw new RuntimeException(e);
            }

        }
    }
}
