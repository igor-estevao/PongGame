package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

  public boolean right, left;

  public int x, y, width, height;

  public Player(int x, int y){
    this.width = 40;
    this.height = 10;
    this.x = x;
    this.y = y;
  }

  public void update(){
    if(right){
      x++;
    }
    else if(left) {
      x--;
    }

    if(x + width > Game.WIDTH){
      x = Game.WIDTH - width;
    } else if(x<0){
      x=0;
    }

  }
  
  public void render(Graphics g){
    g.setColor(Color.BLUE);
    g.fillRect(x, y, width, height);
  }

}
