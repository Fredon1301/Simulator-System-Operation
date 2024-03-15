package so.memory;

import so.process.Process;

public class WorstFit implements Strategy {

    @Override
    public int findSlot(String[] memory, Process process) {
        int worstFit = -1;
        int size = process.getSize();

        for (int i = 0; i < memory.length; i++) {
            int bigSpace = 0;
            int j = i;
            while (j < memory.length && memory[j] == null) {
                bigSpace++;
                j++;
            }
            if (bigSpace >= size && (worstFit == -1 || bigSpace > worstFit)) {
                worstFit = i;
            }
            i = j;
        }

        return worstFit;
    }
}
