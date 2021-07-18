package cn.wmyskxz.service;

import cn.wmyskxz.mapper.CategoryMapper;
import cn.wmyskxz.pojo.Category;
import cn.wmyskxz.pojo.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public List<Category> list() {
		CategoryExample example = new CategoryExample();
		List<Category> categories = categoryMapper.selectByExample(example);
		return categories;
	}

	@Override
	public Category get(Integer id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Category category) {
		categoryMapper.updateByPrimaryKey(category);
	}
	@Override
	public String getDomain(Integer id){
		Category category=categoryMapper.selectByPrimaryKey(id);
		return category.getDomain();
	}


}
