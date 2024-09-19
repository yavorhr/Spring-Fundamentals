package com.example.cookies.web;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CookieController {
  @GetMapping("/cookies")
  public String cookiesPage(
          @CookieValue(name = "language", defaultValue = "en") String langCookieValue,
          Model model) {

    model.addAttribute("language", langCookieValue);

    return "/cookies";
  }

  @PostMapping("/cookies")
  public String submitCookies(@RequestParam("language") String langFromHTMLForm,
                              HttpServletResponse response) {

    Cookie langCookie = new Cookie("language", langFromHTMLForm);

    response.addCookie(langCookie);

    System.out.println("Preferred user language is: " + langFromHTMLForm);

    return "redirect:/cookies";
  }
}
