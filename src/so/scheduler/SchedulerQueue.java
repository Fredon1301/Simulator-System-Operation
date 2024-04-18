package so.scheduler;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.process.Process;

public class SchedulerQueue extends Scheduler {

	
	protected PriorityQueue<Process> queue;
	protected Hashtable<String, List<SubProcess>> subProcesses;
	
	
	public SchedulerQueue(Comparator<Process> comparator) {
		super();
		this.queue = new PriorityQueue<>(comparator);
		this.subProcesses = new Hashtable<String, List<SubProcess>>();
	}
	

	@Override
	public void execute(Process process) {
		List<SubProcess> subProcess = SystemOperation.systemCall(SystemCallType.READ_PROCESS, process);
		this.queue.add(process);
		this.subProcesses.put(process.getProcessId(), subProcess);
		
	}

	@Override
	public void closeProcess(Process process) {
		this.getCpuManager().finishExecution(process);
		
	}

	@Override
	public boolean isFinished() {
		return this.queue.isEmpty();
	}

	
	@Override
	public void coresExecuted(int coreId) {
		//try {
			System.out.println("Core executed");
			Process process = this.queue.peek();
			if(process != null) {
				List<SubProcess> subProcesses = this.subProcesses.get(process.getProcessId());
				if (this.subProcesses.get(process.getProcessId()) == null || this.subProcesses.get(process.getProcessId()).isEmpty()) {
					this.queue.poll(); //Remove o primeiro elemento
					this.subProcesses.remove(process.getProcessId());
					process = this.queue.peek();
					if(process == null) {
						return;
					}
					subProcesses = this.subProcesses.get(process.getProcessId());
					
					if(subProcesses.isEmpty()) {
						return;
					}
					
				}
				SubProcess actuallySubprocess = subProcesses.remove(0);
				cpuManager.registerProcess(coreId, actuallySubprocess);				
			}
	
		/*} catch (Exception e) {
			System.out.println("Processo interrompido: ERRO!");
		}*/
	}
	
	@Override
	public void clockExecuted(int clockTime) {}
}
