package so.process;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;


import so.memory.MemoryAddress;

public class Process {
	
	private String processId;
	private int size;
	private MemoryAddress memoryAddress;
	// Step second 
	private int timeToExecute;
	private int numberOfInstructions;
	private List<Process> processes;
	private int priority;
	
	

	

	public Process(int size) {
		this.processId = UUID.randomUUID().toString();
		//Random rand = new Random();
		//List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,10,20,30,40,50,60,70,100);
		this.size = size;
	}



	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}



	public MemoryAddress getMemoryAddress() {
		return memoryAddress;
	}



	public void setMemoryAddress(MemoryAddress memoryAddress) {
		this.memoryAddress = memoryAddress;
	}

	
	
	
	


	
	
	
	
	
	

}
