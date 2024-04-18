package so.cpu;
import so.process.Process;
import so.scheduler.ProcessListener;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import so.SubProcess;

public class CpuManager {
	
	private Core[] cores;
	private static int CLOCK  = 5000;
	
	private static int NUMBER_OF_CORES = 4,INSTRUCTIONS_PER_SECOND = 7;
	
	
	private Timer timer;
	
	private ProcessListener processListener;
	
	public CpuManager (ProcessListener processListener) {
		this.cores = new Core[NUMBER_OF_CORES];
		this.processListener = processListener;
		for (int i = 0; i < this.cores.length; i++) {
			this.cores[i] = new Core(INSTRUCTIONS_PER_SECOND, i, this.processListener);
		}
		this.clock();
		
		
	}
	

	
	public void clock() {
		this.timer = new Timer();
		this.timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run () {
				System.out.println("******************** Iniciando a execução  ");
				executeProcesses();
			}
		},0, CLOCK);
	}
	
	public void executeProcesses() {
		printProcessor();
		for(int i = 0; i < cores.length; i++) {
			cores[i].run();
		}
		//this.processListener.clockExecuted(CLOCK);
	
	}
	
	private void printProcessor() {
		System.out.println(">>>>>>>> Imprimindo o status do processador <<<<<<<<");
		for(int i = 0; i < this.cores.length; i++) {
			if(this.cores[i].getActuallySubProcess() != null) {
				if( i == (this.cores.length - 1)) {
					System.out.println(this.cores[i].getActuallySubProcess().getProcessId());
				} else {
					System.out.println(this.cores[i].getActuallySubProcess().getProcessId());
				}
			}
			
		}
	}
	
	public void registerProcess(Integer coreIndex, SubProcess subProcess) {
		if(coreIndex != null) {
			cores[coreIndex].setActuallySubProcess(subProcess);
		} else {
			System.out.println("No available cores");
		}
	}
	
	public Core[] getCores() {
		return this.cores;
}
	
	public void finishExecution(Process process) {
		for (Core core : this.cores) {
			if (process.getProcessId().equals(core.getActuallySubProcess().getProcessId())) {
				core.finishExecution();
			}
		}
	}
	
	/*public List<SubProcess> interrupt(Process process) {
		timer.cancel();
		List<SubProcess> subProcesses = new LinkedList<>();
		for (Core core : this.getCores()) {
			SubProcess subProcess = core.getActuallySubProcess();
			if(subProcess.getSubProcessId().equals(process.getProcessId())) {
				subProcesses.add(subProcess);
				core.finishExecution();
			}
		}
		clock();
		return subProcesses;
	}*/
		
	
	}
