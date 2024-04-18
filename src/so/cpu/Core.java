package so.cpu;


import so.SubProcess;
import so.scheduler.ProcessListener;

public class Core implements Runnable{
	private int CoreId;
	private int instructionsPerSecond;
	private SubProcess actuallySubProcess;
	
	private ProcessListener processListener;
	
	public Core(int instructionsPerSecond, int coreId, ProcessListener processListener) {
		this.instructionsPerSecond = instructionsPerSecond;
		this.CoreId = coreId;
		this.processListener = processListener;
		
	}
	

	
	@Override
	public void run() {
		if(this.actuallySubProcess != null ) {
			int sumInstructionsExecuted = this.getActuallySubProcess().getInstructionsExecuted() + instructionsPerSecond; //e
			this.actuallySubProcess.setInstructionsExecuted(sumInstructionsExecuted);
			System.out.println("************************* Núcleo " + this.getCoreId()  + "********************************\n");
			System.out.println("Executando SubProcesso " + this.actuallySubProcess.getSubProcessId());
			if (this.actuallySubProcess.getInstructionsExecuted() >= this.actuallySubProcess.getInstructions())  {
				//if (this.actuallySubProcess != null) {
				//	System.out.println(this.actuallySubProcess.getSubProcessId());}
				System.out.println();
				System.out.println("-------->  Fim da execução do subprocesso " + this.actuallySubProcess.getSubProcessId()+"<--------\n");
				this.finishExecution();
			}			
		} else {
			this.finishExecution();
		}
	
		
	}

	public void finishExecution() {
		this.actuallySubProcess = null;
		this.processListener.coresExecuted(this.getCoreId());
		
		
		
	}
	
	public boolean isEmpty() {
		if(actuallySubProcess == null) {
			return true;
		} else  {
			return false;
			
		}
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
