package so.memory;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import so.SubProcess;
import so.process.Process;
public class MemoryManager {
	
	private Strategy strategy;
	private Hashtable<String, FrameMemory> logicalMemory;
	private int pageSize;
	private SubProcess[][] physicalMemory;
	private static int INTRUCTIONS_PER_PROCESS = 7;

	
	public MemoryManager(int pageSize, int physicalMemorySize) {
		this.strategy = new Paging();
		this.pageSize = pageSize;
		this.logicalMemory = new Hashtable<String, FrameMemory>();
		int pages = physicalMemorySize/pageSize;
		this.physicalMemory = new SubProcess[pages][pageSize];

	}
	
	public MemoryManager() {
	this(4,256);
	}
	
	
	public void write(Process process) {	
	    List<FrameMemory> frames = strategy.findSlot(physicalMemory, process);
	    int spaces = (int) Math.ceil((double) process.getSubProcesses().size() / this.getPageSize());
	    List<String> subProcessesIds = process.getSubProcesses();
	    if (spaces <= frames.size()) {
	        int subProcessIndex = 0;
	        for(int i = 0; i < spaces; i++) {
	        	FrameMemory  frameMemory = frames.get(i); 
	            for(int j = 0; j < this.pageSize; j++) {
	                if(subProcessIndex < process.getSubProcesses().size()) {
	                    SubProcess subProcess = new SubProcess(subProcessesIds.get(subProcessIndex), INTRUCTIONS_PER_PROCESS);
	                    this.physicalMemory[frames.get(i).getPageNumber()][j] = subProcess;
	                    frameMemory.setDisplacement(j);
	                    this.logicalMemory.put(subProcess.getSubProcessId(), frameMemory);
	                    subProcessIndex++;
	                
	                } else {
	                    break;
	                }
	            }
	        }
	    }

	}

	public void deallocate(Process process) {
	    Iterator<Map.Entry<String, FrameMemory>> iterator = logicalMemory.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry<String, FrameMemory> entry = iterator.next();
	        String key = entry.getKey();
	        String[] parts = key.split(" ");
	        String processId = parts[0];
	        if (processId.equals(process.getProcessId())) {
	            FrameMemory frame = entry.getValue();
	            for (int j = 0; j < physicalMemory[frame.getPageNumber()].length; j++) {
	                physicalMemory[frame.getPageNumber()][j] = null;
	            }
	            iterator.remove();
	        }
	    }
	}
	public void printMemoryStatus() {
		for(int i = 0; i < this.physicalMemory.length; i++) {
			for (int j = 0; j < this.physicalMemory[i].length; j++) {
				SubProcess subProcess = this.physicalMemory[i][j];
				String subProcessId = null;
				if (subProcess != null ) {
					subProcessId = subProcess.getSubProcessId();
				}
				if (j == this.physicalMemory[i].length - 1) {
					System.out.println(subProcessId);
				} else {
					System.out.print(subProcessId + " | " );
				}
			}
		}
		System.out.println("");
		System.out.println("****************************************");
		System.out.println("");
	}


	
	public List<SubProcess> read(Process process) {
	    List<String> subProcessIds = process.getSubProcesses();
	    List<SubProcess> subProcesses = new LinkedList<>();
	    for (int i = 0; i < subProcessIds.size(); i++) {
	        String subProcessId = subProcessIds.get(i) + " " + i;
	        FrameMemory physicalMemoryAddress = this.logicalMemory.get(subProcessId);
	        if (physicalMemoryAddress != null) { 
	            int pageNumber = physicalMemoryAddress.getPageNumber();
	            int displacement = physicalMemoryAddress.getDisplacement();
	            subProcesses.add(this.physicalMemory[pageNumber][displacement]);
	        }
	    }
	    return subProcesses;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	

	public SubProcess[][] getPhysicalMemory() {
		return physicalMemory;
	}

	public void setPhysicalMemory(SubProcess[][] physicalMemory) {
		this.physicalMemory = physicalMemory;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	


	
	
	

}
