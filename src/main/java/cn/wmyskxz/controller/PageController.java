package cn.wmyskxz.controller;

import cn.wmyskxz.pojo.Category;
import cn.wmyskxz.pojo.ClassInfo;
import cn.wmyskxz.pojo.Question;
import cn.wmyskxz.pojo.UserInfo;
import cn.wmyskxz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@CrossOrigin
public class PageController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    Referal_LinkService referalLinkService;

    @Autowired
    ClassInfoService classInfoService;

    //@Autowired
    //PropertyValueService propertyValueService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserInfoService userInfoService;

    //@Autowired
    //OrderItemService orderItemService;

    @Autowired
    Order_Service orderService;
    @Autowired
    QuestionService questionService;

    @RequestMapping("/postQuestionPage")
    @ResponseBody
    public Map postQuestionPage(HttpSession session){
        Map map=new HashMap();
        UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
        if(null==userInfo){
            map.put("msg","fail");
            return map;
        }
        List<Category> categories=categoryService.list();
        map.put("categories",categories);
        return map;
    }

    @RequestMapping("/postClassPage")
    @ResponseBody
    public Map postClassPage(HttpSession session){
        Map map=new HashMap();
        UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
        if(null==userInfo){
            map.put("msg","fail");
            return map;
        }
        List<Category> categories=categoryService.list();
        map.put("categories",categories);
        return map;
    }

//    @RequestMapping("/editQuestionPage")
//    @ResponseBody
//    public Map editQuestionPage(HttpSession session,Integer question_id){
//        Question question=questionService.get(question_id);
//        Map map=new HashMap();
//        Category category=categoryService.get(question.getDomain_id());
//        List<Category> categories=categoryService.list();
//        map.put("question",question);
//        map.put("category",category);
//        map.put("categories",categories);
//        return map;
//    }
    @RequestMapping("/editUserPage")
    @ResponseBody
    public Map editUserPage(UserInfo userInfo,HttpSession session){
        UserInfo userInfo1=(UserInfo) session.getAttribute("userInfo");
        Map map=new HashMap();
        if(userInfo1.getId()==userInfo.getId()){
            userInfoService.update(userInfo);
            map.put("msg","success");
            return map;
        }
        map.put("msg","fail");
        return map;
    }
}
/**
 * @Author :wzh
 * @Date :
 * @Description :
 */
