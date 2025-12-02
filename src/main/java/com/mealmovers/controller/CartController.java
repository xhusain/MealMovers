package com.mealmovers.controller;

import com.mealmovers.service.CartService;
import com.mealmovers.model.CartItem;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long menuId, @RequestParam int quantity) {
        cartService.addToCart(menuId, quantity);
        return "redirect:/cart/view";
    }

    @GetMapping("/view")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        return "cart";
    }

    @PostMapping("/update")
    public String update(@RequestParam Long cartId, @RequestParam int quantity) {
        cartService.updateQuantity(cartId, quantity);
        return "redirect:/cart/view";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam Long cartId) {
        cartService.removeItem(cartId);
        return "redirect:/cart/view";
    }

@PostMapping("/complete")
public String completeOrder(HttpSession session) {
    return "redirect:/order/summary";
}
}
