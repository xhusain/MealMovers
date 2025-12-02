package com.mealmovers.controller;

import com.mealmovers.model.CartItem;
import com.mealmovers.service.CartService;
import com.mealmovers.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final CartService cartService;
    private final OrderService orderService;

    public OrderController(CartService cartService, OrderService orderService) {
        this.cartService = cartService;
        this.orderService = orderService;
    }

    // Order summary page (B: show summary first)
    @GetMapping("/summary")
    public String orderSummary(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("currentUserId");
        if (userId == null) {
            return "redirect:/login";
        }

        List<CartItem> items = cartService.getCartItems();
        double total = items.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();

        model.addAttribute("cartItems", items);
        model.addAttribute("total", total);
        return "order_summary"; // /WEB-INF/views/order_summary.jsp
    }

    // Pay endpoint - receives method: EASYPAY, JAZZCASH, COD
    @PostMapping("/pay")
    public String pay(@RequestParam("method") String method, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("currentUserId");
        if (userId == null) {
            return "redirect:/login";
        }

        // create order and clear cart (inside service)
        Long orderId = orderService.createOrderFromCart(userId, method);

        // you can pass orderId and method to thank you view if needed
        session.setAttribute("lastOrderId", orderId);
        session.setAttribute("lastPaymentMethod", method);

        return "redirect:/order/thankyou";
    }

    @GetMapping("/thankyou")
    public String thankyouPage(Model model, HttpSession session) {
        Long orderId = (Long) session.getAttribute("lastOrderId");
        String method = (String) session.getAttribute("lastPaymentMethod");

        model.addAttribute("orderId", orderId);
        model.addAttribute("method", method);
        return "thankyou"; // /WEB-INF/views/thankyou.jsp
    }
}
