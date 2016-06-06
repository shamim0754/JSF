package com.deltagroupbd.ocms.controller;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "index",eager = true)
@RequestScoped
public class IndexController {
   public IndexController() {
      System.out.println("it is printed before any request come since eager = true");
   }
	
   public String getMessage() {
      return "Welcome to delta group ocms 3";
   }
}
