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
	}//selectMyChoochunBohum
}
