package so;

import java.util.List;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.process.Process;
import so.scheduler.FCFS;
import so.scheduler.Scheduler;
import so.scheduler.SchedulerQueue;

public class SystemOperation {
	

	private static MemoryManager memory;
	private	static SchedulerQueue scheduler;

	
	public static Process systemCall(SystemCallType type, int processSize) {
		if (type.equals(SystemCallType.CREATE_PROCESS)) {
			if (memory == null) {
				memory = new MemoryManager();
			}
			if(scheduler == null) {
				scheduler = new FCFS();
			 }
		}
		return new Process(processSize);
		}
		
	public static List<SubProcess> systemCall(SystemCallType type, Process process) {
		 if (type.equals(SystemCallType.CLOSE_PROCESS)) {
			 scheduler.finish(process);
			memory.deallocate(process);
		}
		 if (type.equals(SystemCallType.WRITE_PROCESS)) {

			  if (memory != null && scheduler != null) {
				memory.write(process);
				scheduler.execute(process);
				memory.printMemoryStatus();
			  }
		
		}
		if(type.equals(SystemCallType.READ_PROCESS)) {
			return memory.read(process);
		} return null;
	}
	public static void main(String[] args) {

		SystemOperation.memory = new MemoryManager();
		
		Process process1 = systemCall(SystemCallType.CREATE_PROCESS, 4);
		
		systemCall(SystemCallType.WRITE_PROCESS, process1);
		
		
		




	}
	
}
