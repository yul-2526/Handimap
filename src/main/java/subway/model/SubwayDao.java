package subway.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mySubwayDao")
public class SubwayDao {
	private String namespace="subway.SubwayBean";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insertSubway(SubwayBean subwayBean) {
		int cnt = -1; 
		try {
			cnt = sqlSessionTemplate.insert(namespace+".InsertSubway", subwayBean);
		} catch (Exception e) {
		}
		return cnt;
	}

	public List<SubwayBean> selectSubway() {
		List<SubwayBean> sList = new ArrayList<SubwayBean>();
		//try {
		sList = sqlSessionTemplate.selectList(namespace+".SelectSubway");
		//} catch (Exception e) {
		//}
		return sList;
	}
}
