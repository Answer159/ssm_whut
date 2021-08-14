package cn.wmyskxz.controller;

import cn.wmyskxz.pojo.*;
import cn.wmyskxz.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 前台控制器
 *
 * @author: @我没有三颗心脏
 * @create: 2018-04-29-下午 14:45
 */
@Controller
@CrossOrigin
@Api("前台")
public class ForeController {

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

	@Autowired
	ClassImageInfoService classImageInfoService;

	@Autowired
	ClassVideoInfoService classVideoInfoService;
	@Autowired
	QuestionImageInfoService questionImageInfoService;
	@Autowired
	QuestionVideoInfoService questionVideoInfoService;
	@Autowired
	Order_qService order_qService;
	@Autowired
	EvaluationService evaluationService;
	String defaultPath="localhost:8080/Tmall_SSM_war/img/";

	private ObjectMapper mapper=new ObjectMapper();

	@RequestMapping("/cancelCollectClass")
	@ResponseBody
	@ApiOperation(value = "取消收藏课程")
	public Map cancelCollectClass(Integer id,HttpSession session){
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		Map map=new HashMap();
		String collection=userInfo.getCollection_class();
		String sub= id +"&";
		String newCollection=deleteString(collection,sub);
		if("error".equals(newCollection)){
			map.put("msg","没有这个收藏");
			return map;
		}
		userInfo.setCollection_class(newCollection);
		userInfoService.update(userInfo);
		map.put("msg","success");
		return map;
	}
	@RequestMapping("/cancelCollectQuestion")
	@ResponseBody
	@ApiOperation(value = "取消收藏求助")
	public Map cancelCollectQuestion(Integer id,HttpSession session){
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		Map map=new HashMap();
		String collection=userInfo.getCollection_question();
		String sub= id +"&";
		String newCollection=deleteString(collection,sub);
		if("error".equals(newCollection)){
			map.put("msg","没有这个收藏");
			return map;
		}
		userInfo.setCollection_question(newCollection);
		userInfoService.update(userInfo);
		map.put("msg","success");
		return map;
	}
	public String deleteString(String string,String sub){
		int index=string.indexOf(sub);
		int subLength=sub.length();
		String str="";
		if(index!=-1){
			for(int i=0;i<string.length();i++){
				if(i>=index&&i<index+subLength){
					continue;
				}
				str+=string.charAt(i);
			}
			if(str.length() == 0){
				str=null;
			}
			return str;
		}
		return "error";
	}
	@RequestMapping("/checkLogin")
	@ResponseBody
	@ApiOperation(value = "检查登录")
	public Map checkLogin(HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		Map map=new HashMap();
		if (null != userInfo) {
			map.put("msg","success");
			return map;
		}
		map.put("msg","fail");
		return map;
	}

	@RequestMapping("/CollectClass")
	@ResponseBody
	@ApiOperation(value = "收藏课程")
	public Map CollectClass(Integer class_id,HttpSession session){
		 Map map=new HashMap();
		 UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		 String collection=userInfo.getCollection_class();
		 if(collection==null){
		 	collection=class_id+"&";
		 	userInfo.setCollection_class(collection);
		 	userInfoService.update(userInfo);
		 }
		 else{
			 if(isContain(collection,class_id)){
				 map.put("msg","课程已收藏");
				 return map;
			 }
		 	collection+=class_id+"&";
		 	userInfo.setCollection_class(collection);
		 	userInfoService.update(userInfo);
		 }
		 map.put("msg","success");

		return map;
	}

	@RequestMapping("/CollectQuestion")
	@ResponseBody
	@ApiOperation(value = "收藏课程")
	public Map CollectQuestion(Integer question_id,HttpSession session){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		String collection=userInfo.getCollection_question();
		System.out.println(collection);
		if(collection==null){
			collection=question_id+"&";
			userInfo.setCollection_question(collection);
			userInfoService.update(userInfo);
		}
		else{
			if(isContain(collection,question_id)){
				map.put("msg","提问已收藏");
				return map;
			}
			collection=collection+question_id+"&";
			userInfo.setCollection_question(collection);
			userInfoService.update(userInfo);
		}
		map.put("msg","success");
		return map;
	}

	public boolean isContain(String collection,int id){
		String ids[];
		ids=collection.split("&");
		for(String i:ids){
			if(Integer.toString(id).equals(i)){
				return true;
			}
		}
		return false;
	}
	//last:6-8
	@RequestMapping("/confirm")
	@ResponseBody
	@ApiOperation(value = "确认订单，这一步由发布者来做")
	public Map confirm(@RequestParam("order_id") Integer order_id,
					   Double price,
					   Double suggestTime){
		Order_ order_=orderService.get(order_id);

		order_.setOrder_status(Order_Service.waitConfirm);
		order_.setPrice(price);
		order_.setSuggestTime(suggestTime);

		orderService.update(order_);

		Map map=new HashMap();
		map.put("order_",order_);
		map.put("buyer",userInfoService.get(order_.getBuyer_id()));
		map.put("seller",userInfoService.get(order_.getSeller_id()));
		map.put("classInfo",classInfoService.get(order_.getClass_id()));

		return map;
	}

	//last:6-16
	@RequestMapping("/confirm_q")
	@ResponseBody
	@ApiOperation(value = "确认提问订单，这一步由发布者来做")
	public Map confirm_q(@RequestParam("order_q_id") Integer order_q_id,
						 Double price,
						 Double suggestTime){
		Order_q order_q=order_qService.get(order_q_id);

		order_q.setOrder_status(Order_qService.waitConfirm);
		order_q.setPrice(price);
		order_q.setSuggestTime(suggestTime);

		order_qService.update(order_q);

		Map map=new HashMap();
		map.put("order_q",order_q);
		map.put("buyer",userInfoService.get(order_q.getBuyer_id()));
		map.put("seller",userInfoService.get(order_q.getSeller_id()));
		map.put("question",questionService.get(order_q.getQuestion_id()));

		return map;
	}


	//6.8 wzh新增
	@RequestMapping("/deleteQuestion")
	@ResponseBody
	@ApiOperation(value = "删除提问")
	public Map deleteQuestion(HttpSession session,Integer id){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		Question question=questionService.get(id);
		if(question.getUse_id().equals(userInfo.getId())){
			List<Comment> comments=commentService.listByQuestion(id);
			for(Comment comment:comments){
				commentService.delete(comment.getId());
			}
			questionService.delete(id);
			map.put("msg","success");
			return map;
		}
		map.put("msg","fail");
		return map;

	}

	//6.8  wzh新增
	@RequestMapping("/deleteClass")
	@ResponseBody
	@ApiOperation(value = "删除课程")
	public Map deleteClass(HttpSession session,@RequestParam("id") Integer id){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		ClassInfo classInfo=classInfoService.get(id);
		if(classInfo.getUse_id().equals(userInfo.getId())){
			List<Evaluation> evaluations=evaluationService.listByClass(classInfo.getUse_id());
			for(Evaluation evaluation:evaluations){
				evaluationService.delete(evaluation.getId());
			}
			classInfoService.delete(id);
			map.put("msg","success");
			return map;
		}
		map.put("msg","fail");
		return map;

	}
	//6.10 wzh新增
	@RequestMapping("/deleteImage")
	@ResponseBody
	@ApiOperation(value = "删除图片，flag=0表示删除课程的，等于1表示删除提问的")
	public Map deleteImage(HttpSession session,Integer id,Integer flag){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("UserInfo");
		if(flag==0){
			classImageInfoService.delete(id);
			List<ClassImageInfo> classImageInfos=classImageInfoService.list(userInfo.getId());
			map.put("classImageInfos",classImageInfos);
		}
		else{
			questionImageInfoService.delete(id);
			List<QuestionImageInfo> questionImageInfos=questionImageInfoService.list(userInfo.getId());
			map.put("questionImageInfos",questionImageInfos);
		}
		return map;
	}

