package so.scheduler.strategy;

import java.util.Comparator;
import so.process.Process;
import so.scheduler.SchedulerQueue;

public class SJF extends SchedulerQueue {

    public SJF() {
        super(new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {

                return Integer.compare(p1.getTimeToExecute(), p2.getTimeToExecute());
            }
        });
    }
}
