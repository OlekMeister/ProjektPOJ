package ProjektPOJ;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class GameScene extends Scene {
    Rect background, foreground;
    Snake snake;
    KL keyListener;

    public Food food;
    private double dt;

    public GameScene(KL keyListener){
        background = new Rect(0,0,Constans.SCREEN_WIDTH,Constans.SCREEN_HEIGHT);
        foreground = new Rect(24,48,Constans.TITLE_WIDTH*31,Constans.TITLE_WIDTH*22);//wymiar obramowania
        snake = new Snake(3,48,48+24,24,24,foreground);
        this.keyListener = keyListener;
        food = new Food(foreground,snake,12,12,Color.GREEN);
        food.spawn();
    }

    @Override
    public void update(double dt) {
        this.dt = dt;
        if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
            snake.changeDirection(Direction.UP);
        } else if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
            snake.changeDirection((Direction.DOWN));
        } else if (keyListener.isKeyPressed(KeyEvent.VK_RIGHT)) {
            snake.changeDirection((Direction.RIGHT));
        } else if (keyListener.isKeyPressed(KeyEvent.VK_LEFT)) {
            snake.changeDirection((Direction.LEFT));//Poruszanie się, zmiany kierunku
        }

        if(!food.isSpawned) food.spawn();


        food.update(dt);
        snake.update(dt);
    }

    @Override

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle2D.Double(background.x,background.y,background.width,background.height));

        g2.setColor(Color.WHITE);
        g2.fill(new Rectangle2D.Double(foreground.x,foreground.y,foreground.width,foreground.height));//Rysowanie tła

        snake.draw(g2);
        food.draw(g2);
    }
}
