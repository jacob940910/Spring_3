import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mybatis.dao.GoodDao;
import com.mybatis.domain.Good;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"classpath:applicationContext.xml");
		
		GoodDao dao = context.getBean(GoodDao.class);
		
		//System.out.println(dao);

		//System.out.println(dao.list());
		
		Good g = new Good();
		g.setCode(100);
		g.setName("사과");
		g.setManufacture("대구");
		g.setPrice(10000);
		dao.insertGood(g);
		
		List<Good> list = dao.list();
		for(Good good : list) {
			System.out.println(good);
		}
		
		
		context.close();
	}

}
