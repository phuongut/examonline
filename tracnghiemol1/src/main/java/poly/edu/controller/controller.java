package poly.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import poly.edu.dao.MonHocDAO;
import poly.edu.dao.NguoiDungDAO;
import poly.edu.model.MonHoc;
import poly.edu.model.NguoiDung;


@Controller
public class controller {
	@Autowired
    NguoiDung nd;
	
	@Autowired
	MonHocDAO mhdao;
    
    @Autowired
    NguoiDungDAO nddao;
    
    @RequestMapping("/quizls")
    public String quizls() {
    	return "quizls";
    }
    
    @RequestMapping("/quiz")
    public String quiz() {
    	return "quiz";
    }
    
   
    
    @RequestMapping("/index")
    public String index(Model model) {
    	 java.util.List<MonHoc> monHocList = mhdao.findAll();
         model.addAttribute("monHocList", monHocList);
    	return "index";
    }
    
    
    @RequestMapping("/dethi")
    public String dethi() {
    	return "dethi";
    }
    
    @RequestMapping("/dethichitiet")
    public String dethichitiet() {
    	return "dethichitiet";
    }
    
    @RequestMapping("/indexAd")
    public String index1() {
    	return "indexAd";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/dangxuat")
    public String logout( HttpSession session) {
    	session.removeAttribute("tenNguoiDung");
        return "login";
    }
    
    @RequestMapping("/lienhe")
    public String lienhe() {
        return "lienhe";
    }
    
    @RequestMapping("/gioithieu")
    public String about() {
        return "gioithieu";
    }
    
    @RequestMapping("/gopy")
    public String gopy() {
        return "gopy";
    }

    @PostMapping("/login")
    public String session(@RequestParam("email") String email,
                       @RequestParam("matKhau") String matKhau,
                       HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session,
                       Model model) {
        
        NguoiDung user = nddao.findByEmail(email);
         if(user != null && user.getMatKhau().equals(matKhau)) {
        	 session.setAttribute("user", user.getHoTen());
        	 if(user.isAdmin()) {
        	 return "redirect:/indexAd";
        	 }else {
        		 return "redirect:/index"; 
        	 }
        }
        else {
            model.addAttribute("error", "Email hoặc mật khẩu không đúng");
            return "login";
        }
    }
    
    @GetMapping("/dangky")
    public String dangky() {
        return "register";
    }
    
    @PostMapping("/dangky")
    public String processRegistration(@RequestParam String Id,@RequestParam String rematKhau,@RequestParam String sdt,@RequestParam String hoTen, @RequestParam String email, @RequestParam String matKhau, Model model) {
    if(nddao.existsByEmail(email)) {
    	model.addAttribute("error", "Email này đã tồn tại");
        return "register";
    }else {
    	if(nddao.existsById(Id)) {
    		model.addAttribute("error", "Tên người dùng này đã tồn tại");
            return "register";
    	}else {
    	if(matKhau.equals(rematKhau)) {
        NguoiDung newUser = new NguoiDung();
        String combinedId = "ND" + Id;
        newUser.setHoTen(hoTen);
        newUser.setId(combinedId);
        newUser.setEmail(email);
        newUser.setMatKhau(matKhau);
        newUser.setSoDienThoai(sdt);
        nddao.save(newUser);
        return "redirect:/login"; // Chuyển hướng về trang đăng nhập sau khi đăng ký thành công
    	}else {
    		model.addAttribute("error", "Mật khẩu không trùng");
            return "register";
    	}
    }
    }
    }

}