	//6.10 wzh 新增
	@RequestMapping("/deleteVideo")
	@ResponseBody
	@ApiOperation(value = "删除视频，flag=0表示删除课程的，等于1表示删除提问的")
	public Map deleteVideo(HttpSession session,Integer id,Integer flag){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("UserInfo");
		if(flag==0){
			classVideoInfoService.delete(id);
			List<ClassVideoInfo> classImageInfos=classVideoInfoService.list(userInfo.getId());
			map.put("classVideoInfos",classImageInfos);
		}
		else{
			questionVideoInfoService.delete(id);
			List<QuestionVideoInfo> questionImageInfos=questionVideoInfoService.list(userInfo.getId());
			map.put("questionVideoInfos",questionImageInfos);
		}
		return map;
	}

	//last:6-16
	@RequestMapping("/deleteOrder")
	@ResponseBody
	@ApiOperation(value = "删除订单")
	public Map deleteOrder(@RequestParam("order_id") Integer order_id,HttpSession session){
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		Map map=new HashMap();
		orderService.delete(order_id,userInfo.getId());
		map.put("msg","success");
		return map;
	}

	//last:6-16
	@RequestMapping("/deleteOrder_q")
	@ResponseBody
	@ApiOperation(value = "删除提问订单")
	public Map deleteOrder_q(@RequestParam("order_q_id") Integer order_q_id,HttpSession session){
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		Map map=new HashMap();
		order_qService.delete(order_q_id,userInfo.getId());
		map.put("msg","success");
		return map;
	}
	@RequestMapping("/editQuestionPage")
	@ResponseBody
	@ApiOperation(value = "修改提问页面")
	public Map editQuestionPage(HttpSession session,Integer question_id,
								HttpServletRequest request){
		Question question=questionService.get(question_id);
		Map map=new HashMap();
		map.put("questionInfo",question_id);
		Category category=categoryService.get(question.getDomain_id());
		map.put("category",category);
		List<Category> categories=categoryService.list();
		map.put("categories",categories);
		List<QuestionImageInfo> questionImageInfos=questionImageInfoService.list(question_id);
		List<String> imgPath=new ArrayList<>();
		String filePath;
		filePath=defaultPath+"questionImage/";
//		filePath = request.getSession().getServletContext()
//				.getRealPath("img/questionImage/");
//		String path="D:\\SdData\\img\\questionImage\\";
		for(QuestionImageInfo questionImageInfo:questionImageInfos){
			imgPath.add(filePath+question_id+"/"+questionImageInfo.getId()+".jpg");
		}
		map.put("imgPath",imgPath);
		return map;
	}
	@RequestMapping("/editClassPage")
	@ResponseBody
	@ApiOperation(value = "修改课程页面")
	public Map editClassPage(HttpSession session,Integer class_id,
							 HttpServletRequest request){
		ClassInfo classInfo=classInfoService.get(class_id);
		Map map=new HashMap();
		map.put("classInfo",classInfo);
		Category category=categoryService.get(classInfo.getDomain_id());
		map.put("category",category);
		List<Category> categories=categoryService.list();
		map.put("categories",categories);
		List<ClassImageInfo> classImageInfos=classImageInfoService.list(class_id);
		List<String> imgPath=new ArrayList<>();
		String filePath;
		filePath=defaultPath+"classImage/";
//		filePath = request.getSession().getServletContext()
//				.getRealPath("img/classImage/");
//		String path="D:\\SdData\\img\\classImage\\";
		for(ClassImageInfo classImageInfo:classImageInfos){
			imgPath.add(filePath+class_id+"/"+classImageInfo.getId()+".jpg");
		}
		map.put("imgPath",imgPath);
		return map;
	}
	@RequestMapping("/editClass")
	@ResponseBody
	@ApiOperation(value = "修改课程")
	public Integer editClass(HttpSession session,@RequestBody ClassInfo classInfo){
		classInfoService.Update(classInfo);

		return classInfo.getId();
	}

	@RequestMapping("/editQuestion")
	@ResponseBody
	@ApiOperation(value = "修改提问")
	public Integer editQuestion(HttpSession session,Question question){
		questionService.update(question);

		return question.getId();
	}

	@RequestMapping("/editUser")
	@ResponseBody
	@ApiOperation(value = "修改用户信息")
	public Integer editUser(HttpSession session,UserInfo userInfo){
		userInfoService.update(userInfo);

		return userInfo.getId();
	}

	//last:6-8
	@RequestMapping("/finish")
	@ResponseBody
	@ApiOperation(value = "完成订单，这一步由购买者来做")
	public Map finish(@RequestParam("order_id") Integer order_id){
		Order_ order_=orderService.get(order_id);

		order_.setOrder_status(Order_Service.finish);

		orderService.update(order_);

		Map map=new HashMap();
		map.put("order_",order_);
		map.put("buyer",userInfoService.get(order_.getBuyer_id()));
		map.put("seller",userInfoService.get(order_.getSeller_id()));
		map.put("classInfo",classInfoService.get(order_.getClass_id()));

		return map;
	}



	//last:6-16
	@RequestMapping("/finish_q")
	@ResponseBody
	@ApiOperation(value = "完成提问订单，这一步由购买者来做")
	public Map finish_q(@RequestParam("order_q_id") Integer order_q_id){
		Order_q order_q=order_qService.get(order_q_id);

		order_q.setOrder_status(Order_qService.finish);

		order_qService.update(order_q);

		Map map=new HashMap();
		map.put("order_q",order_q);
		map.put("buyer",userInfoService.get(order_q.getBuyer_id()));
		map.put("seller",userInfoService.get(order_q.getSeller_id()));
		map.put("question",questionService.get(order_q.getQuestion_id()));

		return map;
	}

	@RequestMapping("/GetUser")
	@ResponseBody
	@ApiOperation(value = "获得用户信息")
	public Map GetUser(HttpSession session){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		System.out.println("getuser:"+session.getServletContext());
		if(userInfo==null){
			map.put("msg","fail");
			return map;
		}
		map.put("msg","success");
		map.put("userInfo",userInfo);
		return map;
	}


	@RequestMapping("/home")
	@ResponseBody
	@ApiOperation(value = "主页内容")
	public Map home(HttpServletRequest request) {
		List<Category> categories = categoryService.list();
		//classInfoService.fill(categories);
		//classInfoService.fillByRow(categories);
		List<Referal_Link> links = referalLinkService.listAll();
		List<ClassInfo> classInfos=classInfoService.list();
		List<ClassInfo> classInfos1=new ArrayList<>();
		List<UserInfo> userInfos=userInfoService.list();
		List<UserInfo> userInfos1=new ArrayList<>();
		List<List<String>>imgPath=new ArrayList<>();
		String filePath;
		filePath=defaultPath+"classImage/";
//		filePath = request.getSession().getServletContext()
//				.getRealPath("img/classImage/");
//		String path="D:\\SdData\\img\\classImage\\";
		int count=0;
		for(ClassInfo classInfo:classInfos){
			if(count>=10){
				break;
			}
			classInfos1.add(classInfo);
			count++;
			List<ClassImageInfo> classImageInfos=classImageInfoService.list(classInfo.getId());
			List<String> imgs=new ArrayList<>();
			for(ClassImageInfo classImageInfo:classImageInfos){
				imgs.add(filePath+classInfo.getId()+"/"+classImageInfo.getId()+".jpg");
			}
			imgPath.add(imgs);
		}
		count=0;
		for(UserInfo userInfo:userInfos){
			if(count>=10){
				break;
			}
			userInfos1.add(userInfo);
			count++;
		}

		Map map=new HashMap();
		map.put("categories",categories);
		map.put("links",links);
		map.put("classInfos",classInfos1);
		map.put("userInfos",userInfos1);
		map.put("imgPath",imgPath);

		return map;
	}

	//last:6-7
	@RequestMapping("/login")
	@ResponseBody
	@ApiOperation(value = "登录")
	public Map login(@RequestParam("name") String account, @RequestParam("password") String password, HttpSession session) {
		UserInfo userInfo = userInfoService.get(account, password);
		Map map=new HashMap();
		if (null == userInfo) {
			map.put("msg","fail");
			return map;
		}
		map.put("msg","success");
		session.setAttribute("userInfo", userInfo);
		map.put("userInfo",userInfo);
		return map;
	}

