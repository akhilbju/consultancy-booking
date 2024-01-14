package com.akhil.questionservice.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akhil.questionservice.DTO.DateOfBooking;
import com.akhil.questionservice.DTO.Doctor;
import com.akhil.questionservice.DTO.Hospital;
import com.akhil.questionservice.DTO.user;
import com.akhil.questionservice.service.logService;

import jakarta.servlet.http.HttpSession;



@Controller
public class hospitalController {
	
	@Autowired
	private logService service;

    @RequestMapping("/")
    public String page(){
        return "page";
    }
    
    @RequestMapping("/newuser")
    public String newUser() {
    	return "create";
    }
    
    @RequestMapping("login")
    public String loging(@RequestParam("email")String email,@RequestParam("pass")String pass,Model m,HttpSession session) {
    	user user1 = service.log(email, pass);
    	session.setAttribute("user",user1);
    	List<Hospital> hos = service.gethos();
    	m.addAttribute("hospitals",hos);
    	return "home";
    	
    }
    @PostMapping("/create")
    public String create(@ModelAttribute user user1) {
    	service.save(user1);
    	return "page";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "page";
    }
    @RequestMapping("/home")
    public String home(Model m) {
    	List<Hospital> hos = service.gethos();
    	m.addAttribute("hospitals",hos);
    	return "home";
    }
    
    @RequestMapping("/click/{id}")
    public String click(@PathVariable("id")int id,Model m,HttpSession session) {
    	List<Doctor> doctor = service.getdoc(id);
    	m.addAttribute("doctors",doctor);
    	return "hospital";
    }
    
    @RequestMapping("/book/{id}")
    public String book(@PathVariable("id")int id,Model m,HttpSession session) {
    	LocalDate min = LocalDate.now();
    	m.addAttribute("min",min);
    	m.addAttribute("max", min.plusMonths(1));
    	m.addAttribute("id", id);
    	return "booking";
    }
    @RequestMapping("/check/{id}")
    public String check(@PathVariable("id")int id,Model m,@RequestParam("date")LocalDate date,
    		@RequestParam("time")String time,HttpSession session) {
    	
    	user use = (user)session.getAttribute("user");
    	Doctor doctor = service.getDoctor(id);
    	DateOfBooking dob1 = service.getDate(date,time);
    	List<Hospital> hos = service.gethos();
    	if(dob1==null) {
    		DateOfBooking dob = new DateOfBooking(date, time, doctor , use);
    		service.savedob(dob);
    		m.addAttribute("hospitals", hos);
    		m.addAttribute("msg", "success");
    		return "home";
    	}else {
    		m.addAttribute("msg", "error");
    		return "redirect:/book/{id}";
    	}
    		
    }
    @RequestMapping("/history/{id}")
	public String history(HttpSession session,Model m,@PathVariable("id")int id) {
    	user user1 = service.getuser(id);
    	List<DateOfBooking> date =  user1.getDob();
    	m.addAttribute("history",date);
    	session.setAttribute("user", user1);
		return "history";
	}
    @RequestMapping("/edit/{id}")
    public String edit(HttpSession session,Model m) {
    	return "edit";
    }
    
    @RequestMapping("/editProfile")
    public String editProfile(@ModelAttribute user user1,HttpSession session,
    		Model m) {
    	
    	int id = user1.getId();
    	System.out.println(id);
    	user use = service.update(user1);
    	List<Hospital> hos = service.gethos();
    	session.setAttribute("user", use);
    	m.addAttribute("hospitals", hos);
    	return "home";
    }
}
