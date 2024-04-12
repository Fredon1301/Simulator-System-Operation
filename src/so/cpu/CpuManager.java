package so.cpu;
import so.process.Process;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import so.SubProcess;

public class CpuManager {
	
	private Core[] cores;
	private static int CLOCK  = 5000;
	
	private static int NUMBER_OF_CORES = 4,NUMBER_OF_INSTRUCTIONS_PER_CLOCK = 7;
	
	public CpuManager () {
		this.cores = new Core[NUMBER_OF_CORES];
		for (int i = 0; i < this.cores.length; i++) {
			this.cores[i] = new Core(NUMBER_OF_INSTRUCTIONS_PER_CLOCK);
		}
		
		
	}
	
	public void registerProcess(int coreIndex, SubProcess subProcess) {
		
	}
	
	public void clock() {
		new Timer().scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run () {
				executeProcesses();
			}
		},0, CLOCK);
	}
	public void executeProcesses() {
		for(Core core : this.cores) {
			if(core.getActuallySubProcess() != null) {
				
				core.run();
			}
		}
	}
	
	public Core[] getCores() {
		return this.cores;
				}
		
	
	}
