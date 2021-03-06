package com.biz.iolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.iolist.domain.ProductDTO;
import com.biz.iolist.service.ProductService;

@RequestMapping(value="/product")
@Controller
public class ProductController {
	
	@Autowired
	ProductService pdService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("PD_LIST", pdService.getAllList() );
		return "product/product-list";
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(String id, Model model) {
		ProductDTO pdDTO = pdService.findById(id);
		
		model.addAttribute("PD_DTO", pdDTO);
		return "product/product-view";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		
		return "product/product-input";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(ProductDTO pdDTO) {
		int ret = pdService.insert(pdDTO);
		return "redirect:/product/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String id, Model model) {
		ProductDTO pdDTO = pdService.findById(id);
		
		model.addAttribute("PD_DTO", pdDTO);
		
		return "product/product-input";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(ProductDTO pdDTO, Model model) {
		
		int ret = pdService.update(pdDTO);
		
		return "redirect:/product/view?id=" + pdDTO.getP_code();
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String id) {
		int ret = pdService.delete(id);
		return "redirect:/product/list";
	}
	
}