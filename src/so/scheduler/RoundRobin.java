package so.scheduler;
import java.util.List;

import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.process.Process;
public class RoundRobin extends Scheduler {

	@Override
	public void execute(Process process) {
		List<SubProcess> subProcess = SystemOperation.systemCall(SystemCallType.READ_PROCESS, process);
	}

	@Override
	public void finish(Process process) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty(Process process) {
		// TODO Auto-generated method stub
		return false;
	}

}
