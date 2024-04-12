package so.memory;

import java.util.List;

import so.SubProcess;
import so.process.Process;

public interface Strategy {
	
	
	
    List<FrameMemory> findSlot(SubProcess[][] physicalMemory, Process process);
}
