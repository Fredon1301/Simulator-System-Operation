package so.scheduler;

import so.cpu.CpuManager;
import so.process.Process;
public abstract class Scheduler {
	
	public CpuManager cpuManager;
	
	public Scheduler(ProcessListener processListener) {
		this.cpuManager = new CpuManager(processListener);
	}
	
	public Scheduler() {}
	
	
	public abstract void execute(Process process);
	public abstract void closeProcess(Process process);
	public abstract boolean isFinished();
	
	public CpuManager getCpuManager() {
		return cpuManager;
	}

	
	
}