	//last:6-7
	@RequestMapping("/logout")
	@ResponseBody
	@ApiOperation(value = "退出登录")
	public Map logout(HttpSession session) {
		session.removeAttribute("userInfo");
		Map map=new HashMap();
		map.put("msg","success");
		return map;
	}
	@RequestMapping("/likeEvaluation")
	@ResponseBody
	@ApiOperation(value = "给评价点赞")
	public Map likeEvaluation(HttpSession session,@RequestParam("evaluation_id") Integer evaluation_id){
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		Map map=new HashMap();
		if(userInfo!=null){
			Evaluation evaluation=evaluationService.get(evaluation_id);
			int like=evaluation.getLike_();
			evaluation.setLike_(like+1);
			int flag=evaluationService.update(evaluation);
			if(flag==1){
				map.put("msg","success");
				return map;
			}

		}
		map.put("msg","fail");
		return map;
	}

	@RequestMapping("/likeComment")
	@ResponseBody
	@ApiOperation(value = "给评论点赞")
	public Map likeComment(Integer comment_id,HttpSession session)
	{
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		Map map=new HashMap();
		if(userInfo!=null){
			Comment comment= commentService.get(comment_id);
			Integer like_count=comment.getLike_();
			like_count++;
			comment.setLike_(like_count);
			commentService.update(comment);


			map.put("msg","success");
			return map;
		}
		map.put("msg","fail");
		return map;
	}


	@RequestMapping("/listCommentByQuestion")
	@ResponseBody
	@ApiOperation(value = "列出提问的评论")
	public Map listCommentByQuestion(Integer question_id,int pageNum)
	{
		List<Comment> commentList=commentService.listByQuestion(question_id);

		//分页
		Integer pageCount=10;                     //每页最多显示的数据数
		Integer pages=commentList.size()/pageCount;
		Integer lastPage=pageCount;               //尾页默认显示满数据
		if(pages*pageCount!=commentList.size())      //页码修正
		{
			lastPage=commentList.size()%pageCount;   //尾页未满时，显示相应量数据
			pages++;
		}


		Map map=new HashMap();
		map.put("pageSize",pages);                //先记录页码数
		map.put("resultNum",commentList.size());
		Integer pageC=pageCount;                  //默认当前页显示最大量数据
		for(int page=0;page<pages;page++)
		{
			if(page!=pageNum-1){
				continue;
			}
			List<Comment> pageList=new ArrayList<>();
			List<UserInfo> authorList=new ArrayList<>();
			if(page==pages-1)                     //最后一页更改至相应的量
			{
				pageC=lastPage;
			}
			for(int count=0;count<pageC;count++)
			{
				pageList.add(commentList.get(page*pageCount+count));
				authorList.add(userInfoService.get(commentList.get(page*pageCount+count).getUse_id()));
			}
			map.put("pageList"+Integer.toString(page+1),pageList);
			map.put("authorList"+Integer.toString(page+1),authorList);
			break;
		}

		return map;
	}

	@RequestMapping("/listCommentByUser")
	@ResponseBody
	@ApiOperation(value = "列出用户的所有评论")
	public Map listCommentByUser(Integer user_id,int pageNum)
	{
		List<Comment> commentList=commentService.listByUser(user_id);
		Integer commentCount=commentService.getCount(user_id);

		//分页
		Integer pageCount=10;                     //每页最多显示的数据数
		Integer pages=commentList.size()/pageCount;
		Integer lastPage=pageCount;               //尾页默认显示满数据
		if(pages*pageCount!=commentList.size())      //页码修正
		{
			lastPage=commentList.size()%pageCount;   //尾页未满时，显示相应量数据
			pages++;
		}


		Map map=new HashMap();
		map.put("pageSize",pages);                //先记录页码数
		map.put("resultNum",commentList.size());

		Integer pageC=pageCount;                  //默认当前页显示最大量数据
		for(int page=0;page<pages;page++)
		{
			if(page!=pageNum-1){
				continue;
			}
			List<Comment> pageList=new ArrayList<>();
			List<UserInfo> authorList=new ArrayList<>();
			if(page==pages-1)                     //最后一页更改至相应的量
			{
				pageC=lastPage;
			}
			for(int count=0;count<pageC;count++)
			{
				pageList.add(commentList.get(page*pageCount+count));
				authorList.add(userInfoService.get(commentList.get(page*pageCount+count).getUse_id()));
			}
			map.put("pageList"+ (page + 1),pageList);
			map.put("authorList"+ (page + 1),authorList);
			break;
		}

		return map;
	}

	//
	@RequestMapping("/listOrder_ByClient")
	@ResponseBody
	@ApiOperation(value = "列出用户买的所有订单")
	public Map listOrder_ByClient(Integer user_id,int pageNum)
	{
		List<Order_> order_s=orderService.listByBuyer(user_id);

		//分页
		Integer pageCount=10;
		Integer pages=order_s.size()/pageCount;
		Integer lastPage=pageCount;
		if(pages*pageCount!=order_s.size()) {
			lastPage=order_s.size()%pageCount;
			pages++;
		}


		Map map=new HashMap();
		map.put("pageSize",pages);
		map.put("resultNum",order_s.size());
		Integer pageC=pageCount;
		for(int page=0;page<pages;page++)
		{
			if(page!=pageNum-1){
				continue;
			}
			List<Order_> pageList=new ArrayList<>();
			List<UserInfo> buyerList=new ArrayList<>();
			List<UserInfo> sellerList=new ArrayList<>();
			if(page==pages-1) {
				pageC=lastPage;
			}
			for(int count=0;count<pageC;count++)
			{
				pageList.add(order_s.get(page*pageCount+count));
				buyerList.add(userInfoService.get(order_s.get(page*pageCount+count).getBuyer_id()));
				sellerList.add(userInfoService.get(order_s.get(page*pageCount+count).getSeller_id()));
			}
			map.put("pageList"+ (page + 1),pageList);
			map.put("buyerList"+ (page + 1),buyerList);
			map.put("sellerList"+ (page + 1),sellerList);
			break;
		}

		return map;
	}
	@RequestMapping("/listOrder_BySeller")
	@ResponseBody
	@ApiOperation(value = "列出用户卖的所有订单")
	public Map listOrder_BySeller(Integer seller_id,int pageNum)
	{
		List<Order_> order_s=orderService.listBySeller(seller_id);

		//分页
		Integer pageCount=10;
		Integer pages=order_s.size()/pageCount;
		Integer lastPage=pageCount;
		if(pages*pageCount!=order_s.size()) {
			lastPage=order_s.size()%pageCount;
			pages++;
		}


		Map map=new HashMap();
		map.put("pageSize",pages);
		map.put("resultNum",order_s.size());
		Integer pageC=pageCount;
		for(int page=0;page<pages;page++)
		{
			if(page!=pageNum-1){
				continue;
			}
			List<Order_> pageList=new ArrayList<>();
			List<UserInfo> buyerList=new ArrayList<>();
			List<UserInfo> sellerList=new ArrayList<>();
			if(page==pages-1) {
				pageC=lastPage;
			}
			for(int count=0;count<pageC;count++)
			{
				pageList.add(order_s.get(page*pageCount+count));
				buyerList.add(userInfoService.get(order_s.get(page*pageCount+count).getBuyer_id()));
				sellerList.add(userInfoService.get(order_s.get(page*pageCount+count).getSeller_id()));
			}
			map.put("pageList"+ (page + 1),pageList);
			map.put("buyerList"+ (page + 1),buyerList);
			map.put("sellerList"+ (page + 1),sellerList);
			break;
		}

		return map;
	}

	@RequestMapping("/listOrder_qBySeller")
	@ResponseBody
	@ApiOperation(value = "列出用户卖的提问订单")
	public Map listOrder_qBySeller(Integer seller_id,int pageNum)
	{
		List<Order_q> order_q=order_qService.listBySeller(seller_id);

		//分页
		Integer pageCount=10;
		Integer pages=order_q.size()/pageCount;
		Integer lastPage=pageCount;
		if(pages*pageCount!=order_q.size()) {
			lastPage=order_q.size()%pageCount;
			pages++;
		}


		Map map=new HashMap();
		map.put("pageSize",pages);
		map.put("resultNum",order_q.size());
		Integer pageC=pageCount;
		for(int page=0;page<pages;page++)
		{
			if(page!=pageNum-1){
				continue;
			}
			List<Order_q> pageList=new ArrayList<>();
			List<UserInfo> buyerList=new ArrayList<>();
			List<UserInfo> sellerList=new ArrayList<>();
			if(page==pages-1) {
				pageC=lastPage;
			}
			for(int count=0;count<pageC;count++)
			{
				pageList.add(order_q.get(page*pageCount+count));
				buyerList.add(userInfoService.get(order_q.get(page*pageCount+count).getBuyer_id()));
				sellerList.add(userInfoService.get(order_q.get(page*pageCount+count).getSeller_id()));
			}
			map.put("pageList"+ (page + 1),pageList);
			map.put("buyerList"+ (page + 1),buyerList);
			map.put("sellerList"+ (page + 1),sellerList);
			break;
		}

		return map;
	}

