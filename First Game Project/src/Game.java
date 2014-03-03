import java.awt.Graphics;

@SuppressWarnings("serial")
public class Game extends gameLoop{

	public void init(){
		System.out.println("Init method");
		setSize(800, 600);
		Thread th = new Thread(this);
		th.start();
		offscreen = createImage(800,600);
		d = offscreen.getGraphics();
		addKeyListener(this);
	}
	
	public void paint(Graphics g){
		System.out.println("paint method");
		d.clearRect(0, 0, 800, 600);
		d.drawImage(background, bgX, -200, this);
		d.drawImage(foreground,  bgX, 400, 2800, 220, this);
		d.drawImage(foreground, platform1x, platform1y, 75, 50, this);
		d.drawString(score2, 15, 15);
		d.drawImage(person1,heroX, heroY, this);
		d.drawImage(person2, lozX, lozY, this);
		d.drawImage(door, doorX, doorY, 50, 75, this);
		g.drawImage(offscreen, 0, 0, this);
		
	}
	public void update(Graphics g){
		System.out.println("update method");
		paint(g);
	}
}