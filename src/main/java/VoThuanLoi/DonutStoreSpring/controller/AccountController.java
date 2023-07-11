package VoThuanLoi.DonutStoreSpring.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @GetMapping("/error")
    public String index(){
        return "account/error";
    }
    @GetMapping("/logout")
    public String logoutAccount(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        SecurityContextHolder.clearContext();

        // Delete the JSESSIONID cookie
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/home";
    }
    @GetMapping("/login")
    public String login() {
        return "account/login";
    }
    @PostMapping("/logout")
    public String logout() {
        return "account/logout";
    }
}
