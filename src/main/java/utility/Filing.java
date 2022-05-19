package utility;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import subway.model.SubwayBean;

public class Filing{

	public ArrayList<SubwayBean> excelSubwayRead(HttpServletRequest request) {
		ArrayList<SubwayBean> subwayList = new ArrayList<SubwayBean>();
		try { // ��ο� �ִ� ������ ��
			String downloadPath = request.getRealPath("/resources");
			System.out.println("downloadPath"+downloadPath);

			FileInputStream file = new FileInputStream(downloadPath+"/subway/subway_code_info.xlsx"); 
			XSSFWorkbook workbook = new XSSFWorkbook(file); 
			int rowNo = 0; 
			int cellIndex = 0;
			XSSFSheet sheet = workbook.getSheetAt(0); // 0 ��° ��Ʈ�� �����´� 
			// ���� ��Ʈ�� ������ �� ��� for ���� �̿��Ͽ� ������ ��Ʈ�� �����´�
			int rows = sheet.getPhysicalNumberOfRows(); // ����ڰ� �Է��� ���� Row���� �����´� 
			for(rowNo = 0; rowNo < rows; rowNo++){ 
				XSSFRow row = sheet.getRow(rowNo); 
				if(row != null){ 
					int cells = row.getPhysicalNumberOfCells(); // �ش� Row�� ����ڰ� �Է��� ���� ���� �����´� 
					SubwayBean subwayBean = new SubwayBean();
					for(cellIndex = 0; cellIndex <= cells; cellIndex++){ 
						XSSFCell cell = row.getCell(cellIndex); // ���� ���� �����´�
						String value = ""; if(cell == null){ // �� �� üũ 
							continue;
						}else{ // Ÿ�� ���� ������ �д´� 
							switch (cell.getCellType()){ 
							case XSSFCell.CELL_TYPE_FORMULA: value = cell.getCellFormula(); 
							break;
							case XSSFCell.CELL_TYPE_NUMERIC: value = cell.getNumericCellValue() + "";
							break;
							case XSSFCell.CELL_TYPE_STRING: value = cell.getStringCellValue() + "";
							break;
							case XSSFCell.CELL_TYPE_BLANK: value = cell.getBooleanCellValue() + ""; 
							break;
							case XSSFCell.CELL_TYPE_ERROR: value = cell.getErrorCellValue() + "";
							break; 
							}
							switch (cellIndex){ 
							case 0: subwayBean.setRail_opr_istt_cd(value); 
							break;
							case 1: subwayBean.setRail_opr_istt_nm(value); 
							break;
							case 2: subwayBean.setLn_cd(value);
							break;
							case 3: subwayBean.setLn_nm(value); 
							break;
							case 4: subwayBean.setStin_cd(value);
							break; 
							case 5: subwayBean.setStin_nm(value);
							break; 
							}
						}
						if(cellIndex==5)subwayList.add(subwayBean);
						System.out.println( rowNo + "�� �� : " + cellIndex + "�� �� ����: " + value);
					}
				} 
			} 
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		return subwayList;
	}
} 

