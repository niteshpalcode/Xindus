package com.xindus.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xindus.entity.User;
import com.xindus.entity.WishList;
import com.xindus.repository.WishlistRepository;
@Service
public class WishlistServiceImpl implements com.xindus.service.WishlistService {
	@Autowired
	private WishlistRepository wishlistRepository;

	@Override
    public List<WishList> getUserWishlist(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    @Override
    public WishList addWishlistItem(Long userId, WishList WishList) {
    	WishList.setUserId(userId);
        return wishlistRepository.save(WishList);
    }

    @Override
    public void deleteWishlistItem(Long userId, Long itemId) {
    	WishList item = wishlistRepository.findById(itemId).orElse(null);
        if (item != null && item.getUserId().equals(userId)) {
        	wishlistRepository.delete(item);
        } else {
//        	
        }
    }

}
