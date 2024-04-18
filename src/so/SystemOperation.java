package so;

import java.util.List;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.process.Process;
import so.scheduler.Scheduler;
import so.scheduler.strategy.FCFS;
import so.scheduler.strategy.Lotering;
import so.scheduler.strategy.Priority;
import so.scheduler.strategy.SJF;

public class SystemOperation {
	

	private static MemoryManager memory;
	private	static Scheduler scheduler;

	
	public static Process systemCall(SystemCallType type, int processSize, int timeToExecute, int Priority) {
		if (type.equals(SystemCallType.CREATE_PROCESS)) {
			if (memory == null) {
				memory = new MemoryManager();
			}
			if(scheduler == null) {
				scheduler = new FCFS();
			 }
		}
		return new Process(processSize, timeToExecute, Priority);
		}
		
	public static List<SubProcess> systemCall(SystemCallType type, Process process) {
		 if (type.equals(SystemCallType.CLOSE_PROCESS)) {
			memory.deallocate(process);
			memory.printMemoryStatus();
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
		
		Process process1 = systemCall(SystemCallType.CREATE_PROCESS, 40, 10, 10 );
		systemCall(SystemCallType.WRITE_PROCESS, process1);
		Process process2 = systemCall(SystemCallType.CREATE_PROCESS, 20,5, 11);
		systemCall(SystemCallType.WRITE_PROCESS, process2);
		Process process3 = systemCall(SystemCallType.CREATE_PROCESS, 60,15, 5);
		systemCall(SystemCallType.WRITE_PROCESS, process3);
		systemCall(SystemCallType.CLOSE_PROCESS, process3);
		
		

		
		
	




	}
	
}
