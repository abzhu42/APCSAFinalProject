import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Player extends MovingThing {

  private int speed;
  private Image image;

  public Player(){
    this(10,10,10,10,10);
  }

  public Player(int x, int y){
    super(x, y);
  }

  public Player(int x, int y, int s){
    super(x, y);
    speed = s;
  }

  public Player(int x, int y, int w, int h, int s){
    super(x, y, w, h);
    speed=s;
    try{
      URL url = getClass().getResource("playerLeft.png");
      image = ImageIO.read(url);
    }
    catch(Exception e){
    }
  }

  public void setSpeed(int s){
    speed = s;
  }

  public int getSpeed(){
    return speed;
  }

  public void move(String direction)
  {
    if (direction.equals("LEFT")) {
      setX(getX()-speed); 
      try{
        URL url = getClass().getResource("playerLeft.png");
        image = ImageIO.read(url);
      }
      catch(Exception e){
      }
    }
    else if (direction.equals("RIGHT")) {
      setX(getX()+speed); 
      try{
        URL url = getClass().getResource("playerRight.png");
        image = ImageIO.read(url);
      }
      catch(Exception e){
      }
    }
    else if (direction.equals("UP")) {
      setY(getY()-speed+1); 
    }
    else if (direction.equals("DOWN")) {
      setY(getY()+speed-1); 
    }
  }

  public void draw( Graphics window ){
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString(){
    return super.toString() + getSpeed();
  }

}
