package so;

import java.util.List;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.process.Process;
import so.scheduler.FCFS;
import so.scheduler.RoundRobin;
import so.scheduler.Scheduler;

public class SystemOperation {
	

	private static MemoryManager memory;
	private	static Scheduler scheduler;

	
	public static Process systemCall(SystemCallType type, int processSize) {
		if (type.equals(SystemCallType.CREATE_PROCESS)) {
			if (memory == null) {
				memory = new MemoryManager();
			}
			if(scheduler == null) {
				scheduler = new RoundRobin();
			 }
		}
		return new Process(processSize);
		}
		
	public static List<SubProcess> systemCall(SystemCallType type, Process process) {
		 if (type.equals(SystemCallType.CLOSE_PROCESS)) {
			memory.deallocate(process);
			scheduler.finish(process);
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
		
		Process process1 = systemCall(SystemCallType.CREATE_PROCESS, 81);
		Process process2 = systemCall(SystemCallType.CREATE_PROCESS, 13);
		Process process3 = systemCall(SystemCallType.CREATE_PROCESS, 34);
		
		
		systemCall(SystemCallType.WRITE_PROCESS, process1);
		systemCall(SystemCallType.WRITE_PROCESS, process2);
		systemCall(SystemCallType.WRITE_PROCESS, process3);
		systemCall(SystemCallType.CLOSE_PROCESS, process1);
		systemCall(SystemCallType.CLOSE_PROCESS, process3);
		
		




	}
	
}
