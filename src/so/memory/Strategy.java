package so.memory;

import so.process.Process;

public interface Strategy {
    int findSlot(String[] memory, Process process);
}
