import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.applet.AudioClip;
public class ScaryMaze extends JComponent implements MouseMotionListener,MouseListener{
    BufferedImage intro;
    BufferedImage level1;
    BufferedImage level2;
    BufferedImage level3;
    BufferedImage level4;
    BufferedImage scare2;
    BufferedImage currentlevel;
    BufferedImage won;
    AudioClip music = JApplet.newAudioClip(getClass().getResource("music.wav"));
    AudioClip scare = JApplet.newAudioClip(getClass().getResource("scare.wav"));
    public ScaryMaze() throws IOException {
        intro = ImageIO.read(getClass().getResource("intro.png"));
        level1 = ImageIO.read(getClass().getResource("level1.png"));
        level2 = ImageIO.read(getClass().getResource("level2.png"));
        level3 = ImageIO.read(getClass().getResource("level3.png"));
        level4 = ImageIO.read(getClass().getResource("level4.png"));
        scare2 = ImageIO.read(getClass().getResource("scare2.jpg"));
        won= ImageIO.read(getClass().getResource("won.png"));
        currentlevel=intro;
    }
    public static void main(String args[]) throws IOException{
        JFrame window=new JFrame("MAZE");
        ScaryMaze game=new ScaryMaze();
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        game.addMouseMotionListener(game);
        game.addMouseListener(game);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fill3DRect(0,0,1368,750,true);
        g.drawImage(currentlevel,0,0,null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1368,1000);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Scanner sc=new Scanner(System.in);
        
       int x= e.getX();
        int y=e.getY();
        int color =currentlevel.getRGB(x,y);
        music.loop();
            if((currentlevel==intro)){
             if(color==-16735512)
             currentlevel=level1;// bugggggg
            }
            else if(currentlevel==level1){
            if(color==-14503604)
            currentlevel=level2;
         else   if(color==-6075996){
               music.stop();
               scare.play();
           currentlevel=scare2;
        }
            }
           else if(currentlevel==level2)
           {
               if(color==-4856291)
               currentlevel=level3;
               else if(color==-32985){
                   music.stop();
                   scare.play();
               currentlevel=scare2;
            }
            
            }
            else if(currentlevel==level3)
           {
               if(color==-4856291)
               currentlevel=level4;
               else if(color==-20791){
                   music.stop();
                   scare.play();
               currentlevel=scare2;
            }
            
            }
           else  if(currentlevel==level4)
           {
               if(color==-4856291)
               currentlevel=won;
               else if(color==-8421505){
                   music.stop();
                   scare.play();
               currentlevel=scare2;
            }
            }
        repaint();
      
        //currentlevel=level2;
      
        //System.out.println(color);//-4856291

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(currentlevel==scare2) {
            currentlevel = intro;
             music.loop();
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
 
    }


