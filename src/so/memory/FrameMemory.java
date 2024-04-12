package so.memory;

public class FrameMemory {
	private int PageNumber;
	private int displacement;
	
	
	public FrameMemory(int pageNumber, int displacement) {

		PageNumber = pageNumber;
		this.displacement = displacement;
	}


	public int getPageNumber() {
		return PageNumber;
	}


	public void setPageNumber(int pageNumber) {
		PageNumber = pageNumber;
	}


	public int getDisplacement() {
		return displacement;
	}


	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
	
	

}
