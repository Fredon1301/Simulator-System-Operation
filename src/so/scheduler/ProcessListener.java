package so.scheduler;

public interface ProcessListener {
	public void coreExecuted(int coreId, String processId);
	public void clockExecuted(int clockTime);

}
