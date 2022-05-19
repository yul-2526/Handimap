package subway.model;

public class SubwayBean {
	private String rail_opr_istt_cd;//		공사코드
	private String rail_opr_istt_nm;//	공사이름	
	private String ln_cd;//		라인코드
	private String ln_nm;//		라인이름
	private String stin_cd;//		역코드
	private String stin_nm;//		역이름
	public SubwayBean() {
		super();
	}
	public SubwayBean(String rail_opr_istt_cd, String rail_opr_istt_nm, String ln_cd, String ln_nm, String stin_cd,
			String stin_nm) {
		super();
		this.rail_opr_istt_cd = rail_opr_istt_cd;
		this.rail_opr_istt_nm = rail_opr_istt_nm;
		this.ln_cd = ln_cd;
		this.ln_nm = ln_nm;
		this.stin_cd = stin_cd;
		this.stin_nm = stin_nm;
	}
	public String getRail_opr_istt_cd() {
		return rail_opr_istt_cd;
	}
	public void setRail_opr_istt_cd(String rail_opr_istt_cd) {
		this.rail_opr_istt_cd = rail_opr_istt_cd;
	}
	public String getRail_opr_istt_nm() {
		return rail_opr_istt_nm;
	}
	public void setRail_opr_istt_nm(String rail_opr_istt_nm) {
		this.rail_opr_istt_nm = rail_opr_istt_nm;
	}
	public String getLn_cd() {
		return ln_cd;
	}
	public void setLn_cd(String ln_cd) {
		this.ln_cd = ln_cd;
	}
	public String getLn_nm() {
		return ln_nm;
	}
	public void setLn_nm(String ln_nm) {
		this.ln_nm = ln_nm;
	}
	public String getStin_cd() {
		return stin_cd;
	}
	public void setStin_cd(String stin_cd) {
		this.stin_cd = stin_cd;
	}
	public String getStin_nm() {
		return stin_nm;
	}
	public void setStin_nm(String stin_nm) {
		this.stin_nm = stin_nm;
	}
}
