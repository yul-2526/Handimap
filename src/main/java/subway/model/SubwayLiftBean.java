package subway.model;

public class SubwayLiftBean {
	private String type;//	��帵ũ ����	
	private String node_wkt;//		��� WKT	(��ǥ)
	private String node_id;//		��� ID	
	private String node_code;//		��� ���� �ڵ�
	private String sgg_cd;//		�ñ����ڵ�	
	private String sgg_nm;//		�ñ�����	
	private String emd_cd;//		���鵿�ڵ�	
	private String emd_nm;//		���鵿��	
	private String sw_cd;//		����ö���ڵ�
	private String sw_nm;//		����ö����
	public SubwayLiftBean() {
		super();
	}
	public SubwayLiftBean(String type, String node_wkt, String node_id, String node_code, String sgg_cd, String sgg_nm,
			String emd_cd, String emd_nm, String sw_cd, String sw_nm) {
		super();
		this.type = type;
		this.node_wkt = node_wkt;
		this.node_id = node_id;
		this.node_code = node_code;
		this.sgg_cd = sgg_cd;
		this.sgg_nm = sgg_nm;
		this.emd_cd = emd_cd;
		this.emd_nm = emd_nm;
		this.sw_cd = sw_cd;
		this.sw_nm = sw_nm;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNode_wkt() {
		return node_wkt;
	}
	public void setNode_wkt(String node_wkt) {
		this.node_wkt = node_wkt;
	}
	public String getNode_id() {
		return node_id;
	}
	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}
	public String getNode_code() {
		return node_code;
	}
	public void setNode_code(String node_code) {
		this.node_code = node_code;
	}
	public String getSgg_cd() {
		return sgg_cd;
	}
	public void setSgg_cd(String sgg_cd) {
		this.sgg_cd = sgg_cd;
	}
	public String getSgg_nm() {
		return sgg_nm;
	}
	public void setSgg_nm(String sgg_nm) {
		this.sgg_nm = sgg_nm;
	}
	public String getEmd_cd() {
		return emd_cd;
	}
	public void setEmd_cd(String emd_cd) {
		this.emd_cd = emd_cd;
	}
	public String getEmd_nm() {
		return emd_nm;
	}
	public void setEmd_nm(String emd_nm) {
		this.emd_nm = emd_nm;
	}
	public String getSw_cd() {
		return sw_cd;
	}
	public void setSw_cd(String sw_cd) {
		this.sw_cd = sw_cd;
	}
	public String getSw_nm() {
		return sw_nm;
	}
	public void setSw_nm(String sw_nm) {
		this.sw_nm = sw_nm;
	}
	
}
