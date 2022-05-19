package utility;

public class Paging {
	//����¡ ���� ����	
	private int totalCount = 0 ; //�� ���ڵ� �Ǽ�
	private int totalPage = 0 ; //��ü ������ ��
	private int pageNumber = 0 ; //������ ������ �ѹ�(ǥ�� ������ �������� 1���� totalPage�����̴�.)
	private int pageSize = 0 ; //�� �������� ������ �Ǽ�
	private int beginRow = 0 ; //���� �������� ���� ��
	private int endRow = 0 ; //���� �������� �� ��
	private int pageCount = 3 ; // �� ȭ�鿡 ������ ������ ��ũ �� (������ ����)=> ���ڵ� ���� �ƴ� 
	private int beginPage = 0 ; //����¡ ó�� ���� ������ ��ȣ
	private int endPage = 0 ; //����¡ ó�� �� ������ ��ȣ
	private int offset = 0 ; //�ǳʶ� �Խñ��� ��
	private int limit = 0 ; // �� �������� ������ ���ڵ� ����
	private String url = "/" ; //���� ==>  http://localhost:8989/MyServlet/list.do
	private String pagingHtml = "";//�ϴ��� ���� ������ ��ũ
	//�˻��� ���� ���� �߰�
	private String whatColumn = "" ; //�˻� ���(�ۼ���, ������, ��ü �˻��� all) ���
	private String keyword = "" ; //�˻��� �ܾ� 

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBeginRow() {
		return beginRow;
	}

	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPagingHtml() {
		System.out.println("pagingHtml:"+pagingHtml);
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public String getWhatColumn() {
		return whatColumn;
	}

	public void setWhatColumn(String whatColumn) {
		this.whatColumn = whatColumn;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Paging(
			String _pageNumber, 
			String _pageSize,  
			int totalCount,
			String url, 
			String whatColumn, 
			String keyword) {		

		if(  _pageNumber == null || _pageNumber.equals("null") || _pageNumber.equals("")  ){
			System.out.println("_pageNumber:"+_pageNumber); // null
			_pageNumber = "1" ;
		}
		this.pageNumber = Integer.parseInt( _pageNumber ) ; 

		if( _pageSize == null || _pageSize.equals("null") || _pageSize.equals("") ){
			_pageSize = "10" ; // �� �������� ������ ���ڵ� ����
		}		
		this.pageSize = Integer.parseInt( _pageSize ) ;
		
		this.limit = pageSize ; //�� �������� ������ ���ڵ� ����

		this.totalCount = totalCount ; 

		this.totalPage = (int)Math.ceil((double)this.totalCount / this.pageSize) ;
		//ceil�� �ø� �޼ҵ� (3.1�� ��� 4)
		this.beginRow = ( this.pageNumber - 1 )  * this.pageSize  + 1 ;
		this.endRow =  this.pageNumber * this.pageSize ;
		
		if( this.pageNumber > this.totalPage ){
			this.pageNumber = this.totalPage ;
		}
		
		this.offset = ( pageNumber - 1 ) * pageSize ; 
		//�ǳʶ� �Խñ��� ��(���������� 2���� �Խñ��� ���̰��� �� 3���������� 7��° �Խñۺ��� �����ߵȴ�.)
		if( this.endRow > this.totalCount ){
			this.endRow = this.totalCount  ;
		}

		this.beginPage = ( this.pageNumber - 1 ) / this.pageCount * this.pageCount + 1  ;
		this.endPage = this.beginPage + this.pageCount - 1 ;
		
		System.out.println("pageNumber:"+pageNumber+"/totalPage:"+totalPage);	
		
		if( this.endPage > this.totalPage ){
			this.endPage = this.totalPage ;
		}
		
		System.out.println("pageNumber2:"+pageNumber+"/totalPage2:"+totalPage);	
		this.url = url ; //  /ex/list.ab
		this.whatColumn = whatColumn ;
		this.keyword = keyword ;
		System.out.println("whatColumn:"+whatColumn+"/keyword:"+keyword);
		
		this.pagingHtml = getPagingHtml(url) ;
	
	}
	
	private String getPagingHtml( String url ){ //����¡ ���ڿ��� �����.
		System.out.println("getPagingHtml url:"+url); 
		
		String result = "<nav aria-label=\"Page navigation example\">"
				+ "<ul class=\"pagination\">" ;
		String added_param = "&whatColumn=" + whatColumn + "&keyword=" + keyword ; // &whatColumn=singer&keyword=��
		
		if (this.beginPage != 1) { // ����, pageSize:�� ȭ�鿡 ���̴� ���ڵ� ��
			result += "&nbsp;<li class=\"page-item\"><a class=\"page-link\" href='" + url  
					+ "?pageNumber=" + ( 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'><span aria-hidden=\"true\">&laquo;</span></a></li>&nbsp;" ;
			result += "&nbsp;<li class=\"page-item\"><a class=\"page-link\"  href='" + url 
					+ "?pageNumber=" + (this.beginPage - 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'><span aria-hidden=\"true\">&lt;</span></a></li>&nbsp;" ;
		}
		
		//���
		for (int i = this.beginPage; i <= this.endPage ; i++) {
			if ( i == this.pageNumber ) {
				result += "&nbsp;<li class=\"page-item\"><a class=\"page-link\" href='" + url   
						+ "?pageNumber=" + i + "&pageSize=" + this.pageSize 
						+ added_param + "'><font color='red'>" + i + "</font></a></li>&nbsp;" ;
						
			} else {
				result += "&nbsp;<li class=\"page-item\"><a class=\"page-link\" href='" + url   
						+ "?pageNumber=" + i + "&pageSize=" + this.pageSize 
						+ added_param + "'>" + i + "</a></li>&nbsp;" ;
			}
		}
		System.out.println("result:"+result); 
		System.out.println();
		
		if ( this.endPage != this.totalPage) { // ����
			
			result += "&nbsp;<li class=\"page-item\"><a class=\"page-link\" href='" + url  
					+ "?pageNumber=" + (this.endPage + 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'><span aria-hidden=\"true\">&gt;</span></a></li>&nbsp;" ;
			
			result += "&nbsp;<li class=\"page-item\"><a class=\"page-link\" href='" + url  
					+ "?pageNumber=" + (this.totalPage ) + "&pageSize=" + this.pageSize 
					+ added_param + "'><span aria-hidden=\"true\">&raquo;</span></a></li>&nbsp;" ;
		}		
		System.out.println("result2:"+result);
		result += "</ul>"
				+ "</nav>";

		return result ;
	}

}