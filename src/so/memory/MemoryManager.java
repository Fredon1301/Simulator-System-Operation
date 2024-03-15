package so.memory;
import so.process.Process;
public class MemoryManager {
	
	private Strategy strategy;
	private String[] physicMemory;
	private String[] logicMemory;

	
	public MemoryManager() {
		this.strategy = new WorstFit();
		this.physicMemory = new String[128];
		this.logicMemory = new String[128];
	}
	
	
	public void write(Process process) {
	    int index = strategy.findSlot(physicMemory, process);
	    if (index != -1) {
	        for (int i = 0; i < process.getSize(); i++) {
	            physicMemory[index + i] = process.getProcessId();
	        }
	        process.setMemoryAddress(new MemoryAddress(index, index + process.getSize() - 1));
	        System.out.printf("Processo %s alocado com o espaço de memoria %d no endereço de memoria que inicia no index %d e finaliza no %d  %n", process.getProcessId(), process.getSize(),
	        		process.getMemoryAddress().getStart(), process.getMemoryAddress().getEnd() );
	    } else {
	        System.out.printf("Não há espaço suficiente na memória para o processo: %s, pois o tamanho deste processo eh %d %n", process.getProcessId(), process.getSize());
	    }
	}
		
	public void deallocate(Process process) {
        MemoryAddress memoryAddress = process.getMemoryAddress();
        if (memoryAddress != null) {
            for (int i = memoryAddress.getStart(); i <= memoryAddress.getEnd(); i++) {
                physicMemory[i] = null;
            }
            System.out.printf("Processo %s do tamanho %d removido do indice que inicia em %d até %d, que agora estão disponíveis %n ", process.getProcessId(), process.getSize(),
            		process.getMemoryAddress().getStart(), process.getMemoryAddress().getEnd());
            process.setMemoryAddress(null);
        }
    }


	
	public void viewMemory() {
		System.out.println("\n Memória: \n");
		for (String i: physicMemory) {
			System.out.println(i);
		}
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public String[] getPhysicMemory() {
		return physicMemory;
	}

	public void setPhysicMemory(String[] physicMemory) {
		this.physicMemory = physicMemory;
	}

	public String[] getLogicMemory() {
		return logicMemory;
	}

	public void setLogicMemory(String[] logicMemory) {
		this.logicMemory = logicMemory;
	}
	
	
	

}
