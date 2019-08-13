package com.frontend.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.daos.CategoryDao;
import com.shopping.daos.ProductDao;
import com.shopping.entity.Category;
import com.shopping.entity.Product;

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
		return "ProductForm";
	}
	
	@RequestMapping(value="submitProduct",method=RequestMethod.GET)
	public String submitProduct(@ModelAttribute Product pObj,ModelMap map){
		if(pObj.getProductId()==0){
			productDao.addProduct(pObj);
			map.addAttribute("msg","Product Added Succesfully");
		}
		else {
			productDao.updateProduct(pObj);
			map.addAttribute("msg","Product Updated Succesfully");
		}
		map.addAttribute("products",productDao.getAllProducts());
		return "ViewProducts";
	
		
	}
	@RequestMapping(value="/deleteProduct/{catId}",method=RequestMethod.GET)
	public String deleteProduct(@PathVariable int catId,ModelMap map){
		productDao.deleteProduct(catId);
		map.addAttribute("msg","Category Deleted Succesfully");
		List<Product> productList=productDao.getAllProducts();
		map.addAttribute("products",productList);
		return "ViewProducts";
	
	}
	@RequestMapping(value="viewProducts",method=RequestMethod.GET)
	public String view(ModelMap map)
	{
		map.addAttribute("products",productDao.getAllProducts());
		return "ViewProducts";
	}
	@RequestMapping(value="/updateProduct/{catId}",method=RequestMethod.GET)
	public String updateProductForm(@PathVariable int catId,ModelMap map){
		Product pObj=productDao.getProduct(catId);
		map.addAttribute("cObj",pObj);
		map.addAttribute("btnLabel","Update Product");
		map.addAttribute("frmLabel","Update Product Form");
		
		return "ProductForm";
	
	}
}
