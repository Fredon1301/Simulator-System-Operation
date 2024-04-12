package so.scheduler;

import java.util.PriorityQueue;

import so.process.Process;

public class SchedulerQueue extends Scheduler{
	
	private PriorityQueue<Process> queue;
	
	public SchedulerQueue() {
		super();
		this.queue = new PriorityQueue<>();
	}

	@Override
	public void execute(Process process) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish(Process process) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty(Process process) {
		if(this.queue.isEmpty()) {
			return true;
		} else {
			return false;
			
		}
	}

}
