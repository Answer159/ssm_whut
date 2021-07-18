package cn.wmyskxz.controller;

import cn.wmyskxz.pojo.*;
import cn.wmyskxz.service.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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


	@RequestMapping("/checkLogin")
	@ResponseBody
	public String checkLogin(HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if (null != userInfo) {
			return "success";
		}
		return "fail";
	}

	//last:6-8
	@RequestMapping("/confirm")
	@ResponseBody
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
	public Map deleteClass(HttpSession session,@RequestParam("id") Integer id){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		ClassInfo classInfo=classInfoService.get(id);
		if(classInfo.getUse_id().equals(userInfo.getId())){
			List<Comment> comments=commentService.listByClass(id);
			for(Comment comment:comments){
				commentService.delete(comment.getId());
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
	public Map deleteOrder_q(@RequestParam("order_q_id") Integer order_q_id,HttpSession session){
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		Map map=new HashMap();
		order_qService.delete(order_q_id,userInfo.getId());
		map.put("msg","success");
		return map;
	}

	@RequestMapping("/editClassPage")
	@ResponseBody
	public Map editClassPage(HttpSession session,Integer class_id){
		ClassInfo classInfo=classInfoService.get(class_id);
		Map map=new HashMap();
		map.put("classInfo",classInfo);
		Category category=categoryService.get(classInfo.getDomain_id());
		map.put("category",category);
		List<Category> categories=categoryService.list();
		map.put("categories",categories);
		return map;
	}
	@RequestMapping("/editClass")
	@ResponseBody
	public Integer editClass(HttpSession session,ClassInfo classInfo){
		classInfoService.Update(classInfo);

		return classInfo.getId();
	}

	@RequestMapping("/editQuestion")
	@ResponseBody
	public Integer editQuestion(HttpSession session,Question question){
		questionService.update(question);

		return question.getId();
	}

	@RequestMapping("/editUser")
	@ResponseBody
	public Integer editUser(HttpSession session,UserInfo userInfo){
		userInfoService.update(userInfo);

		return userInfo.getId();
	}

	//last:6-8
	@RequestMapping("/finish")
	@ResponseBody
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
	public Map home() {
		List<Category> categories = categoryService.list();
		//classInfoService.fill(categories);
		//classInfoService.fillByRow(categories);
		List<Referal_Link> links = referalLinkService.listAll();
		List<ClassInfo> classInfos=classInfoService.listByCategory(1);

		Map map=new HashMap();
		map.put("categories",categories);
		map.put("links",links);
		map.put("classInfos",classInfos);

		return map;
	}

	//last:6-7
	@RequestMapping("/login")
	@ResponseBody
	public Map login(@RequestParam("name") String account, @RequestParam("password") String password, HttpSession session) {
		UserInfo userInfo = userInfoService.get(account, password);
		Map map=new HashMap();
		if (null == userInfo) {
			map.put("msg","fail");
			return map;
		}
		map.put("msg","success");
		System.out.println("login:"+session.getServletContext());
		session.setAttribute("userInfo", userInfo);
		return map;
	}

	//last:6-7
	@RequestMapping("/logout")
	@ResponseBody
	public Map logout(HttpSession session) {
		session.removeAttribute("userInfo");
		Map map=new HashMap();
		map.put("msg","success");
		return map;
	}


	//last:6-6
	@RequestMapping("/myQuestion")
	@ResponseBody
	public Map myQuestion(HttpSession session){
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		Map map=new HashMap();
		List<Question> questions=questionService.listByUser(userInfo.getId());
		map.put("questions",questions);
		return map;
	}

	//last:6-7
	@RequestMapping("/myClassInfo")
	@ResponseBody
	public Map myClassInfo(HttpSession session) {
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		List<ClassInfo> classInfos=classInfoService.listByUser(userInfo.getId());

		Map map=new HashMap();
		map.put("classInfos",classInfos);
		return map;
	}

	@RequestMapping("/myOrderSeller")
	@ResponseBody
	public Map myOrderSeller(HttpSession session){
		Map map=new HashMap();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		List<UserInfo> buyers=new ArrayList<>();
		List<UserInfo> sellers=new ArrayList<>();
		List<Order_> order_s= orderService.listBySeller(userInfo.getId());
		for(Order_ o:order_s){
			buyers.add(userInfoService.get(o.getBuyer_id()));
			sellers.add(userInfoService.get(o.getSeller_id()));
		}
		map.put("orders",order_s);
		map.put("buyers",buyers);
		map.put("sellers",sellers);

		return map;
	}

	@RequestMapping("/myOrderBuyer")
	@ResponseBody
	public Map myOrderBuyer(HttpSession session){
		Map map=new HashMap();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		List<UserInfo> buyers=new ArrayList<>();
		List<UserInfo> sellers=new ArrayList<>();
		List<Order_> order_s= orderService.listByBuyer(userInfo.getId());
		for(Order_ o:order_s){
			buyers.add(userInfoService.get(o.getBuyer_id()));
			sellers.add(userInfoService.get(o.getSeller_id()));
		}
		map.put("orders",order_s);
		map.put("buyers",buyers);
		map.put("sellers",sellers);
		return map;
	}

	//last:6-16
	@RequestMapping("/myOrder")
	@ResponseBody
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
	public Map postQuestion(@RequestParam("category_id") Integer category_id,
							   @RequestParam("title") String title,
							   @RequestParam("price") Double price,
							   @RequestParam("suggestTime") Double suggestTime,
							   @RequestParam("textIntro") String textIntro,
							   @RequestParam("front_knowledge") String front_knowledge,
							@RequestParam("tools") String tools,
							@RequestParam("question_content") String question_content,
							   HttpSession session,
							   HttpServletRequest request,
							   List<MultipartFile> pictures,
							   List<MultipartFile> videos){
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");

		Question question=new Question();
		question.setDomain_id(category_id);
		question.setTitle(title);
		question.setPrice(price);
		question.setSuggestTime(suggestTime);
		question.setTextIntro(textIntro);
		question.setUse_id(userInfo.getId());
		question.setFront_knowledge(front_knowledge);
		question.setTools(tools);
		question.setQuestion_content(question_content);
		question.setStatu(0);

		Map map=new HashMap();

		Integer id=questionService.add(question);

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
	public Map postClassInfo(@RequestParam("category_id") Integer category_id,
							 @RequestParam("title") String title,
							 @RequestParam("price") Double price,
							 @RequestParam("suggestTime") Double suggestTime,
							 @RequestParam("textIntro") String textIntro,
							 @RequestParam("front_knowledge") String front_knowledge,
							 @RequestParam("tools") String tools,
							 @RequestParam("class_content") String class_content,
							 HttpSession session,
							 HttpServletRequest request,
							 List<MultipartFile> pictures,
							 List<MultipartFile> videos){
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");

		ClassInfo classInfo=new ClassInfo();
		classInfo.setDomain_id(category_id);
		classInfo.setTitle(title);
		classInfo.setPrice(price);
		classInfo.setSuggestTime(suggestTime);
		classInfo.setTextIntro(textIntro);
		classInfo.setUse_id(userInfo.getId());
		classInfo.setFront_knowledge(front_knowledge);
		classInfo.setTools(tools);
		classInfo.setClass_content(class_content);
		classInfo.setStatu(0);

		Integer id=classInfoService.add(classInfo);

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
	public Map postComment(HttpSession session,
						   @RequestParam("classInfo_id") Integer classInfo_id,
						   @RequestParam("content") String content) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

		Comment comment = new Comment();
		comment.setContent(content);
		comment.setCreateDate(new Date());
		comment.setClass_id(classInfo_id);
		comment.setUse_id(userInfo.getId());
		comment.setQuestion_id(-1);
		commentService.add(comment);

		Map map=new HashMap();
		map.put("comment",comment);
		map.put("userInfo",userInfo);
		map.put("classInfo",classInfoService.get(classInfo_id));

		return map;
	}

	//last:6-8
	@RequestMapping("/postAnswer")
	@ResponseBody
	public Map postAnswer(HttpSession session,
						  @RequestParam("question_id") Integer question_id,
						  @RequestParam("content") String content){
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

		Comment comment = new Comment();
		comment.setContent(content);
		comment.setCreateDate(new Date());
		comment.setQuestion_id(question_id);
		comment.setUse_id(userInfo.getId());
		comment.setClass_id(-1);
		commentService.add(comment);

		Map map=new HashMap();
		map.put("comment",comment);
		map.put("userInfo",userInfo);
		map.put("question",questionService.get(question_id));

		return map;
	}

	public boolean postImage(HttpServletRequest request, List<MultipartFile> pictures, int user_id, int type){
		String filePath;
		if(type==0){
			filePath = request.getSession().getServletContext()
					.getRealPath("img/classImage" + user_id);
		}
		else{
			filePath = request.getSession().getServletContext()
					.getRealPath("img/questionImage/" + user_id);
		}
		for(MultipartFile p:pictures){
			ClassImageInfo classImageInfo=new ClassImageInfo();
			classImageInfo.setClassInfo_id(user_id);
			classImageInfo.setStatu(0);
			int graph_id=classImageInfoService.add(classImageInfo);
			String fileName = graph_id + ".jpg";
			File uploadPicture = new File(filePath, fileName);
			if (uploadPicture.exists()) {
				uploadPicture.delete();

			}
			uploadPicture.mkdirs();
			try {
				p.transferTo(uploadPicture);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean postVideo(HttpServletRequest request,List<MultipartFile> videos,int user_id,int type){
		String filePath;
		if(type==0){
			filePath = request.getSession().getServletContext()
					.getRealPath("video/classVideo/" + user_id);
		}
		else{
			filePath = request.getSession().getServletContext()
					.getRealPath("video/questionVideo/" + user_id);
		}
		for(MultipartFile p:videos){
			ClassVideoInfo classVideoInfo=new ClassVideoInfo();
			classVideoInfo.setClassInfo_id(user_id);
			classVideoInfo.setStatu(0);
			int video_id=classVideoInfoService.add(classVideoInfo);
			String fileName = video_id + ".mp4";
			File uploadVideo = new File(filePath, fileName);
			if (uploadVideo.exists()) {
				uploadVideo.delete();

			}
			uploadVideo.mkdirs();
			try {
				p.transferTo(uploadVideo);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	//last:6-8
	@RequestMapping("/register")
	@ResponseBody
	public Map register(HttpServletRequest request,
						@RequestParam("userData.account") String account,
						@RequestParam("userData.name") String name,
						@RequestParam("userData.password") String password,
						@RequestParam("userData.selfIntro") String selfIntro,
						@RequestParam("userData.phone") String phone,
						@RequestParam("userData.picture") MultipartFile picture){
		boolean exist=userInfoService.isExist(account);
		if(exist){
			Map map1=new HashMap();
			String msg1="用户名已被占用，不能使用";
			map1.put("msg",msg1);
			map1.put("name",name);
			return map1;
		}
		UserInfo userInfo=new UserInfo();
		userInfo.setAccount(account);
		userInfo.setUsername(name);
		userInfo.setPassword(password);
		userInfo.setSelfIntro(selfIntro);
		userInfo.setPhone(phone);
		userInfo.setGraghId(0);
		Integer id=userInfoService.add(userInfo);

		String filePath=request.getSession().getServletContext().getRealPath("img/userImage/"+id);
		String fileName="0.jpg";

		File uploadPicture=new File(filePath,fileName);
		if(uploadPicture.exists()){
			uploadPicture.delete();
		}

		uploadPicture.mkdirs();
		Map map2=new HashMap();
		try{
			picture.transferTo(uploadPicture);
		}catch (Exception e){
			e.printStackTrace();
			map2.put("msg","头像上传失败");
			return map2;
		}
		map2.put("msg","注册成功");
		map2.put("name",name);
		return map2;

	}

	//last:6-6
	@RequestMapping("/searchQuestion")
	@ResponseBody
	public Map searchQuestion(@RequestParam("keyword") String keyword){
		List<Question> questions=questionService.search(keyword);
		Map map=new HashMap();
		map.put("questions",questions);

		return map;
	}

	//last:6-16
	@RequestMapping("/showUserInfo")
	@ResponseBody
	public Map showUserInfo(HttpSession session){
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		Map map=new HashMap();
		map.put("userInfo",userInfo);
		return map;
	}

	//last:6-16
	@RequestMapping("/showOrder_q")
	@ResponseBody
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
	public Map showClassInfo(@RequestParam("classInfo_id") Integer classInfo_id) {
		ClassInfo classInfo = classInfoService.get(classInfo_id);
		List<Comment> comments = commentService.listByClass(classInfo_id);
		List<UserInfo> commentUsers=new ArrayList<>();
		for(Comment comment:comments){
			commentUsers.add(userInfoService.get(comment.getUse_id()));
		}

		Category category=categoryService.get(classInfo.getDomain_id());
		UserInfo user=userInfoService.get(classInfo.getUse_id());

		Map map=new HashMap();
		map.put("classInfo",classInfo);
		map.put("comments",comments);
		map.put("category",category);
		map.put("user",user);
		map.put("commentUsers",commentUsers);

		return map;
	}
	//last:6-8
	@RequestMapping("/showOrder")
	@ResponseBody
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
	public Map showQuestion(@RequestParam("question_id")Integer QuestionId){
		Question question=questionService.get(QuestionId);
		Category category=categoryService.get(question.getDomain_id());
		List<Comment> comments=commentService.listByQuestion(question.getId());
		UserInfo userInfo=userInfoService.get(question.getUse_id());
		List<UserInfo> commentUser=new ArrayList<>();
		for(Comment comment:comments){
			commentUser.add(userInfoService.get(comment.getUse_id()));
		}
		Map map=new HashMap();
		map.put("question",question);
		map.put("category",category);
		map.put("comments",comments);
		map.put("userInfo",userInfo);
		map.put("commentUsers",commentUser);
		return map;

	}


	//last:6-16
	@RequestMapping("/sortClassInfo")
	@ResponseBody
	public Map sortClassInfo(@RequestParam("sort") String sort,
							 @RequestParam("keyword") String keyword) {
		List<ClassInfo> classInfos = classInfoService.search(keyword);

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
		Map map=new HashMap();
		map.put("classInfos",classInfos);

		return map;
	}

	//last:6-7
	@RequestMapping("/searchClassInfo")
	@ResponseBody
	public Map searchClassInfo(@RequestParam("keyword") String keyword) {
		List<ClassInfo> classInfos = classInfoService.search(keyword);

		Map map=new HashMap();
		map.put("classInfos",classInfos);
		return map;
	}


	//last:6-6
	@RequestMapping("/sendInfoForPostClassInfo")
	@ResponseBody
	public Map sendInfoForPostClassInfo(){
		List<Category> categories=categoryService.list();

		Map map=new HashMap();
		map.put("categories",categories);

		return map;
	}
	//last:6-6
	@RequestMapping("/sendInfoForPostQuestion")
	@ResponseBody
	public Map sendInfoForPostQuestion(){
		List<Category> categories=categoryService.list();

		Map map=new HashMap();
		map.put("categories",categories);

		return map;
	}
	//last:6-13
	@RequestMapping("/sendInfoForEditQuestion")
	@ResponseBody
	public Map sendInfoForEditQuestion(){
		List<Category> categories=categoryService.list();

		Map map=new HashMap();
		map.put("categories",categories);

		return map;
	}


	//6.8 wzh新增
	@RequestMapping("/updateUserImage")
	@ResponseBody
	public Map updateUserImage(HttpSession session,MultipartFile picture,HttpServletRequest request){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		Integer id=userInfo.getGraghId();
		String filePath = request.getSession().getServletContext()
				.getRealPath("img/classImage" + userInfo.getId());
		String fileName = id+1 + ".jpg";
		userInfo.setGraghId(id+1);
		File uploadImg=new File(filePath,fileName);
		uploadImg.mkdirs();
		try{
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
	public Map updateImage(HttpSession session,
						   Integer flag,
						   HttpServletRequest request,
						   List<MultipartFile> pictures){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("UserInfo");
		if(flag==0){
			postImage(request,pictures,userInfo.getId(),0);
			List<ClassImageInfo> classImageInfos=classImageInfoService.list(userInfo.getId());
			map.put("classImageInfos",classImageInfos);
		}
		else{
			postImage(request,pictures,userInfo.getId(),1);
			List<QuestionImageInfo> questionImageInfos=questionImageInfoService.list(userInfo.getId());
			map.put("questionImageInfos",questionImageInfos);
		}
		return map;
	}

	@RequestMapping("/updateVideo")
	@ResponseBody
	public Map updateVideo(HttpSession session,
						   Integer flag,
						   HttpServletRequest request,
						   List<MultipartFile> videos){
		Map map=new HashMap();
		UserInfo userInfo=(UserInfo)session.getAttribute("UserInfo");
		if(flag==0){
			postImage(request,videos,userInfo.getId(),0);
			List<ClassVideoInfo> classVideoInfos=classVideoInfoService.list(userInfo.getId());
			map.put("classVideoInfos",classVideoInfos);
		}
		else{
			postImage(request,videos,userInfo.getId(),1);
			List<QuestionVideoInfo> questionVideoInfos=questionVideoInfoService.list(userInfo.getId());
			map.put("questionVideoInfos",questionVideoInfos);
		}
		return map;
	}



	//last:6-8
	@RequestMapping("/want")
	@ResponseBody
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

		order_qService.add(order_q);

		Map map=new HashMap();
		map.put("order_q",order_q);
		map.put("buyer",userInfo);
		map.put("seller",userInfoService.get(order_q.getSeller_id()));
		map.put("question",questionService.get(question_id));

		return map;
	}

}