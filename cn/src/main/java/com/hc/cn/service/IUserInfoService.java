package com.hc.cn.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.hc.cn.entity.Article;

public interface IUserInfoService {
	 @Secured ({"ROLE_ADMIN"})
     List<Article> getAllUserArticles();
}
