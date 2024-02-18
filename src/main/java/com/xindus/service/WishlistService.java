package com.xindus.service;

import java.util.List;

import com.xindus.entity.WishList;

public interface WishlistService {

	List<WishList> getUserWishlist(Long userId);

	WishList addWishlistItem(Long userId, WishList wishlistItem);

	void deleteWishlistItem(Long userId, Long itemId);

}