	@RequestMapping("/listOrder_qByBuyer")
	@ResponseBody
	@ApiOperation(value = "列出用户买的提问订单")
	public Map listOrder_qByBuyer(Integer user_id,int pageNum)
	{
		List<Order_> order_s=orderService.listByBuyer(user_id);

		//分页
		Integer pageCount=10;
		Integer pages=order_s.size()/pageCount;
		Integer lastPage=pageCount;
		if(pages*pageCount!=order_s.size()) {
			lastPage=order_s.size()%pageCount;
			pages++;
		}


		Map map=new HashMap();
		map.put("pageSize",pages);
		map.put("resultNum",order_s.size());
		Integer pageC=pageCount;
		for(int page=0;page<pages;page++)
		{
			if(page!=pageNum-1){
				continue;
			}
			List<Order_> pageList=new ArrayList<>();
			List<UserInfo> buyerList=new ArrayList<>();
			List<UserInfo> sellerList=new ArrayList<>();
			if(page==pages-1) {
				pageC=lastPage;
			}
			for(int count=0;count<pageC;count++)
			{
				pageList.add(order_s.get(page*pageCount+count));
				buyerList.add(userInfoService.get(order_s.get(page*pageCount+count).getBuyer_id()));
				sellerList.add(userInfoService.get(order_s.get(page*pageCount+count).getSeller_id()));
			}
			map.put("pageList"+ (page + 1),pageList);
			map.put("buyerList"+ (page + 1),buyerList);
			map.put("sellerList"+ (page + 1),sellerList);
			break;
		}

		return map;
	}

	@RequestMapping("/listQuestionByKeyWord")
	@ResponseBody
	@ApiOperation(value = "关键词搜索提问")
	public Map listQuestionByKeyWord(String keyword,int pageNum,HttpServletRequest request)
	{
		List<Question> questionList=questionService.search(keyword);
		String filePath;
		filePath=defaultPath+"questionImage/";
//		filePath = request.getSession().getServletContext()
//				.getRealPath("img/questionImage/");
//		String path="D:\\SdData\\img\\questionImage\\";
		//分页
		Integer pageCount=10;
		Integer pages=questionList.size()/pageCount;
		Integer lastPage=pageCount;
		if(pages*pageCount!=questionList.size()) {
			lastPage=questionList.size()%pageCount;
			pages++;
		}


		Map map=new HashMap();
		map.put("pageSize",pages-1);
		map.put("resultNum",questionList.size());
		Integer pageC=pageCount;
		for(int page=0;page<pages;page++)
		{
			if(page!=pageNum-1){
				continue;
			}
			List<Question> pageList=new ArrayList<>();
			List<UserInfo> authorList=new ArrayList<>();
			List<String> imgPath=new ArrayList<>();
			if(page==pages-1) {
				pageC=lastPage;
			}
			for(int count=0;count<pageC;count++)
			{
				Question question=questionList.get(page*pageCount+count);
				pageList.add(question);
				authorList.add(userInfoService.get(question.getUse_id()));
				List<QuestionImageInfo> questionImageInfos=questionImageInfoService.list(question.getId());
				if(questionImageInfos.size()!=0){
					imgPath.add(filePath+question.getId()+"/"+questionImageInfos.get(0).getId()+".jpg");
				}
				else{
					imgPath.add("no picture");
				}

			}
			map.put("pageList"+ (page + 1),pageList);
			map.put("authorList"+ (page + 1),authorList);
			break;
		}

		return map;
	}

	@RequestMapping("/listQuestionByUser")
	@ResponseBody
	@ApiOperation(value = "列出用户发布的所有提问")
	public Map listQuestionByUser(Integer user_id,int pageNum)
	{
		List<Question> questionList=questionService.listByUser(user_id);

		//分页
		Integer pageCount=10;
		Integer pages=questionList.size()/pageCount;
		Integer lastPage=pageCount;
		if(pages*pageCount!=questionList.size()) {
			lastPage=questionList.size()%pageCount;
		}
		pages++;

		Map map=new HashMap();
		map.put("pageSize",pages-1);
		map.put("resultNum",questionList.size());
		Integer pageC=pageCount;
		for(int page=0;page<pages;page++)
		{
			if(page!=pageNum-1){
				continue;
			}
			List<Question> pageList=new ArrayList<>();
			List<UserInfo> authorList=new ArrayList<>();
			if(page==pages-1) {
				pageC=lastPage;
			}
			for(int count=0;count<pageC;count++)
			{
				pageList.add(questionList.get(page*pageCount+count));
				authorList.add(userInfoService.get(questionList.get(page*pageCount+count).getUse_id()));
			}
			map.put("page"+ (page + 1),pageList);
			map.put("authorList"+ (page + 1),authorList);
			break;
		}

		return map;
	}

	@RequestMapping("/markScore")
	@ResponseBody
	@ApiOperation(value = "对订单打分,type=0表示课程订单，等于1表示提问订单")
	public Map markScore(Integer order_id,Integer type,Integer score){
		Map map=new HashMap();
		if(type==0){
			Order_ order_=orderService.get(order_id);
			order_.setScore(score);
			orderService.update(order_);
		}
		else{
			Order_q order_q=order_qService.get(order_id);
			order_q.setScore(score);
			order_qService.update(order_q);
		}
		map.put("msg","success");
		return map;
	}

	//last:6-6
	@RequestMapping("/myQuestion")
	@ResponseBody
	@ApiOperation(value = "我的所有提问")
	public Map myQuestion(HttpSession session,HttpServletRequest request){
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		Map map=new HashMap();
		String filePath;
		filePath=defaultPath+"questionImage/";
//		filePath = request.getSession().getServletContext()
//				.getRealPath("img/questionImage/");
//		String path="D:\\SdData\\img\\questionImage\\";
		List<Question> questions=questionService.listByUser(userInfo.getId());
		List<String> imgPath=new ArrayList<>();
		for(Question question:questions){
			List<QuestionImageInfo> questionImageInfos=questionImageInfoService.list(question.getId());
			if(questionImageInfos.size()!=0){
				imgPath.add(filePath+question.getId()+"/"+questionImageInfos.get(0).getId()+".jpg");
			}
			else{
				imgPath.add("no picture");
			}
		}
		map.put("questions",questions);
		map.put("imgPath",imgPath);
		return map;
	}

	//last:6-7
	@RequestMapping("/myClassInfo")
	@ResponseBody
	@ApiOperation(value = "我的所有课程")
	public Map myClassInfo(HttpSession session,HttpServletRequest request) {
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		String filePath;
		filePath=defaultPath+"classImage/";
//		filePath = request.getSession().getServletContext()
//				.getRealPath("img/classImage/");
//		String path="D:\\SdData\\img\\classImage\\";
		List<ClassInfo> classInfos=classInfoService.listByUser(userInfo.getId());
		List<String> imgPath=new ArrayList<>();
		for(ClassInfo classInfo:classInfos){
			List<ClassImageInfo> classImageInfos=classImageInfoService.list(classInfo.getId());
			if(classImageInfos.size()!=0){
				imgPath.add(filePath+classInfo.getId()+"/"+classImageInfos.get(0).getId()+".jpg");
			}
			else{
				imgPath.add("no picture");
			}
		}
		Map map=new HashMap();
		map.put("classInfos",classInfos);
		return map;
	}

//	@RequestMapping("/myOrderSeller")
//	@ResponseBody
//	public Map myOrderSeller(HttpSession session){
//		Map map=new HashMap();
//		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
//		List<UserInfo> buyers=new ArrayList<>();
//		List<UserInfo> sellers=new ArrayList<>();
//		List<Order_> order_s= orderService.listBySeller(userInfo.getId());
//		for(Order_ o:order_s){
//			buyers.add(userInfoService.get(o.getBuyer_id()));
//			sellers.add(userInfoService.get(o.getSeller_id()));
//		}
//		map.put("orders",order_s);
//		map.put("buyers",buyers);
//		map.put("sellers",sellers);
//
//		return map;
//	}

//	@RequestMapping("/myOrderBuyer")
//	@ResponseBody
//	public Map myOrderBuyer(HttpSession session){
//		Map map=new HashMap();
//		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
//		List<UserInfo> buyers=new ArrayList<>();
//		List<UserInfo> sellers=new ArrayList<>();
//		List<Order_> order_s= orderService.listByBuyer(userInfo.getId());
//		for(Order_ o:order_s){
//			buyers.add(userInfoService.get(o.getBuyer_id()));
//			sellers.add(userInfoService.get(o.getSeller_id()));
//		}
//		map.put("orders",order_s);
//		map.put("buyers",buyers);
//		map.put("sellers",sellers);
//		return map;
//	}

