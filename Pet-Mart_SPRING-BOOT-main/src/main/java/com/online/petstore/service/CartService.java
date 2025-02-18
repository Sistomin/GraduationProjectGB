package com.online.petstore.service;

import javax.servlet.http.HttpServletRequest;

import com.online.petstore.model.CartInfo;

public class CartService {

   // Товары в корзине, хранящиеся в сеансе.
   public static CartInfo getCartInSession(HttpServletRequest request) {

      CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");

   
      if (cartInfo == null) {
         cartInfo = new CartInfo();
         
         request.getSession().setAttribute("myCart", cartInfo);
      }

      return cartInfo;
   }

   public static void removeCartInSession(HttpServletRequest request) {
      request.getSession().removeAttribute("myCart");
   }

   public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
      request.getSession().setAttribute("lastOrderedCart", cartInfo);
   }

   public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
      return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
   }
   
}
