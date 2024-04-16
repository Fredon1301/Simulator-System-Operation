package so.scheduler;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.cpu.Core;
import so.process.Process;

public class FCFS extends Scheduler {
    private Queue<SubProcess> queue;

    public FCFS() {
        super();
        this.queue = new LinkedList<>();
    }

    @Override
    public void execute(Process process) {
        List<SubProcess> listSubProcess = SystemOperation.systemCall(SystemCallType.READ_PROCESS, process);
        if(listSubProcess != null) {
        for (SubProcess subProcess : listSubProcess) {
            this.queue.add(subProcess);
        }
        allocateProcesses();
    }
    }
    @Override
    public void finish(Process process) {
        
    }

    @Override
    public boolean isEmpty(Process process) {
    	if(this.queue.isEmpty()) {
			return true;
		} else {
			return false;
			
		}
    }

    private void allocateProcesses() {
        Core[] cores = this.getCpuManager().getCores();
        for (int i = 0; i < cores.length && !queue.isEmpty(); i++) {
            if (cores[i].getActuallySubProcess() == null) {
                cores[i].setActuallySubProcess(queue.poll());
            }
        }
    }
}
