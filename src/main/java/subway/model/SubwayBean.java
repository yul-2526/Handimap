package subway.model;

public class SubwayBean {
	private String lnCd;//	���ڵ�	
	private String mvContDtl;//		�� �̵�����	
	private String mvDst;//		�̵��Ÿ�	
	private String mvPathDvCd;//		�̵���α����ڵ�	
	private String mvPathDvNm;//		�̵���α���	
	private String mvPathMgNo;//		�̵���ΰ�����ȣ	
	private String mvTpOrdr;//		�̵���������	
	private String railOprIsttCd;//		ö�������ڵ�	
	private String stinCd;//		���ڵ�
	public SubwayBean() {
		super();
	}
	public SubwayBean(String lnCd, String mvContDtl, String mvDst, String mvPathDvCd, String mvPathDvNm,
			String mvPathMgNo, String mvTpOrdr, String railOprIsttCd, String stinCd) {
		super();
		this.lnCd = lnCd;
		this.mvContDtl = mvContDtl;
		this.mvDst = mvDst;
		this.mvPathDvCd = mvPathDvCd;
		this.mvPathDvNm = mvPathDvNm;
		this.mvPathMgNo = mvPathMgNo;
		this.mvTpOrdr = mvTpOrdr;
		this.railOprIsttCd = railOprIsttCd;
		this.stinCd = stinCd;
	}
	public String getLnCd() {
		return lnCd;
	}
	public void setLnCd(String lnCd) {
		this.lnCd = lnCd;
	}
	public String getMvContDtl() {
		return mvContDtl;
	}
	public void setMvContDtl(String mvContDtl) {
		this.mvContDtl = mvContDtl;
	}
	public String getMvDst() {
		return mvDst;
	}
	public void setMvDst(String mvDst) {
		this.mvDst = mvDst;
	}
	public String getMvPathDvCd() {
		return mvPathDvCd;
	}
	public void setMvPathDvCd(String mvPathDvCd) {
		this.mvPathDvCd = mvPathDvCd;
	}
	public String getMvPathDvNm() {
		return mvPathDvNm;
	}
	public void setMvPathDvNm(String mvPathDvNm) {
		this.mvPathDvNm = mvPathDvNm;
	}
	public String getMvPathMgNo() {
		return mvPathMgNo;
	}
	public void setMvPathMgNo(String mvPathMgNo) {
		this.mvPathMgNo = mvPathMgNo;
	}
	public String getMvTpOrdr() {
		return mvTpOrdr;
	}
	public void setMvTpOrdr(String mvTpOrdr) {
		this.mvTpOrdr = mvTpOrdr;
	}
	public String getRailOprIsttCd() {
		return railOprIsttCd;
	}
	public void setRailOprIsttCd(String railOprIsttCd) {
		this.railOprIsttCd = railOprIsttCd;
	}
	public String getStinCd() {
		return stinCd;
	}
	public void setStinCd(String stinCd) {
		this.stinCd = stinCd;
	}
	
}
