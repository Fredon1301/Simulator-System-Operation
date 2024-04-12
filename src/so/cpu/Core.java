package so.cpu;


import so.SubProcess;

public class Core implements Runnable{
	private int CoreId;
	private int numberOfInstructionsPerClock;
	private SubProcess actuallySubProcess;
	private int sumInstructionsExecuted;
	
	public Core(int numberOfInstructionsPerClock, int coreId) {
		this.numberOfInstructionsPerClock = numberOfInstructionsPerClock;
		this.CoreId = coreId;
		
	}
	
	public Core(int coreId) {
		this(coreId,7);
	}
	
	@Override
	public void run() {
		this.sumInstructionsExecuted += numberOfInstructionsPerClock;
		if (sumInstructionsExecuted >= actuallySubProcess.getInstructions()) {
			this.finishSubProcess();
		}
	
		
	}

	private void finishSubProcess() {
		this.actuallySubProcess = null;
		this.sumInstructionsExecuted = 0;
		
	}

	public int getCoreId() {
		return CoreId;
	}

	public void setCoreId(int coreId) {
		CoreId = coreId;
	}

	public SubProcess getActuallySubProcess() {
		return actuallySubProcess;
	}

	public void setActuallySubProcess(SubProcess actuallySubProcess) {
		this.actuallySubProcess = actuallySubProcess;
	}
	
	
	
	

}
