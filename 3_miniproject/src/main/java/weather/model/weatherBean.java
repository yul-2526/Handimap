package weather.model;

import java.sql.Date;

public class weatherBean {

	private String baseDate;
	private String baseTime;
	//private String category;
	//private String fcstDate;
	//private String fcstTime;
	//private String fcstValue;
	private String nx;
	private String ny;
	private String pop;//����Ȯ��
	private String reh;//����
	private String sky;//�ϴû���
	private String tmp;//1�ð� ���
	private String wsd;//ǳ��
	
	public weatherBean() {
	}
	public weatherBean(String baseDate, String baseTime, String nx, String ny, String pop,
			String reh, String sky, String tmp, String wsd) {
		super();
		this.baseDate = baseDate;
		this.baseTime = baseTime;
		this.nx = nx;
		this.ny = ny;
		this.pop = pop;
		this.reh = reh;
		this.sky = sky;
		this.tmp = tmp;
		this.wsd = wsd;
	}

	public String getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}
	public String getBaseTime() {
		return baseTime;
	}
	public void setBaseTime(String baseTime) {
		this.baseTime = baseTime;
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
	public String getPop() {
		return pop;
	}
	public void setPop(String pop) {
		this.pop = pop;
	}
	public String getReh() {
		return reh;
	}
	public void setReh(String reh) {
		this.reh = reh;
	}
	public String getSky() {
		return sky;
	}
	public void setSky(String sky) {
		this.sky = sky;
	}
	public String getTmp() {
		return tmp;
	}
	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	public String getWsd() {
		return wsd;
	}
	public void setWsd(String wsd) {
		this.wsd = wsd;
	}
	
	
}
