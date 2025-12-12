package com.mealmovers.controller;

import com.mealmovers.model.OwnerOrderDTO;
import com.mealmovers.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OwnerDashboardController {

    private final OrderService orderService;

    public OwnerDashboardController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/owner/dashboard")
    public String showOwnerDashboard(HttpSession session, Model model) {

        Long ownerId = (Long) session.getAttribute("currentUserId");
        if (ownerId == null) {
            return "redirect:/login";
        }

        List<OwnerOrderDTO> orders = orderService.getOrdersForOwner(ownerId);

        model.addAttribute("orders", orders);
        model.addAttribute("ownerName", session.getAttribute("currentUserName"));

        return "owner_dashboard";
    }
}
