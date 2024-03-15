package so.memory;

import so.process.Process;
import so.memory.MemoryManager;

public class BestFit implements Strategy {
	
	@Override
	public int findSlot(String[] memory, Process process) {
	    int bestFit = -1;
	    int max = Integer.MAX_VALUE;
	    int size = process.getSize();
	    
	    for(int i = 0; i < memory.length; i++) {
	        int freeSpace = 0;
	        int j = i;
	        while (j < memory.length && memory[j] == null) {
	            freeSpace++;
	            j++;
	        }
	        if (freeSpace >= size && freeSpace < max) {
	            max = freeSpace;
	            bestFit = i;
	        }
	        i = j;
	    }
	    return bestFit;
	}
}
