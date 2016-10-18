import com.Model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wuwan on 2016/8/20.
 */
public class Test1 {

    public static void main(String[] args) {
//        IdWorker idWorker = new IdWorker();
//        System.out.println(idWorker.getId());

//        UserDaoImpl userDao = new UserDaoImpl();
//        UserEntity user = new UserEntity();
//        user.setId(1);
//        UserEntity user2 = userDao.find(user);
        try {
            BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
            SessionFactory sessionFactory = (SessionFactory) beanFactory.getBean("sessionFactory");
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            UserEntity user = new UserEntity();
            user.setId(101);
            user.setUsername("test");
            user.setPassword("test");
            session.save(user);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
