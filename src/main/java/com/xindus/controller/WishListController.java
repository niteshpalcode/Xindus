package com.xindus.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xindus.entity.User;
import com.xindus.entity.WishList;
import com.xindus.service.WishlistService;
@RestController
@RequestMapping("/api/wishlists")
public class WishListController {

	@Autowired
	private WishlistService wishlistService;
	 @GetMapping
	    public ResponseEntity<List<WishList>> getUserWishlist(@AuthenticationPrincipal Principal principal) {
	        Long userId = Long.parseLong(principal.getName()); 
	        List<WishList> wishlist = wishlistService.getUserWishlist(userId);
	        return ResponseEntity.ok(wishlist);
	    }

	    @PostMapping
	    public ResponseEntity<WishList> addWishlistItem(@AuthenticationPrincipal Principal principal, @RequestBody WishList wishList) {
	        Long userId = Long.parseLong(principal.getName()); 
	        WishList addedItem = wishlistService.addWishlistItem(userId, wishList);
	        return ResponseEntity.status(HttpStatus.CREATED).body(addedItem);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteWishlistItem(@AuthenticationPrincipal Principal principal, @PathVariable("id") Long itemId) {
	        Long userId = Long.parseLong(principal.getName()); 
	        wishlistService.deleteWishlistItem(userId, itemId);
	        return ResponseEntity.noContent().build();
	    }
	
}
