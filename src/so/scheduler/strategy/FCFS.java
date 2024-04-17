package so.scheduler.strategy;

import java.util.List;
import java.util.Queue;
import java.util.Comparator;
import java.util.LinkedList;

import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.cpu.Core;
import so.cpu.CpuManager;
import so.process.Process;
import so.scheduler.Scheduler;
import so.scheduler.SchedulerQueue;

public class FCFS extends SchedulerQueue {

	public FCFS() {
		super(new Comparator<Process>() {
			@Override
			public int compare(Process p1, Process p2) {
				return -1;
			}
		});
	}
	
    
    }

