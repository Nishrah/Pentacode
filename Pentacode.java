

import robocode.*;



public class Pentacode extends BravoBot{
	boolean movingForward;
	int turnDirection = 1;
	public void run() {
		
	

		// Loop forever
		while (true) {
			
		ahead(100);
			turnRight(5 * turnDirection);
		
			movingForward=true;	
			
				 	    
			  
		}
			
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		
	if(e.getDistance()<20){
	
		fire(2);
		
	}
		else{
		fire(1);
	} 
		scan();
		
	}
	
	public void onHitWall(HitWallEvent e) {
		// Bounce off!
	//	reverseDirection();
	
	double bearing = e.getBearing(); //get the bearing of the wall
	    turnRight(-bearing-120); //This isn't accurate but release your robot.
	    ahead(100); //The robot goes away from the wall.
	
	
	}
	public void onHitRobot(HitRobotEvent e) {
	
	
	if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}
		turnRight(e.getBearing());
		if (e.getEnergy() > 16) {
			fire(2);
		} else if (e.getEnergy() > 10) {
			fire(1.5);
		} else if (e.getEnergy() > 4) {
			fire(1);
		} else if (e.getEnergy() > 2) {
			fire(.5);
		} else if (e.getEnergy() > .4) {
			fire(.1);
		}
		ahead(40); // Ram him again!
		scan();
	}

	
		public void reverseDirection() {
			if (movingForward) {
				back(100);			
			movingForward = false;
		} else {
			ahead(100);
	
			movingForward = true;
		}
	}   
	
		
public void onBulletHit(BulletHitEvent bhe){
		if(getOthers()<2){

		int enemyDamage=(int) robocode.Rules.getBulletDamage(bhe.getBullet().getPower());
		if(robocode.Rules.getBulletDamage(bhe.getBullet().getPower())>enemyDamage){
			reverseDirection2();
		}
		}
	}
	
		public void reverseDirection2() {
			if (movingForward) {
				back(50);
				turnLeft(120);
				
			movingForward = false;
		} else {
			ahead(50);
			turnRight(120);
			
			movingForward = true;
		}

	}
}
