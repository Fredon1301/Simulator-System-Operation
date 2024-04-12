package so.memory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import so.SubProcess;
import so.process.Process;

public class Paging implements Strategy {
	
	
	


	@Override
	public List<FrameMemory> findSlot(SubProcess[][] memory, Process process) {
		List<FrameMemory> frames = new LinkedList<>();
		for (int i = 0; i < memory.length; i++) {
			if (memory[i][0] == null) {
				frames.add(new FrameMemory(i,0));
			}
			
		}
		return frames;
	}

}
