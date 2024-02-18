package com.xindus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xindus.entity.User;
import com.xindus.entity.WishList;

public interface WishlistRepository extends JpaRepository<WishList, Long>{

	   List<WishList> findByUserId(Long userId);
}
