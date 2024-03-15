package so.memory;

import so.process.Process;

public class FirstFit implements Strategy {

    @Override
    public int findSlot(String[] memory, Process process) {
        int size = process.getSize();
        for (int i = 0; i <= memory.length - size; i++) {
            boolean found = true;
            for (int j = i; j < i + size; j++) {
                if (memory[j] != null) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}