package com.iris.controllers;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.mapping.Selectable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.spel.ast.Selection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.shopping.entity.Category;
import com.vinayak.*;
import com.vinayak.Dao.*;
import com.vinayak.model.*;
@Controller
public class ApplicationController {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String frontpage() {
		return "homepage";
	}
	@RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newCategory(ModelMap model) {
		
		Category category = new Category();
		model.addAttribute("category",category);
		model.addAttribute("btnLabel","Add Category");
		model.addAttribute("frmLabel","Add Category Form");
		return "addcategory";
		
    }
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute Category cat, ModelMap map) {
		if(cat.getCategoryId()==0){
			boolean c = categoryDao.addCategory(cat);
			if (c){
				map.addAttribute("msg","Category Added Succesfully");
				return "homepage";
			} else {
				return "error";
			}
		} else {
			categoryDao.updateCategory(cat);
			map.addAttribute("msg","Category Updated Succesfully");
			return "homepage";
		}
    }
	@RequestMapping(value = { "/viewall" }, method = RequestMethod.GET)
	public ModelAndView listCategory() {
	    List<Category> list = categoryDao.getAllCategories();
	    ModelAndView map = new ModelAndView("viewall");
	    map.addObject("lists", list);
	    return map;
	}
	
	@RequestMapping(value="/deleteCategory/{catId}",method=RequestMethod.GET)
	public String deleteCategory(@PathVariable int catId,ModelMap map){
		try{
			categoryDao.deleteCategory(catId);
			map.addAttribute("msg","Category Deleted Succesfully");
			List<Category> categoryList=categoryDao.getAllCategories();
			map.addAttribute("lists",categoryList);
			return "viewall";
		} catch(Exception e) {
				map.addAttribute("catId",catId);
				return "error";
			}
		}	
	
	@RequestMapping(value="/updateCategory/{catId}",method=RequestMethod.GET)
	public String updateCategoryForm(@PathVariable int catId,ModelMap map){
		Category cObj=categoryDao.getCategory(catId);
		map.addAttribute("category",cObj);
		map.addAttribute("btnLabel","Update Category");
		map.addAttribute("frmLabel","Update Category Form");
		return "addcategory";
	}
	
	@RequestMapping(value="/deleteCategoryAndUpdateProduct/{catId}",method=RequestMethod.GET)
	public String deleteCategoryAndUpdateProduct(@PathVariable int catId,ModelMap map){
		categoryDao.updateDelete(catId);
		List<Category> categoryList=categoryDao.getAllCategories();
		map.addAttribute("lists",categoryList);
		return "viewall";
		
	}
}
