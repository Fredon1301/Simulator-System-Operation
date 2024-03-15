package so;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.process.Process;

public class SystemOperation {
	

	private static MemoryManager memory;
	private	static CpuManager cpu;

	
	public static Object systemCall(SystemCallType type, Process process) {
		if (type.equals(SystemCallType.WRITE_PROCESS)) {
			memory.write(process);
			//memory.viewMemory(process);
			return null;
		} else if (type.equals(SystemCallType.CLOSE_PROCESS)) {
			memory.deallocate(process);
			//memory.viewMemory(process);
			return null;
		}else if (type.equals(SystemCallType.CREATE_PROCESS)) {
			return new Process(0);
			
		}else if(type.equals(SystemCallType.READ_PROCESS)) {
			memory.viewMemory();
			
		}
		return null;
	}
	public static void main(String[] args) {
		Process process = new Process(20);
		Process process2 = new Process(38);
		Process process3 = new Process(38);
		Process process4 = new Process(20);
		Process process5 = new Process(8);
		SystemOperation.memory = new MemoryManager();
		
		systemCall(SystemCallType.WRITE_PROCESS, process);
		
		
		systemCall(SystemCallType.WRITE_PROCESS, process2);

		
		systemCall(SystemCallType.WRITE_PROCESS, process3);
		systemCall(SystemCallType.WRITE_PROCESS, process4);
		systemCall(SystemCallType.CLOSE_PROCESS, process2);
		systemCall(SystemCallType.WRITE_PROCESS, process5);
		//systemCall(SystemCallType.READ_PROCESS, null);



	}
	
}
