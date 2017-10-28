

import robocode.*;


public class Pentacode extends AlphaBot{
	boolean movingForward;
	int turnDirection = 1;
	public void run() {
		
	

		// Loop forever
		while (true) {
			
			ahead(200);
			
			movingForward = true;
	
			if(getOthers()<04){
			turnGunRight(360);
			}
				
			//wait(new TurnCompleteCondition(this));
			//turnRight(90);
			//wait(new TurnCompleteCondition(this));
			//turnLeft(180);
			//wait(new TurnCompleteCondition(this));
			//turnRight(180);
			
		
}
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
	
	if(e.getDistance()<100){
		fire(3);
	}
		else{
		fire(1);
	} 
		
	}
	
	public void onHitWall(HitWallEvent e) {
		// Bounce off!
	//	reverseDirection();
	
	double bearing = e.getBearing(); //get the bearing of the wall
	    turnRight(-bearing-120); //This isn't accurate but release your robot.
	    ahead(100); //The robot goes away from the wall.
	
	
	}
	public void onHitRobot(HitRobotEvent e) {
		// If we're moving the other robot, reverse!
		
		if (e.isMyFault()==true) {
			//reverseDirection();
			if(getOthers()>3){
			ahead(10);
		
			}
			else{ 
				reverseDirection();
			}
			
		}
	}
		public void reverseDirection() {
			if (movingForward) {
				back(100);
				turnLeft(180);
				
			movingForward = false;
		} else {
			ahead(100);
			turnRight(180);
			
			movingForward = true;
		}
	}   
	
		
public void onBulletHit(BulletHitEvent bhe){
		if(getOthers()<4){

		int enemyDamage=(int) robocode.Rules.getBulletDamage(bhe.getBullet().getPower());
		if(robocode.Rules.getBulletDamage(bhe.getBullet().getPower())>enemyDamage){
			reverseDirection();
		}
		}
	}
	
}

