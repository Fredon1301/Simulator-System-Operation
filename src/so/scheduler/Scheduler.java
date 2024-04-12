package so.scheduler;

import so.cpu.CpuManager;
import so.process.Process;
public abstract class Scheduler {
	
	private CpuManager cpuManager;
	
	public Scheduler() {
		this.cpuManager = new CpuManager();
	}

	public abstract void execute(Process process);
	public abstract void finish(Process process);
	public abstract boolean isEmpty(Process process);
	
	public CpuManager getCpuManager() {
		return cpuManager;
	}

	
	
}
