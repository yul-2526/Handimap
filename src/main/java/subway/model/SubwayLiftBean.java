package subway.model;

public class SubwayLiftBean {
	private String TYPE;//	노드링크 유형	
	private String NODE_WKT;//		노드 WKT	(좌표)
	private String NODE_ID;//		노드 ID	
	private String NODE_CODE;//		노드 유형 코드
	private String SGG_CD;//		시군구코드	
	private String SGG_NM;//		시군구명	
	private String EMD_CD;//		읍면동코드	
	private String EMD_NM;//		읍면동명	
	private String SW_CD;//		지하철역코드
	private String SW_NM;//		지하철역명
	public SubwayLiftBean() {
		super();
	}
	public SubwayLiftBean(String tYPE, String nODE_WKT, String nODE_ID, String nODE_CODE, String sGG_CD, String sGG_NM,
			String eMD_CD, String eMD_NM, String SW_CD, String sW_NM) {
		super();
		this.TYPE = tYPE;
		this.NODE_WKT = nODE_WKT;
		this.NODE_ID = nODE_ID;
		this.NODE_CODE = nODE_CODE;
		this.SGG_CD = sGG_CD;
		this.SGG_NM = sGG_NM;
		this.EMD_CD = eMD_CD;
		this.EMD_NM = eMD_NM;
		this.SW_CD = SW_CD;
		this.SW_NM = sW_NM;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		this.TYPE = tYPE;
	}
	public String getNODE_WKT() {
		return NODE_WKT;
	}
	public void setNODE_WKT(String nODE_WKT) {
		this.NODE_WKT = nODE_WKT;
	}
	public String getNODE_ID() {
		return NODE_ID;
	}
	public void setNODE_ID(String nODE_ID) {
		this.NODE_ID = nODE_ID;
	}
	public String getNODE_CODE() {
		return NODE_CODE;
	}
	public void setNODE_CODE(String nODE_CODE) {
		this.NODE_CODE = nODE_CODE;
	}
	public String getSGG_CD() {
		return SGG_CD;
	}
	public void setSGG_CD(String sGG_CD) {
		this.SGG_CD = sGG_CD;
	}
	public String getSGG_NM() {
		return SGG_NM;
	}
	public void setSGG_NM(String sGG_NM) {
		this.SGG_NM = sGG_NM;
	}
	public String getEMD_CD() {
		return EMD_CD;
	}
	public void setEMD_CD(String eMD_CD) {
		this.EMD_CD = eMD_CD;
	}
	public String getEMD_NM() {
		return EMD_NM;
	}
	public void setEMD_NM(String eMD_NM) {
		this.EMD_NM = eMD_NM;
	}
	public String getSW_CD() {
		return SW_CD;
	}
	public void setSW_CD(String SW_CD) {
		this.SW_CD = SW_CD;
	}
	public String getSW_NM() {
		return SW_NM;
	}
	public void setSW_NM(String sW_NM) {
		this.SW_NM = sW_NM;
	}
	
}
