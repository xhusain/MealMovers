package com.mealmovers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {

    Long id = (Long) session.getAttribute("currentUserId");
    String name = (String) session.getAttribute("currentUserName");

    if (id == null || name == null) {
        return "redirect:/login";
    }

    model.addAttribute("username", name);
    model.addAttribute("userId", id);
    return "dashboard";
    }
}
