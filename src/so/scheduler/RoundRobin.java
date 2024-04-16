package so.scheduler;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.process.Process;

public class RoundRobin extends Scheduler {
    private Queue<SubProcess> queue;

    private int clockCounter;
    
    public static int QUANTUM = 3000;

    public RoundRobin() {
        super();
        this.queue = new LinkedList<>();
        clockCounter = 0;
    }

    @Override
    public void execute(Process process) {
        List<SubProcess> listsubProcess = SystemOperation.systemCall(SystemCallType.READ_PROCESS, process);
        for (SubProcess subProcess : listsubProcess) {
            queue.add(subProcess);
        }
        
        while (!queue.isEmpty()) {
            SubProcess currentProcess = queue.poll();
            int remainingTime = currentProcess.getTimeToExecute();
            while (remainingTime > 0) {
                clockCounter++;
                remainingTime--;     
                if (clockCounter >= QUANTUM) {
                    queue.add(currentProcess);
                    clockCounter = 0;
                    break;
                }
            }
            if (remainingTime == 0) {
                System.out.println("Subprocesso " + currentProcess + " finalizado");
            }
        }
        System.out.println("Todos os subprocessos foram finalizados");
    }

    @Override
    public void finish(Process process) {
       
    }

    @Override
    public boolean isEmpty(Process process) {
        return queue.isEmpty();
    }
}
