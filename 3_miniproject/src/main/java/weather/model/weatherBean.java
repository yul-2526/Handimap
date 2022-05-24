package weather.model;

public class weatherBean {

	private String step1;
	private String step2;
	private String step3;
	private String nx;
	private String ny;
	
	public weatherBean() {
		super();
	}
	public weatherBean(String step1, String step2, String step3, String nx, String ny) {
		super();
		this.step1 = step1;
		this.step2 = step2;
		this.step3 = step3;
		this.nx = nx;
		this.ny = ny;
	}
	public String getStep1() {
		return step1;
	}
	public void setStep1(String step1) {
		this.step1 = step1;
	}
	public String getStep2() {
		return step2;
	}
	public void setStep2(String step2) {
		this.step2 = step2;
	}
	public String getStep3() {
		return step3;
	}
	public void setStep3(String step3) {
		this.step3 = step3;
	}
	public String getNx() {
		return nx;
	}
	public void setNx(String nx) {
		this.nx = nx;
	}
	public String getNy() {
		return ny;
	}
	public void setNy(String ny) {
		this.ny = ny;
	}


}
