package so.process;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import so.SubProcess;
import so.memory.MemoryAddress;

public class Process {
	
	private String processId;
	private int size;
	private MemoryAddress memoryAddress;
	private int timeToExecute;
	private int Priority;
	private int numberOfInstructions;
	private List<String> subProcesses;
	private static int count;
	
	

	

	public Process(int size, int timeToExecute, int Priority) {
		count++;
		this.timeToExecute = timeToExecute;
		this.Priority = Priority;
		this.processId = "P" + count;
		this.size = size;
		this.subProcesses = getSubProcesses();
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



	public List<String> getSubProcesses() {
		if(this.subProcesses == null || this.subProcesses.isEmpty()) {
		List<String> process = new LinkedList<>();
			for(int i = 0; i < this.getSize(); i++) {
				process.add((this.getProcessId() + " " + i));
			}
			this.subProcesses = process;
		}
		return this.subProcesses;
	}



	public void setSubProcesses(List<String> subProcesses) {
		this.subProcesses = subProcesses;
	}



	public int getTimeToExecute() {
		return timeToExecute;
	}



	public void setTimeToExecute(int timeToExecute) {
		this.timeToExecute = timeToExecute;
	}



	public int getPriority() {
		return Priority;
	}



	public void setPriority(int priority) {
		Priority = priority;
	}
	
	
	
	

	
	
	
	
	


	
	
	
	
	
	

}
