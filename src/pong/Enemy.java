package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {

  public double x, y;
  public int width, height;

  public Enemy(int x, int y){
    this.width = 40;
    this.height = 10;
    this.x = x;
    this.y = y;
  }


  public void update(){
    x += (Game.ball.x - x - 2) * 0.3;    
  }

  public void render(Graphics g){
    g.setColor(Color.RED);
    g.fillRect((int)x, (int)y, width, height);
  }

}
