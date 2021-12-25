import dao.BlogMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Blog;
import utils.IDUtils;
import utils.MybatisUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class JUnitTest {
    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getID());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreate_time(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","Java");
        map.put("author","狂神说");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for(Blog blog:blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","Java");
        map.put("author","狂神说");
        map.put("views","9999");
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for(Blog blog:blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","updatename");
        map.put("author","狂神说");
        map.put("id","8923d5811853403591c748526c943e43");
        mapper.updateBlog(map);
        sqlSession.commit();
        sqlSession.close();
    }
}
