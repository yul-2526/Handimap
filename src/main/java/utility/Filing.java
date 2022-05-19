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
		try { // 경로에 있는 파일을 읽
			String downloadPath = request.getRealPath("/resources");
			System.out.println("downloadPath"+downloadPath);

			FileInputStream file = new FileInputStream(downloadPath+"/subway/subway_code_info.xlsx"); 
			XSSFWorkbook workbook = new XSSFWorkbook(file); 
			int rowNo = 0; 
			int cellIndex = 0;
			XSSFSheet sheet = workbook.getSheetAt(0); // 0 번째 시트를 가져온다 
			// 만약 시트가 여러개 인 경우 for 문을 이용하여 각각의 시트를 가져온다
			int rows = sheet.getPhysicalNumberOfRows(); // 사용자가 입력한 엑셀 Row수를 가져온다 
			for(rowNo = 0; rowNo < rows; rowNo++){ 
				XSSFRow row = sheet.getRow(rowNo); 
				if(row != null){ 
					int cells = row.getPhysicalNumberOfCells(); // 해당 Row에 사용자가 입력한 셀의 수를 가져온다 
					SubwayBean subwayBean = new SubwayBean();
					for(cellIndex = 0; cellIndex <= cells; cellIndex++){ 
						XSSFCell cell = row.getCell(cellIndex); // 셀의 값을 가져온다
						String value = ""; if(cell == null){ // 빈 셀 체크 
							continue;
						}else{ // 타입 별로 내용을 읽는다 
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
						System.out.println( rowNo + "번 행 : " + cellIndex + "번 열 값은: " + value);
					}
				} 
			} 
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		return subwayList;
	}
} 

