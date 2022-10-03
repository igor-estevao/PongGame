package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
  public double x, y;
  public int width, height;

  // Direction
  public double dx, dy;
  public double speed;


  public Ball(int x, int y){
    this.width = 3;
    this.height = 3;
    this.x = x;
    this.y = y;

    int angle = new Random().nextInt(359);

    this.dx = Math.cos(Math.toRadians(angle));
    this.dy =  Math.sin(Math.toRadians(angle));
    this.speed = 1;
  }


  public void update(){
    // Colision with walls 
    if(x + (dx*speed) + width >= Game.WIDTH ){
      dx *= -1;
    }else if(x + (dx*speed) < 0 ){
      dx *= -1;
    }

    if(y > Game.HEIGHT){
      System.out.println("Ponto Inimigo");
      new Game();
      return;
      // Ponto Inimigo
    }else if(y < 0){
      System.out.println("Ponto Jogador");
      new Game();
      return;
      // Ponto jogador
    }

    // Colision with entitys
    Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)), width, height);

    Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
    Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);

    // Test the intersection, cousing a colision of entity with ball
    if(bounds.intersects(boundsPlayer)){
      int angle = new Random().nextInt(121);
      this.dx = Math.cos(Math.toRadians(angle));
      this.dy =  Math.sin(Math.toRadians(angle));

      if(dy > 0){
        dy *= -1;
      }

    } else if(bounds.intersects(boundsEnemy)) {
      int angle = new Random().nextInt(121);
      this.dx = Math.cos(Math.toRadians(angle));
      this.dy =  Math.sin(Math.toRadians(angle));

      if(dy < 0){
        dy *= -1;
      }
    }

    x += dx*speed;
    y += dy*speed;

  }

  public void render(Graphics g){
    g.setColor(Color.white);
    g.fillOval((int)x, (int)y, width, height);
  }
}
