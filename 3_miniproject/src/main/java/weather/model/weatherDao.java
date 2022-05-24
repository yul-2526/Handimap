package weather.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myWeather")
public class weatherDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace="weather.WeatherBean";

	public int getTotalCount() {
		int cnt = 0;
		try {
			cnt = sqlSessionTemplate.selectOne(namespace+".GetAllTotalCount");
		}catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}//getTotalCount

	public int insertWeather(weatherBean weatherBean) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertWeather", weatherBean);
		return cnt;
	}//insertBohum

	public List<weatherBean> selectTodayWeather() {
		List<weatherBean> boteArr = new ArrayList<weatherBean>();
		
		try {		
			boteArr = sqlSessionTemplate.selectList(namespace+".GetAllBoteArr");
		}catch (Exception e) {
			// TODO: handle exception
		}	
		return boteArr;
	}//selectTodayWeather
	
	public List<weatherBean> selectStep1(){
		List<weatherBean> step1=new ArrayList<weatherBean>();
		step1=sqlSessionTemplate.selectList(namespace+".SelectStep1");
		System.out.println("wdao.selectStep1 성공");
		return step1;
	}//selectStep1

	public List<weatherBean> selectStep2(String step1){
		List<weatherBean> step2=new ArrayList<weatherBean>();
		step2=sqlSessionTemplate.selectList(namespace+".SelectStep2"+step1);
		System.out.println("wdao.selectStep2 성공");
		return step2;
	}//selectStep2


	public String getNx(String step1, String step2) {
		String cx=sqlSessionTemplate.selectOne(namespace+".GetNx"+step1+step2);
		return cx;
	}//getNx

	public String getNy(String step1, String step2) {
		String cy=sqlSessionTemplate.selectOne(namespace+".GetNy"+step1+step2);
		return cy;
	}//getNy
}
