package visual;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextPane;
public class BasketCountDown {
	private Timer timer;
	private JTextPane clock;
	private int minutes;
	private int seconds;
	private boolean running;
	private GameComentary game;
	
	private int defaultMinutes;
	private int defaultSeconds;
	
    public BasketCountDown(int minutes, int seconds, JTextPane clock, GameComentary game) {
    	this.minutes = minutes;
    	this.seconds = seconds;
    	this.clock = clock;
    	this.game = game;
    	
    	defaultMinutes = minutes;
    	defaultSeconds = seconds;
    	running = false;

    }
   public static String digitToTime(int number) {
	   return (number < 10 ? "0" : "") + Integer.toString(number);
   }
   public void start() {
	   if (!running) {
		   timer = new Timer();
		   clock.setText(BasketCountDown.digitToTime(minutes) + ":" + BasketCountDown.digitToTime(seconds));
		   timer.schedule(new DisplayCountdown(), 0, 100);
		   running = true;
	   }
   }
   public void stop() {
	   timer.cancel();
	   running = false;
   }
   
   private void reset() {
	   stop();
	   this.minutes = this.defaultMinutes;
	   this.seconds = this.defaultSeconds;
   }
   
   class DisplayCountdown extends TimerTask {
         public void run() {
              if (seconds >= 0) {
            	 clock.setText(BasketCountDown.digitToTime(minutes) + ":" + BasketCountDown.digitToTime(seconds));
                 seconds--;
              } else if (minutes > 0) {
            	  try {
					BSM.update();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                  minutes--;
                  seconds = 59;
             } else {
                 running = false;
                 try {
					game.endPeriod();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 reset();
             }
       }
   }

	public int getMinutes() {
		return minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	public void setClock(JTextPane clock) {
		this.clock = clock;
	}
	public int getDefaultMinutes() {
		return defaultMinutes;
	}
	public int getDefaultSeconds() {
		return defaultSeconds;
	}
	public void setDefaultMinutes(int defaultMinutes) {
		this.defaultMinutes = defaultMinutes;
	}
	public void setDefaultSeconds(int defaultSeconds) {
		this.defaultSeconds = defaultSeconds;
	}
}
