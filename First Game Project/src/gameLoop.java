import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


@SuppressWarnings("serial")
public class gameLoop extends Applet implements Runnable, KeyListener{


	public int heroX, heroY;
	public int lozX, lozY;
	public int bgX, bgY, platform1x, platform1y, doorX, doorY, one;
	public Image offscreen;
	public Graphics d;
	public boolean jump, down, left, right;
	public BufferedImage[] TayWalkRight = new BufferedImage[12];
	public BufferedImage[] TayWalkLeft = new BufferedImage[12];
	public BufferedImage[] LozWalkRight = new BufferedImage[12];
	public BufferedImage[] LozWalkLeft = new BufferedImage[12];

	public BufferedImage background, foreground, standRight, standLeft, person1, person2, door, lozStandRight;
	public int counter = 0;
	public int delayCounter = 0;
	public int gravity = 10;
	public int time = 0;
	public double counter2 = 4;
	public int score = 0;
	public String score2 = "";
	public void loadImages() {
	
	try {
		background = ImageIO.read(new File("backgroundImage.png"));
		foreground = ImageIO.read(new File("Grass.png"));
		standRight = ImageIO.read(new File("TayRight0.png"));
		standLeft =  ImageIO.read(new File("TayLeft0.png"));
		lozStandRight= ImageIO.read(new File("LozRight0.png"));
		door = ImageIO.read(new File("door.png"));
		
//Walk right animation array
		TayWalkRight[1] =  ImageIO.read(new File("TayRight1.png"));
		TayWalkRight[2] =  ImageIO.read(new File("TayRight2.png"));
		TayWalkRight[3] =  ImageIO.read(new File("TayRight3.png"));
		TayWalkRight[4] =  ImageIO.read(new File("TayRight4.png"));
		TayWalkRight[5] =  ImageIO.read(new File("TayRight5.png"));
		TayWalkRight[6] =  ImageIO.read(new File("TayRight6.png"));
	
	
//Walk left Animation array
		TayWalkLeft[1] =  ImageIO.read(new File("TayLeft1.png"));
		TayWalkLeft[2] =  ImageIO.read(new File("TayLeft2.png"));
		TayWalkLeft[3] =  ImageIO.read(new File("TayLeft3.png"));
		TayWalkLeft[4] =  ImageIO.read(new File("TayLeft4.png"));
		TayWalkLeft[5] =  ImageIO.read(new File("TayLeft5.png"));
		TayWalkLeft[6] =  ImageIO.read(new File("TayLeft6.png"));
		
		
		
		//Laurens Character
		//Walk right animation array
				LozWalkRight[1] =  ImageIO.read(new File("TayRight1.png"));
				LozWalkRight[2] =  ImageIO.read(new File("TayRight2.png"));
				LozWalkRight[3] =  ImageIO.read(new File("TayRight3.png"));
				LozWalkRight[4] =  ImageIO.read(new File("TayRight4.png"));
				LozWalkRight[5] =  ImageIO.read(new File("TayRight5.png"));
				LozWalkRight[6] =  ImageIO.read(new File("TayRight6.png"));
				
			
		//Walk left Animation array
				LozWalkLeft[1] =  ImageIO.read(new File("TayLeft1.png"));
				LozWalkLeft[2] =  ImageIO.read(new File("TayLeft2.png"));
				LozWalkLeft[3] =  ImageIO.read(new File("TayLeft3.png"));
				LozWalkLeft[4] =  ImageIO.read(new File("TayLeft4.png"));
				LozWalkLeft[5] =  ImageIO.read(new File("TayLeft5.png"));
				LozWalkLeft[6] =  ImageIO.read(new File("TayLeft6.png"));
				
				person1 = standRight;
				person2 = lozStandRight;
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	}
	public void run(){
		System.out.println("Run method");
		heroX = 100;
		heroY = 490;
		lozX = 50;
		lozY = 490;
		bgX = 0;
		bgY = -200;
		platform1x = 250;
		platform1y = 450;
		doorX = 5000;
		doorY = 490;
		System.out.println(doorX);
		loadImages();
		
		while(true){
			score2 = String.valueOf(score);
			if (heroX == doorX && heroY == doorY){
				score++;
				heroX = 100;
				heroY = 490;
				bgX = 0;
				bgY = -200;
				platform1x = 250;
				platform1y = 450;
				doorX = 5000;
				doorY = 490;
			}
			
			counter++;
			 
			/*
			 * Platform1y = 406
			 * platform1x = 236-300
			 */
			if(heroX >= 236 && heroX <= 300 && heroY >= 404 && heroY < 410){
				gravity = 0;
			}
			
			else if(heroY <= 490 && jump == false){
				gravity = 10;
				heroY+=gravity;
			}
			
				System.out.println(time);
			time++;
			if(bgX <= -966){
				doorX = 720;
			}
			
//Walk left animation
			if(left == true && bgX >= 0 && heroX >= 0){
				heroX-=4;
				if(jump == false){
					switch(counter){
					case 0:  person1 = standLeft;
					case 5:  person1 = TayWalkLeft[1]; break;
					case 10:  person1 = TayWalkLeft[2]; break;
					case 15:  person1 = TayWalkLeft[3]; break;
					case 20:  person1 = TayWalkLeft[4]; break;
					case 25:  person1 = TayWalkLeft[5]; break;
					case 30:  person1 = TayWalkLeft[6];
								counter = 0;
								break;}
					if(delayCounter >=2){
						lozX-=4;}
				}
			}
			
			if(left == true && heroX >=400 && heroX <=410 && bgX <= 0){
				bgX+=4;
				platform1x += 4;
				if(jump == false){
					switch(counter){
					case 0:  person1 = standLeft;
					case 5:  person1 = TayWalkLeft[1]; break;
					case 10:  person1 = TayWalkLeft[2]; break;
					case 15:  person1 = TayWalkLeft[3]; break;
					case 20:  person1 = TayWalkLeft[4]; break;
					case 25:  person1 = TayWalkLeft[5]; break;
					case 30:  person1 = TayWalkLeft[6]; 
								counter = 0;break;
					}
				}
			}
			
			if(left == true && heroX >=410){
				heroX-=4;
				platform1x += 4;
				if(jump == false){
					switch(counter){
					case 0:  person1 = standLeft;
					case 5:  person1 = TayWalkLeft[1]; break;
					case 10:  person1 = TayWalkLeft[2]; break;
					case 15:  person1 = TayWalkLeft[3]; break;
					case 20:  person1 = TayWalkLeft[4]; break;
					case 25:  person1 = TayWalkLeft[5]; break;
					case 30:  person1 = TayWalkLeft[6];
								counter = 0;
								break;}
								if(delayCounter >=2){
									lozX-=4;}
					
				}
			}
				
//Walk right animation
			if(right == true && heroX <= 400){
				heroX+=4;
				
				if(jump == false){
					switch(counter){
					case 0:  person1 = standRight;
					case 5:  person1 = TayWalkRight[1]; break;
					case 10:  person1 = TayWalkRight[2]; break;
					case 15:  person1 = TayWalkRight[3]; break;
					case 20:  person1 = TayWalkRight[4]; break;
					case 25:  person1 = TayWalkRight[5]; break;
					case 30:  person1 = TayWalkRight[6];			
								counter = 0; 
								break;}
					if(lozX <= (heroX - 100)){
						lozX+=4;
						}
				}
			}
			
			if(right == true && heroX >= 400 && bgX >= -966){
				bgX-=4;
				platform1x -= 4;
				if(jump == false){
					switch(counter){
					case 0:  person1 = standRight;
					case 5:  person1 = TayWalkRight[1]; break;
					case 10:  person1 = TayWalkRight[2]; break;
					case 15:  person1 = TayWalkRight[3]; break;
					case 20:  person1 = TayWalkRight[4]; break;
					case 25:  person1 = TayWalkRight[5]; break;
					case 30:  person1 = TayWalkRight[6]; 
								counter = 0;break;		
					}
				}
			}
			
			if(right == true && heroX <= 756 && bgX <= -966){
				bgX = -966;
				heroX+=4;
				
				if(jump == false){
					switch(counter){
					case 0:  person1 = standRight;
					case 5:  person1 = TayWalkRight[1]; break;
					case 10:  person1 = TayWalkRight[2]; break;
					case 15:  person1 = TayWalkRight[3]; break;
					case 20:  person1 = TayWalkRight[4]; break;
					case 25:  person1 = TayWalkRight[5]; break;
					case 30:  person1 = TayWalkRight[6];
					counter = 0; 
					break;}
					if(lozX <= (heroX - 100)){
						lozX+=4;
						}
					
				}
			}
			
			if(jump == true){
				
				counter2 += 0.1;
				heroY = heroY + (int)((Math.sin(counter2)+ Math.cos(counter2)) * 10);
				if(counter2 >= 6.8){
					counter2 = 4;
				}
			}
			if(down == true){
				heroY+=2;
			}
			if(heroY>= 490){
				heroY = 490;
			}
			
		
		repaint();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Error!!!");
		}
	}
		
}

//Key Pressed Events
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 37){
			left = true;
		}
		if(e.getKeyCode() == 38){
			jump = true;
			if(right == true){
				person1 = TayWalkRight[3];
				if(left == true){
					person1 = TayWalkLeft[3];
				}		
			}
		}
	
		if(e.getKeyCode() == 39){
			right = true;
		}
		if(e.getKeyCode() == 40 && heroY <= 550){
			down = true;
			System.out.println("Hero " + heroX + " - " + heroY);
			System.out.println("Background " + bgX + " - " + bgY);
		}
	}

//Key Released Events
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 37){
			left = false;
			person1 = standLeft;
			counter = 0;
		}
		if(e.getKeyCode() == 38){
			jump = false;
			counter2 = 4;

		}
		if(e.getKeyCode() == 39){
			right = false;
			person1 = standRight;
			

		}
		if(e.getKeyCode() == 40){
			down = false;

		}
	}


	public void keyTyped(KeyEvent e) {}
}

