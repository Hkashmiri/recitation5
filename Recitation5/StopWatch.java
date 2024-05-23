import java.util.Calendar;

/**
 * Write a description of class StopWatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StopWatch
{
    private boolean isInReset;
    private long initialTime;
    private long currentTime;

    public StopWatch()
    {
        reset();
    }

    public void reset()
    {
        isInReset = true;
        initialTime = 0;
        currentTime = 0;
    }

    public void set(long seconds){
        currentTime = Calendar.getInstance().getTimeInMillis();
        initialTime = currentTime - (seconds*1000);
    }

    public void startStop()
    {
        currentTime = Calendar.getInstance().getTimeInMillis();
        if (initialTime == 0) {
            initialTime = currentTime;
        }
    }

    public long elapsedTime()
    {
        if (initialTime == 0) {
            return 0;
        } else {
            return currentTime - initialTime;
        }
    }

    public String toString()
    {
        long time = elapsedTime()/1000; // time in seconds
        long hours = time / 3600;
        long minutesAndSeconds = time % 3600;
        long min = minutesAndSeconds / 60;
        long seconds = minutesAndSeconds % 3600;
        return String.format("%02d:%02d:%02d", hours, min, seconds);
    }
}
