import cn.wmyskxz.controller.ForeController;
import cn.wmyskxz.mapper.CategoryMapper;
import cn.wmyskxz.pojo.Category;
import cn.wmyskxz.pojo.ClassInfo;
import cn.wmyskxz.pojo.Question;
import cn.wmyskxz.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestService {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ClassInfoService classInfoService;
    @Autowired
    CommentService commentService;
    @Autowired
    Order_Service order_service;
    @Autowired
    QuestionService questionService;
    @Autowired
    Referal_LinkService referal_linkService;
    @Autowired
    UserInfoService userInfoService;
    ApplicationContext c;
    MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext wac;
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(wac).build();
    }
    @Test
    public void tt() throws Exception {

        ResultActions resultActions = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/searchClassInfo").accept(MediaType.APPLICATION_JSON).param("keyword","圆锥曲线"));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("客户端获的数据:" + result);
    }
    public void testCategory(){
        c=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        classInfoService=c.getBean(ClassInfoServiceImpl.class);
        questionService=c.getBean(QuestionServiceImpl.class);
        //List<Category> categoryList=categoryService.list();
//        for(Category c:categoryList){
//            System.out.println("domain:"+c.getDomain());
//            System.out.println("ID:"+c.getId());
//        }
//        Category category=categoryService.get(1);
//        System.out.println("domain:"+category.getDomain());
//        System.out.println("ID:"+category.getId());
        for(Question question:questionService.list()){
            System.out.println("\n"+question.getTitle()+"\n");
        }
        //questionService.delete(1);
//        for(Question question:questionService.list()){
//            System.out.println("\n"+question.getTitle()+"\n");
//        }
//        System.out.println("\n\n\n");
//        classInfoService.delete(1);
//        classInfoService.delete(2);
//        for(ClassInfo classInfo:classInfoService.list()){
//            System.out.println(classInfo.getTitle());
//        }


    }

//    @Test
//    public static void main(String[] args) throws Exception {
//        TestService testService=new TestService();
//        testService.tt();
//    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
