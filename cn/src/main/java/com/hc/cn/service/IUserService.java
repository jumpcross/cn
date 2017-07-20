package com.hc.cn.service;

import java.util.List;

import com.hc.cn.entity.User;
import org.springframework.security.access.annotation.Secured;

import com.hc.cn.entity.Article;

public interface IUserService {
	 @Secured ({"ROLE_ADMIN"})
     List<Article> getAllUserArticles();
	 void register(User user);
}
