package com.iris.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vinayak.*;
import com.vinayak.Dao.*;
import com.vinayak.DBConfig.*;
import com.vinayak.model.*;


@Controller
public class ProductController {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="addProduct",method=RequestMethod.GET)
	public String getProductForm(ModelMap map){
		map.addAttribute("pObj",new Product());
		map.addAttribute("frmLabel","Add Product Form");
		map.addAttribute("btnLabel","Add Product");
		map.addAttribute("categories",categoryDao.getAllCategories());
		return "addproduct";
	}
	
	@RequestMapping(value="submitProduct",method=RequestMethod.POST)
	public String submitProduct(@ModelAttribute Product pObj,ModelMap map){
		if(pObj.getProductId()==0){
			boolean c = productDao.addProduct(pObj);
			if (c){
				map.addAttribute("msg","Product Added Succesfully");
				return "homepage";
			} else {
				return "error";
			}
		} else {
			productDao.updateProduct(pObj);
			map.addAttribute("msg","Product Updated Succesfully");
			return "homepage";
		}
	}
	@RequestMapping(value="viewProducts",method=RequestMethod.GET)
	public ModelAndView view(){
		List<Product> list = productDao.getAllProducts();
		ModelAndView map = new ModelAndView("viewproduct");
	    map.addObject("products", list);
	    return map;
	}
	@RequestMapping(value="/deleteProduct/{pId}",method=RequestMethod.GET)
	public String deleteProduct(@PathVariable int pId, ModelMap map){
		productDao.deleteProduct(pId);
		map.addAttribute("msg","Product Deleted Succesfully");
		List<Product> productList=productDao.getAllProducts();
		map.addAttribute("products",productList);
		return "viewproduct";
	}
	@RequestMapping(value="/updateProduct/{pId}",method=RequestMethod.GET)
	public String updateProduct(@PathVariable int pId,ModelMap map){
		Product pObj=productDao.getProduct(pId);
		map.addAttribute("pObj",pObj);
		map.addAttribute("btnLabel","Update Product");
		map.addAttribute("frmLabel","Update Product Form");
		map.addAttribute("categories",categoryDao.getAllCategories());
		
		return "addproduct";
	}
}
