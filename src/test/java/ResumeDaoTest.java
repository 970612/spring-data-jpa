import com.lagou.edu.dao.ResumeDao;
import com.lagou.edu.pojo.Resume;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ResumeDaoTest {
    @Autowired
    private ResumeDao resumeDao;

    @Test
    public void testFindById(){
        Optional<Resume> byId = resumeDao.findById(1l);//这里要加L修饰
        Resume resume = byId.get();
        System.out.println(resume);
    }
    @Test
    public void testFindAll(){
        List<Resume> resumes = resumeDao.findAll();
        for (Resume resume : resumes) {
            System.out.println(resume);
        }
    }
    @Test
    public void testFindOne() {
        Resume resume = new Resume();
        resume.setId(1L);
        Example<Resume> example = Example.of(resume);
        Optional<Resume> one = resumeDao.findOne(example);
        Resume resume1 = one.get();
        System.out.println(resume1);
    }
    @Test
    public void testSaveResume(){
        Resume resume = new Resume();
        resume.setId(5L);
        resume.setName("赵柳流");
        resume.setAddress("成都");
        resume.setPhone("122332342");
        Resume save = resumeDao.save(resume);
        System.out.println(save);
    }
    @Test
    public void testDelete(){
        resumeDao.deleteById(5L);
    }
    @Test
    public void testjpql(){
        List<Resume> resumeList = resumeDao.findByJpql(1L,"张三");
        for (Resume resume : resumeList) {
            System.out.println(resume);
        }
    }

}
