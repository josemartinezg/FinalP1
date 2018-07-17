package logical;
import java.util.Timer;
import java.util.TimerTask;
public class CountDown {
	Timer timer;
    public CountDown() {
       timer = new Timer();
       timer.schedule(new DisplayCountdown(), 0, 1000);
   }
   class DisplayCountdown extends TimerTask {

         int seconds = 60;
         int minutes = 2;
         public void run() {
              if (seconds > 0) {
                 System.out.println(minutes + "min" + seconds + " seconds remaining");
                 seconds--;
              } else if (minutes > 0) {
                  minutes--;
                  seconds = 60;
             } else {
            	 System.out.println("Countdown finished");
                 System.exit(0);
             }
       }
  }
}
