package so.scheduler;

import so.cpu.CpuManager;
import so.process.Process;
public abstract class Scheduler implements ProcessListener {
	
	public CpuManager cpuManager;
	
	public Scheduler() {
		this.cpuManager = new CpuManager(this);
	}
	
	
	public abstract void execute(Process process);
	public abstract void closeProcess(Process process);
	public abstract boolean isFinished();
	
	public CpuManager getCpuManager() {
		return cpuManager;
	}

	
	
}
