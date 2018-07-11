import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controller for the application
 */
class TickerController {
    private IntervallicTicker ticker;
    private View tickerDisplay;
    private Thread tickerThread;
    TickerController() {
        ActionListener runListener = e -> {
            TimeContainer time = tickerDisplay.getTime();
            ticker = new IntervallicTicker.Builder()
                    .hours(time.hours)
                    .minutes(time.minutes)
                    .seconds(time.seconds)
                    .build();

            tickerThread = new Thread(new TickerThread(tickerDisplay, ticker));
            tickerThread.start();
        };

        tickerDisplay = new TickerDisplay(runListener);
    }
}