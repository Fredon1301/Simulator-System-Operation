package so.scheduler;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.cpu.Core;
import so.cpu.CpuManager;
import so.process.Process;

public class SchedulerQueue extends Scheduler implements ProcessListener {

	
	protected PriorityQueue<Process> queue;
	protected Hashtable<String, List<SubProcess>> subProcesses;
	
	
	public SchedulerQueue(Comparator<Process> comparator) {
		this.queue = new PriorityQueue<>(comparator);
		this.subProcesses = new Hashtable<String, List<SubProcess>>();
		this.cpuManager = new CpuManager(this);
	}
	

	@Override
	public void execute(Process process) {
		List<SubProcess> subProcess = SystemOperation.systemCall(SystemCallType.READ_PROCESS, process);
		this.queue.add(process);
		this.subProcesses.put(process.getProcessId(), subProcess);
		registerInProcessor(process.getProcessId());
		
	}

	@Override
	public void closeProcess(Process process) {
		this.getCpuManager().finishExecution(process);
		
	}

	@Override
	public boolean isFinished() {
		return this.queue.isEmpty();
	}
	
	private void registerInProcessor(String processId) {
		for(Core core : this.getCpuManager().getCores()) {
			if(core.getActuallySubProcess() == null) {
				this.coreExecuted(core.getCoreId(), processId);
			}
		}
	}

	
	@Override
	public void coreExecuted(int coreId, String processId) {
		try {
			System.out.println("Core executed");
			if(this.subProcesses.get(processId) != null ) {
				Process actuallyProcess = this.queue.peek();
				List<SubProcess> subProcess = this.subProcesses.get(actuallyProcess.getProcessId());
				if(subProcess.isEmpty()) {
					this.queue.poll();
					this.subProcesses.remove(processId);
					actuallyProcess = this.queue.peek();
					
				}
				SubProcess actuallySubProcess = subProcess.remove(subProcess.size() - 1);
				this.cpuManager.registerProcess(coreId, actuallySubProcess);
			}
		} catch (Exception e) {
			System.out.println("Processo interrompido: ERROR");
		}
		
	}
	
	@Override
	public void clockExecuted(int clockTime) {}
}
