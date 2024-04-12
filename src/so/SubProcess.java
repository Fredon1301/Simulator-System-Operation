package so;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SubProcess {
	
	
	private String subProcessId;
	
	private String processId;
	
	private int timeToExecute;
	
	private static int COUNT_GENERATE_ID = 0;
	
	private int instructions;

	public SubProcess( String processId, int instructions) {
		this.subProcessId =  processId + " " + COUNT_GENERATE_ID;
		COUNT_GENERATE_ID++;
		this.processId = processId;
		this.instructions = instructions;
		Random rand = new Random();
		List<Integer> givenList = Arrays.asList(100,200,300,400,500,600,700,800,900,1000,2000);
		this.timeToExecute = givenList.get(rand.nextInt(givenList.size()));
		
	}

	public String getSubProcessId() {
		return subProcessId;
	}

	public void setSubProcessId(String processId) {
		this.subProcessId = processId;
	}

	public int getInstructions() {
		return instructions;
	}

	public void setInstructions(int instructions) {
		this.instructions = instructions;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public int getTimeToExecute() {
		return timeToExecute;
	}

	public void setTimeToExecute(int timeToExecute) {
		this.timeToExecute = timeToExecute;
	}
	
	
	
	
	
	
	
	

}
