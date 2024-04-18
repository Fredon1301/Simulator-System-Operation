package so.scheduler.strategy;

import java.util.Comparator;
import so.process.Process;
import so.scheduler.SchedulerQueue;

public class Priority extends SchedulerQueue {

    public Priority() {
        super(new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                
                return Integer.compare(p2.getPriority(), p1.getPriority());
            }
        });
    }
}