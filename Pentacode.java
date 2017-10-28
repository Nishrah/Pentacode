import robocode.*;

public class Pentacode extends AlphaBot{
	boolean movingForward;
	public void run() {

		// Loop forever
		while (true) {
			
			ahead(40000);
			movingForward = true;
			//wait(new TurnCompleteCondition(this));
			turnRight(90);
			//wait(new TurnCompleteCondition(this));
			turnLeft(180);
			//wait(new TurnCompleteCondition(this));
			turnRight(180);			
		
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
		reverseDirection();
	}
	
		public void reverseDirection() {
			if (movingForward) {
				back(1000);
				turnRight(250);
        movingForward = false;
      } else {
        ahead(1000);
        turnLeft(250);
        movingForward = true;
      }
	}  
	
}
