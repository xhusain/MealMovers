package com.mealmovers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {

        Object name = session.getAttribute("currentUserName");

        if (name == null) {
            return "redirect:/login";
        }

        model.addAttribute("username", name);
        return "dashboard";
    }
}