	//last:6-16
	@RequestMapping("/myOrder")
	@ResponseBody
	@ApiOperation(value = "根据要求列出我的订单，identity可以为buyer和seller或者填null，order_status有四种状态，waitUpdate，waitConfirm，finish，delete")
	public Map myOrder(@RequestParam("order_status") String order_status,
					   @RequestParam("identity") String identity,
					   HttpSession session){
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");

		Map map=new HashMap();
		List<UserInfo> buyers=new ArrayList<>();
		List<UserInfo> sellers=new ArrayList<>();
		List<UserInfo> buyers_q=new ArrayList<>();
		List<UserInfo> sellers_q=new ArrayList<>();
		List<Order_> order_s;
		List<Order_q> order_qs;

		if(order_status=="all"){
			if(identity=="buyer"){
				order_s=orderService.listByBuyer(userInfo.getId());
				order_qs=order_qService.listByBuyer(userInfo.getId());
			}
			else if(identity=="seller"){
				order_s=orderService.listBySeller(userInfo.getId());
				order_qs=order_qService.listBySeller(userInfo.getId());
			}
			else{
				order_s=orderService.listByBuyer(userInfo.getId());
				order_qs=order_qService.listByBuyer(userInfo.getId());
				List<Order_> os=orderService.listBySeller(userInfo.getId());
				List<Order_q> os_q=order_qService.listBySeller(userInfo.getId());
				for(Order_ o:os){
					order_s.add(o);
				}
				for(Order_q q:os_q){
					order_qs.add(q);
				}
			}
		}
		else{
			order_s=orderService.listByStatus(userInfo.getId(),order_status,identity);
			order_qs=order_qService.listByStatus(userInfo.getId(),order_status,identity);
		}

		for(Order_ o:order_s){
			buyers.add(userInfoService.get(o.getBuyer_id()));
			sellers.add(userInfoService.get(o.getSeller_id()));
		}
		for(Order_q o:order_qs){
			buyers_q.add(userInfoService.get(o.getBuyer_id()));
			sellers_q.add(userInfoService.get(o.getSeller_id()));
		}
		map.put("order_s",order_s);
		map.put("order_qs",order_qs);
		map.put("buyers",buyers);
		map.put("sellers",sellers);
		map.put("buyers_qs",buyers_q);
		map.put("sellers_qs",sellers_q);
		return map;
	}
	//6.22 wzh加
	@RequestMapping("/myAllOrder")
	@ResponseBody
	@ApiOperation(value = "我的所有订单")
	public Map MyAllOrder(HttpSession session){
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");

		Map map=new HashMap();
		List<Order_> order_s;
		List<Order_> order;
		List<UserInfo> buyers=new ArrayList<>();
		List<UserInfo> sellers=new ArrayList<>();
		List<ClassInfo> classInfos=new ArrayList<>();
		order_s=orderService.listByBuyer(userInfo.getId());
		order=orderService.listBySeller(userInfo.getId());
		for(Order_ o:order_s){
			order.add(o);
		}
		for(Order_ o:order){
			buyers.add(userInfoService.get(o.getBuyer_id()));
			sellers.add(userInfoService.get(o.getSeller_id()));
			classInfos.add(classInfoService.get(o.getClass_id()));
		}
		map.put("orders",order);
		map.put("buyers",buyers);
		map.put("sellers",sellers);
		map.put("classInfos",classInfos);
		return map;
	}
	//last:6-6
	//6.20 wzh改
	@RequestMapping("/postQuestion")
	@ResponseBody
	@ApiOperation(value = "发布提问")
	public Map postQuestion(@RequestParam("question") String questionString,
							   HttpSession session,
							   HttpServletRequest request,
                               MultipartFile[] pictures,
                               MultipartFile[] videos) throws IOException {
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		Question question=mapper.readValue(questionString,Question.class);

		question.setUse_id(userInfo.getId());
		question.setStatu(1);
		question.setCommentNum(0);
		question.setLike_(0);

		Map map=new HashMap();

		questionService.add(question);
		Integer id=question.getId();
		if(!postImage(request,pictures,id,1)){
			map.put("msg","fail");
			return map;
		}
		if(!postVideo(request,videos,id,1)){
			map.put("msg","fail");
			return map;
		}
		map.put("msg","success");
		return map;
	}


	//last:6-6
	@RequestMapping("/postClassInfo")
	@ResponseBody
	@ApiOperation(value = "发布课程")
	public Map postClassInfo(@RequestParam("classInfo") String classInfoString,
							 HttpSession session,
							 HttpServletRequest request,
                             MultipartFile[] pictures,
                             MultipartFile[] videos) throws IOException {
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		ClassInfo classInfo = mapper.readValue(classInfoString,ClassInfo.class);

		classInfo.setUse_id(userInfo.getId());
		classInfo.setStatu(1);

		classInfoService.add(classInfo);
		Integer id=classInfo.getId();
		Map map=new HashMap();

		if(!postImage(request,pictures,id,0)){
			map.put("msg","fail");
			return map;
		}
		if(!postVideo(request,videos,id,0)){
			map.put("msg","fail");
			return map;
		}
		map.put("msg","success");
		return map;
	}

	//last:6-8
	@RequestMapping("/postComment")
	@ResponseBody
	@ApiOperation(value = "发布评论,没有回复replay_id为-1")
	public Map postComment(HttpSession session,
						   @RequestParam("question_id") Integer question_id,
						   @RequestParam("content") String content,
						   @RequestParam("replay_id") Integer replay_id) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

		Comment comment = new Comment();
		comment.setContent(content);
		comment.setCreateDate(new Date());
		comment.setQuestion_id(question_id);
		comment.setUse_id(userInfo.getId());
		comment.setLike_(0);
		comment.setReplay_id(replay_id);
		if(replay_id!=-1){
			Comment comment1=commentService.get(replay_id);
			int repalyNum=comment1.getReplayNum();
			comment1.setReplayNum(repalyNum+1);
			commentService.update(comment);
		}
		commentService.add(comment);
		Question question=questionService.get(question_id);
		int commentNum=question.getCommentNum();
		question.setCommentNum(commentNum+1);
		questionService.update(question);
		Map map=new HashMap();
		map.put("comment",comment);
		map.put("userInfo",userInfo);
		map.put("question",questionService.get(question_id));

		return map;
	}
	@RequestMapping("/postEvaluation")
	@ResponseBody
	@ApiOperation(value = "发布评价")
	public Map postEvaluation(HttpSession session,
							  @RequestParam("content") String content,
							  @RequestParam("order_id") Integer order_id){
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		Map map=new HashMap();
		Evaluation evaluation=new Evaluation();
		evaluation.setEvaluation(content);
		evaluation.setOrder_id(order_id);
		evaluation.setLike_(0);
		evaluation.setUse_id(userInfo.getId());
		Order_ order_=orderService.get(order_id);
		evaluation.setClass_id(order_.getClass_id());
		int id=evaluationService.add(evaluation);
		map.put("id",id);
		map.put("msg","success");
		return map;
	}
