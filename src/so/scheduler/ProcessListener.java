package so.scheduler;

public interface ProcessListener {
	public void coresExecuted(int coreId);
	public void clockExecuted(int clockTime);

}
