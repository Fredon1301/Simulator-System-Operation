package so.scheduler.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import so.process.Process;
import so.scheduler.SchedulerQueue;

public class Lotering extends SchedulerQueue {

    public Lotering() {
        super(new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                Random random = new Random();
                int p1Tickets = p1.getSize(); 
                int p2Tickets = p2.getSize(); 


                int totalTickets = p1Tickets + p2Tickets;
                int randomNumber = random.nextInt(totalTickets);

                System.out.println("Número de bilhetes do processo p1: " + p1Tickets);
                System.out.println("Número de bilhetes do processo p2: " + p2Tickets);

                if (randomNumber < p1Tickets) {

                    return -1;
                } else {

                    return 1;
                }
            }
        });
    }
}