//	//last:6-8
//	@RequestMapping("/postAnswer")
//	@ResponseBody
//	public Map postAnswer(HttpSession session,
//						  @RequestParam("question_id") Integer question_id,
//						  @RequestParam("content") String content){
//		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
//
//		Comment comment = new Comment();
//		comment.setContent(content);
//		comment.setCreateDate(new Date());
//		comment.setQuestion_id(question_id);
//		comment.setUse_id(userInfo.getId());
//		comment.setClass_id(-1);
//		commentService.add(comment);
//
//		Map map=new HashMap();
//		map.put("comment",comment);
//		map.put("userInfo",userInfo);
//		map.put("question",questionService.get(question_id));
//
//		return map;
//	}

	public boolean postImage(HttpServletRequest request, MultipartFile[] pictures, int class_id, int type){
		String filePath;
		if(type==0){
			filePath=defaultPath+"classImage/"+class_id;
//			filePath = request.getSession().getServletContext()
//					.getRealPath("img/classImage/" + class_id);
//			filePath="D:\\SdData\\img\\classImage\\"+class_id;
		}
		else{
			filePath=defaultPath+"questionImage/"+class_id;
//			filePath = request.getSession().getServletContext()
//					.getRealPath("img/questionImage/" + class_id);
//			filePath="D:\\SdData\\img\\questionImage\\"+class_id;
		}
		File dirs=new File(filePath);
		if (!dirs.exists()) {
			dirs.mkdirs();
		}
		for(MultipartFile p:pictures){
			if(type==0){
				ClassImageInfo classImageInfo=new ClassImageInfo();
				classImageInfo.setClassInfo_id(class_id);
				classImageInfo.setStatu(1);
				classImageInfoService.add(classImageInfo);
				int graph_id=classImageInfo.getId();
				String fileName = graph_id + ".jpg";
				File uploadPicture = new File(filePath, fileName);
				if(uploadPicture.exists()){
					uploadPicture.delete();
				}
				try{
					uploadPicture.createNewFile();
				}
				catch (IOException e){
					e.printStackTrace();
				}
				try {
					p.transferTo(uploadPicture);
				} catch (Exception e) {
					return false;
				}
			}
			else{
				QuestionImageInfo questionImageInfo=new QuestionImageInfo();
				questionImageInfo.setQuestion_id(class_id);
				questionImageInfo.setStatu(1);
				questionImageInfoService.add(questionImageInfo);
				int graph_id=questionImageInfo.getId();
				String fileName = graph_id + ".jpg";
				File uploadPicture = new File(filePath, fileName);
				if(uploadPicture.exists()){
					uploadPicture.delete();
				}
				try{
					uploadPicture.createNewFile();
				}
				catch (IOException e){
					e.printStackTrace();
				}
				try {
					p.transferTo(uploadPicture);
				} catch (Exception e) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean postVideo(HttpServletRequest request,MultipartFile[] videos,int class_id,int type){
		String filePath;
		if(type==0){
			filePath=defaultPath+"classVideo/"+class_id;
//			filePath = request.getSession().getServletContext()
//					.getRealPath("video/classVideo/" + class_id);
//			filePath="D:\\SdData\\img\\classVideo\\"+class_id;
		}
		else{
			filePath=defaultPath+"questionVideo/"+class_id;
//			filePath = request.getSession().getServletContext()
//					.getRealPath("video/questionVideo/" + class_id);
//			filePath="D:\\SdData\\img\\questionImage\\"+class_id;
		}
		File dirs=new File(filePath);
		if (!dirs.exists()) {
			dirs.mkdirs();
		}
		for(MultipartFile p:videos){
			if(type==0){
				ClassVideoInfo classVideoInfo=new ClassVideoInfo();
				classVideoInfo.setClassInfo_id(class_id);
				classVideoInfo.setStatu(1);
				classVideoInfoService.add(classVideoInfo);
				int video_id=classVideoInfo.getId();
				String fileName = video_id + ".mp4";
				File uploadVideo = new File(filePath, fileName);
				if (uploadVideo.exists()) {
					uploadVideo.delete();
				}
				try{
					uploadVideo.createNewFile();
				}
				catch (IOException e){
					e.printStackTrace();
				}
				try {
					p.transferTo(uploadVideo);
				} catch (Exception e) {
					return false;
				}
			}
			else{
				QuestionVideoInfo questionVideoInfo=new QuestionVideoInfo();
				questionVideoInfo.setQuestion_id(class_id);
				questionVideoInfo.setStatu(1);
				questionVideoInfoService.add(questionVideoInfo);
				int video_id=questionVideoInfo.getId();
				String fileName = video_id + ".mp4";
				File uploadVideo = new File(filePath, fileName);
				if (uploadVideo.exists()) {
					uploadVideo.delete();

				}
				try{
					uploadVideo.createNewFile();
				}
				catch (IOException e){
					e.printStackTrace();
				}
				try {
					p.transferTo(uploadVideo);
				} catch (Exception e) {
					return false;
				}
			}

		}
		return true;
	}

	//last:6-8
	@RequestMapping("/register")
	@ResponseBody
	@ApiOperation(value = "注册")
	public Map register(HttpServletRequest request,
						@RequestParam("userInfo") String userInfo1,
						MultipartFile picture) throws IOException {
		UserInfo userInfo=mapper.readValue(userInfo1,UserInfo.class);
		boolean exist=userInfoService.isExist(userInfo.getAccount());
		if(exist){
			Map map1=new HashMap();
			String msg1="用户名已被占用，不能使用";
			map1.put("msg",msg1);
			return map1;
		}
		userInfo.setGraghId(0);
		userInfo.setCollection_question(null);
		userInfo.setCollection_class(null);
		userInfoService.add(userInfo);
		Integer id=userInfo.getId();
		String filePath;
		filePath=defaultPath+"userImage/"+id;
//		filePath = request.getSession().getServletContext()
//				.getRealPath("img/userImage/" + id);
//		String filePath="D:\\SdData\\img\\userImage\\"+id;
		String fileName="0.jpg";
		File dirs=new File(filePath);

		if(dirs.exists()){
			dirs.delete();
		}
		dirs.mkdirs();
		File uploadPicture=new File(filePath,fileName);
		try{
			uploadPicture.createNewFile();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		Map map2=new HashMap();
		try{
			picture.transferTo(uploadPicture);
		}catch (Exception e){
			e.printStackTrace();
			map2.put("msg","头像上传失败");
			return map2;
		}
		map2.put("msg","注册成功");
		return map2;

	}


	//last:6-6
//	@RequestMapping("/searchQuestion")
//	@ResponseBody
//	public Map searchQuestion(@RequestParam("keyword") String keyword){
//		List<Question> questions=questionService.search(keyword);
//		Map map=new HashMap();
//		map.put("questions",questions);
//
//		return map;
//	}

	//last:6-16
	@RequestMapping("/showUserInfo")
	@ResponseBody
	@ApiOperation(value = "得到用户信息")
	public Map showUserInfo(HttpSession session){
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		Map map=new HashMap();
		map.put("userInfo",userInfo);
		return map;
	}

	@RequestMapping("/showClassCollection")
	@ResponseBody
	@ApiOperation(value = "显示收藏的课程")
	public Map showClassCollection(HttpSession session){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		String class_ids[]=new String[100];
		if(userInfo.getCollection_class()==null){
			map.put("msg","无收藏");
			return map;
		}
		class_ids=userInfo.getCollection_class().split("&");
		int length=class_ids.length;
		List<ClassInfo> classInfos=new ArrayList<>();
		for(int i=0;i<length;i++){
			int id= Integer.parseInt(class_ids[i]);
			classInfos.add(classInfoService.get(id));
		}
		map.put("classInfos",classInfos);
		return map;
	}

	@RequestMapping("/showQuestionCollection")
	@ResponseBody
	@ApiOperation(value = "显示收藏的提问")
	public Map showQuestionCollection(HttpSession session){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		String question_ids[];
		if(userInfo.getCollection_question()==null){
			map.put("msg","无收藏");
			return map;
		}
		question_ids=userInfo.getCollection_question().split("&");
		int length=question_ids.length;
		List<Question> questions=new ArrayList<>();
		for(int i=0;i<length;i++){
			int id= Integer.parseInt(question_ids[i]);
			questions.add(questionService.get(id));
		}
		map.put("questions",questions);
		return map;
	}

	//last:6-16
	@RequestMapping("/showOrder_q")
	@ResponseBody
	@ApiOperation(value = "显示所选提问订单")
	public Map showOrder_q(@RequestParam("order_q_id") Integer order_q_id){
		Order_q order_q=order_qService.get(order_q_id);

		Map map=new HashMap();
		map.put("order_q",order_q);
		map.put("buyer",userInfoService.get(order_q.getBuyer_id()));
		map.put("seller",userInfoService.get(order_q.getSeller_id()));
		map.put("question",questionService.get(order_q.getQuestion_id()));

		return map;
	}

	//last:6-7
	@RequestMapping("/showClassInfo")
	@ResponseBody
	@ApiOperation(value = "显示课程")
	public Map showClassInfo(@RequestParam("classInfo_id") Integer classInfo_id,HttpServletRequest request) {
		ClassInfo classInfo = classInfoService.get(classInfo_id);
		List<Evaluation> evaluations = evaluationService.listByClass(classInfo_id);
		List<UserInfo> evaluationUsers=new ArrayList<>();
		for(Evaluation evaluation:evaluations){
			evaluationUsers.add(userInfoService.get(evaluation.getUse_id()));
		}
		List<ClassImageInfo> classImageInfos=classImageInfoService.list(classInfo_id);
		String filePath;
		filePath=defaultPath+"classImage/"+classInfo_id+"/";
//		filePath = request.getSession().getServletContext()
//				.getRealPath("img/classImage/"+classInfo_id+"/");
//		String path="D:\\SdData\\img\\classImage\\";
//		path+=classInfo_id+"\\";
		Category category=categoryService.get(classInfo.getDomain_id());
		UserInfo user=userInfoService.get(classInfo.getUse_id());
		List<String> imgPath=new ArrayList<>();
		for(ClassImageInfo classImageInfo:classImageInfos){
			imgPath.add(filePath+classImageInfo.getId()+".jpg");
		}

		Map map=new HashMap();
		map.put("classInfo",classInfo);
		map.put("evaluations",evaluations);
		map.put("category",category);
		map.put("user",user);
		map.put("evaluationUsers",evaluationUsers);
		map.put("imgPath",imgPath);

		return map;
	}
	//last:6-8
	@RequestMapping("/showOrder")
	@ResponseBody
	@ApiOperation(value = "显示所选订单")
	public Map showOrder(@RequestParam("order_id") Integer order_id,HttpSession session){
		Order_ order_=orderService.get(order_id);
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		if(userInfo.getId().equals(order_.getBuyer_id())){
			map.put("msg","buyer");
		}
		else if(userInfo.getId().equals(order_.getSeller_id())){
			map.put("msg","seller");
		}
		map.put("order_",order_);
		map.put("buyer",userInfoService.get(order_.getBuyer_id()));
		map.put("seller",userInfoService.get(order_.getSeller_id()));
		map.put("classInfo",classInfoService.get(order_.getClass_id()));

		return map;
	}

	//last:6-6
	//详细
	@RequestMapping("/showQuestion")
	@ResponseBody
	@ApiOperation(value = "显示提问")
	public Map showQuestion(@RequestParam("question_id")Integer QuestionId,HttpServletRequest request){
		Question question=questionService.get(QuestionId);
		Category category=categoryService.get(question.getDomain_id());
		List<Comment> comments=commentService.listByQuestion(question.getId());
		List<Comment> comments1=new ArrayList<>();
		UserInfo userInfo=userInfoService.get(question.getUse_id());
		List<UserInfo> commentUser=new ArrayList<>();
		int replay_id;
		for(Comment comment:comments){
			commentUser.add(userInfoService.get(comment.getUse_id()));
			replay_id=comment.getReplay_id();
			if(replay_id!=-1){
				Comment comment1=commentService.get(replay_id);
				UserInfo userInfo1=userInfoService.get(comment1.getUse_id());
				String name=userInfo1.getUsername();
				String content=comment.getContent();
				comment.setContent("@"+name+"  "+content);
				comments1.add(comment);
				continue;
			}
			comments1.add(comment);
		}
		List<QuestionImageInfo> questionImageInfos=questionImageInfoService.list(QuestionId);
		String filePath;
		filePath=defaultPath+"questionImage/"+QuestionId+"/";
//		filePath = request.getSession().getServletContext()
//				.getRealPath("img/questionImage/"+QuestionId+"/");
//		String path="D:\\SdData\\img\\questionImage\\";
//		path+=QuestionId+"\\";
		List<String> imgPath=new ArrayList<>();
		for(QuestionImageInfo questionImageInfo:questionImageInfos){
			imgPath.add(filePath+questionImageInfo.getId()+".jpg");
		}
		Map map=new HashMap();
		map.put("question",question);
		map.put("category",category);
		map.put("comments",comments1);
		map.put("userInfo",userInfo);
		map.put("commentUsers",commentUser);
		map.put("imgPath",imgPath);
		return map;

	}

	@RequestMapping("/sortQuestion")
	@ResponseBody
	@ApiOperation(value = "求助排序")
	public Map sortQuestion(@RequestParam("sort") String sort,
							 @RequestParam("keyword") String keyword,int pageNum,HttpServletRequest request) {
		List<Question> questions = questionService.search(keyword);
		String filePath;
		filePath=defaultPath+"questionImage/";
//		filePath = request.getSession().getServletContext()
//				.getRealPath("img/questionImage/");
//		String path="D:\\SdData\\img\\questionImage\\";
		Map map=new HashMap();
		int page=questions.size()/10;
		int lastPage=questions.size()%10;
		if (null != sort) {
			switch (sort) {
				case "suggestTime":
					Collections.sort(questions, Comparator.comparing(Question::getSuggestTime));
					break;

				case "price":
					Collections.sort(questions, Comparator.comparing(Question::getPrice));
					break;
			}
		}
		if(lastPage!=0){
			page++;
		}
		for(int i=0;i<page;i++){
			if(i!=pageNum-1){
				continue;
			}
			List<Question> questions1=new ArrayList<>();
			List<String> imgPath=new ArrayList<>();
			List<UserInfo> userInfos=new ArrayList<>();
			int num=10;
			if(i==page-1&&lastPage!=0){
				num=lastPage;
			}
			for(int j=0;j<num;j++){
				Question question=questions.get(i*10+j);
				questions1.add(question);
				userInfos.add(userInfoService.get(question.getUse_id()));
				List<QuestionImageInfo> questionImageInfos=questionImageInfoService.list(question.getId());
				if(questionImageInfos.size()!=0){
					imgPath.add(filePath+question.getId()+"/"+questionImageInfos.get(0).getId()+".jpg");
				}
				else{
					imgPath.add("no picture");
				}

			}
			//classInfoss.add(classInfos1);
			map.put("questions",questions1);
			map.put("pages",page);
			map.put("imgPath",imgPath);
			map.put("userInfos",userInfos);
			break;
		}

		return map;
	}
	//last:6-16
	@RequestMapping("/sortClassInfo")
	@ResponseBody
	@ApiOperation(value = "课程排序")
	public Map sortClassInfo(@RequestParam("sort") String sort,
							 @RequestParam("keyword") String keyword,int pageNum,
							 HttpServletRequest request) {
		List<ClassInfo> classInfos = classInfoService.search(keyword);
		String filePath;
		filePath=defaultPath+"classImage/";
//		filePath = request.getSession().getServletContext()
//				.getRealPath("img/classImage/");
//		String path="D:\\SdData\\img\\classImage\\";
		Map map=new HashMap();
		int page=classInfos.size()/10;
		int lastPage=classInfos.size()%10;
		if (null != sort) {
			switch (sort) {
				case "suggestTime":
					Collections.sort(classInfos, Comparator.comparing(ClassInfo::getSuggestTime));
					break;

				case "price":
					Collections.sort(classInfos, Comparator.comparing(ClassInfo::getPrice));
					break;
			}
		}
		if(lastPage!=0){
			page++;
		}
		for(int i=0;i<page;i++){
			if(i!=pageNum-1){
				continue;
			}
			List<ClassInfo> classInfos1=new ArrayList<>();
			List<String> imgPath=new ArrayList<>();
			List<UserInfo> userInfos=new ArrayList<>();
			int num=10;
			if(i==page-1&&lastPage!=0){
				num=lastPage;
			}
			for(int j=0;j<num;j++){
				ClassInfo classInfo=classInfos.get(i*10+j);
				classInfos1.add(classInfo);
				userInfos.add(userInfoService.get(classInfo.getUse_id()));
				List<ClassImageInfo> classImageInfos=classImageInfoService.list(classInfo.getId());
				if(classImageInfos.size()!=0){
					imgPath.add(filePath+classInfo.getId()+"/"+classImageInfos.get(0).getId()+".jpg");
				}
				else{
					imgPath.add("no picture");
				}
			}
			//classInfoss.add(classInfos1);
			map.put("classInfos",classInfos1);
			map.put("pages",page);
			map.put("imgPath",imgPath);
			map.put("userInfos",userInfos);
			break;
		}

		return map;
	}

	//last:6-7
	@RequestMapping("/searchClassInfo")
	@ResponseBody
	@ApiOperation(value = "根据关键词搜索课程")
	public Map searchClassInfo(@RequestParam("keyword") String keyword,int pageNum,
							   HttpServletRequest request) {
		List<ClassInfo> classInfos = classInfoService.search(keyword);
		Map map=new HashMap();
		//List<List<ClassInfo>> classInfoss=new ArrayList<>();
		int page=classInfos.size()/10;
		int lastPage=classInfos.size()%10;
		if(lastPage!=0){
			page++;
		}
		for(int i=0;i<page;i++){
			if(i!=pageNum-1){
				continue;
			}
			List<ClassInfo> classInfos1=new ArrayList<>();
			List<UserInfo> userInfos=new ArrayList<>();
			List<String> imgPath=new ArrayList<>();
			int num=10;
			if(i==page-1&&lastPage!=0){
				num=lastPage;
			}
			String filePath;
			filePath=defaultPath+"classImage/";
//			filePath = request.getSession().getServletContext()
//					.getRealPath("img/classImage/");
//			String path="D:\\SdData\\img\\classImage\\";
			for(int j=0;j<num;j++){
				ClassInfo classInfo=classInfos.get(i*10+j);
				classInfos1.add(classInfo);
				userInfos.add(userInfoService.get(classInfo.getUse_id()));
				List<ClassImageInfo> classImageInfos=classImageInfoService.list(classInfo.getId());
				if(classImageInfos.size()!=0){
					imgPath.add(filePath+classInfo.getId()+"/"+classImageInfos.get(0).getId()+".jpg");
				}
				else{
					imgPath.add("no picture");
				}

			}
			//classInfoss.add(classInfos1);
			map.put("resultNum",classInfos.size());
			map.put("classInfos",classInfos1);
			map.put("userInfos",userInfos);
			map.put("pages",page);
			map.put("imgPath",imgPath);
			break;
		}
		return map;
	}


	//last:6-6
	@RequestMapping("/sendInfoForPostClassInfo")
	@ResponseBody
	@ApiOperation(value = "发布课程需要的标签")
	public Map sendInfoForPostClassInfo(){
		List<Category> categories=categoryService.list();

		Map map=new HashMap();
		map.put("categories",categories);

		return map;
	}
	//last:6-6
	@RequestMapping("/sendInfoForPostQuestion")
	@ResponseBody
	@ApiOperation(value = "发布提问需要的标签")
	public Map sendInfoForPostQuestion(){
		List<Category> categories=categoryService.list();

		Map map=new HashMap();
		map.put("categories",categories);

		return map;
	}
	//last:6-13
//	@RequestMapping("/sendInfoForEditQuestion")
//	@ResponseBody
//	@ApiOperation(value = "")
//	public Map sendInfoForEditQuestion(){
//		List<Category> categories=categoryService.list();
//
//		Map map=new HashMap();
//		map.put("categories",categories);
//
//		return map;
//	}


	//6.8 wzh新增
	@RequestMapping("/updateUserImage")
	@ResponseBody
	@ApiOperation(value = "更换头像")
	public Map updateUserImage(HttpSession session,MultipartFile picture,
							   HttpServletRequest request){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		Integer id=userInfo.getGraghId();
		String filePath;
		filePath=defaultPath+"userImage/"+userInfo.getId();
//		filePath= request.getSession().getServletContext()
//				.getRealPath("img/userImage/"+userInfo.getId());
//		String filePath = "D:\\SdData\\img\\userImage\\"+userInfo.getId();
		String fileName = id+1 + ".jpg";
		userInfo.setGraghId(id+1);
		File uploadImg=new File(filePath,fileName);


		try{
			uploadImg.createNewFile();
			picture.transferTo(uploadImg);
		}
		catch (IOException ioException){
			ioException.printStackTrace();
			map.put("msg","fail");
			return map;
		}
		map.put("msg","success");
		return map;
	}

	//6.10 wzh新增
	@RequestMapping("/updateImage")
	@ResponseBody
	@ApiOperation(value = "更新图片，flag为0是课程，flag为1是提问")
	public Map updateImage(HttpSession session,
						   Integer flag,
						   HttpServletRequest request,
                           MultipartFile[] pictures,
						   Integer class_id){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		if(flag==0){
			postImage(request,pictures,class_id,0);
			List<ClassImageInfo> classImageInfos=classImageInfoService.list(class_id);
			map.put("classImageInfos",classImageInfos);
		}
		else{
			postImage(request,pictures,class_id,1);
			List<QuestionImageInfo> questionImageInfos=questionImageInfoService.list(class_id);
			map.put("questionImageInfos",questionImageInfos);
		}
		return map;
	}

	@RequestMapping("/updateVideo")
	@ResponseBody
	@ApiOperation(value = "更新视频，flag为0是课程，flag为1是提问")
	public Map updateVideo(HttpSession session,
						   Integer flag,
						   HttpServletRequest request,
                           MultipartFile[] videos,
						   Integer class_id){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		if(flag==0){
			postVideo(request,videos,class_id,0);
			List<ClassVideoInfo> classVideoInfos=classVideoInfoService.list(class_id);
			map.put("classVideoInfos",classVideoInfos);
		}
		else{
			postVideo(request,videos,class_id,1);
			List<QuestionVideoInfo> questionVideoInfos=questionVideoInfoService.list(class_id);
			map.put("questionVideoInfos",questionVideoInfos);
		}
		return map;
	}



	//last:6-8
	@RequestMapping("/want")
	@ResponseBody
	@ApiOperation(value = "对课程有意向")
	public Map want(@RequestParam("classInfo_id") Integer classInfo_id,HttpSession session){
		ClassInfo classInfo=classInfoService.get(classInfo_id);
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");

		Order_ order_=new Order_();
		order_.setOrder_status(Order_Service.waitUpdate);
		order_.setBuyer_id(userInfo.getId());
		order_.setSeller_id(classInfo.getUse_id());
		order_.setClass_id(classInfo_id);
		order_.setPrice(classInfo.getPrice());
		order_.setSuggestTime(classInfo.getSuggestTime());
		order_.setCreateDate(new Date());
		order_.setScore(0);

		orderService.add(order_);

		Map map=new HashMap();
		map.put("order_",order_);
		map.put("buyer",userInfo);
		map.put("seller",userInfoService.get(order_.getSeller_id()));
		map.put("classInfo",classInfoService.get(classInfo_id));

		return map;
	}
	//last:6-16
	@RequestMapping("/want_q")
	@ResponseBody
	@ApiOperation(value = "对提问有意向")
	public Map want_q(@RequestParam("question_id") Integer question_id,HttpSession session){
		Question question=questionService.get(question_id);
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");

		Order_q order_q=new Order_q();
		order_q.setOrder_status(Order_qService.waitUpdate);
		order_q.setBuyer_id(userInfo.getId());
		order_q.setSeller_id(question.getUse_id());
		order_q.setQuestion_id(question_id);
		order_q.setPrice(question.getPrice());
		order_q.setSuggestTime(question.getSuggestTime());
		order_q.setCreateDate(new Date());
		order_q.setScore(0);

		order_qService.add(order_q);

		Map map=new HashMap();
		map.put("order_q",order_q);
		map.put("buyer",userInfo);
		map.put("seller",userInfoService.get(order_q.getSeller_id()));
		map.put("question",questionService.get(question_id));

		return map;
	}

}
