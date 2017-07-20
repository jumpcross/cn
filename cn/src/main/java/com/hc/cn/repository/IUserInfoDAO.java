package com.hc.cn.repository;
import java.util.List;

import com.hc.cn.entity.Article;
import com.hc.cn.entity.User;

public interface IUserInfoDAO {
	User getActiveUser(String userName);
	List<Article> getAllUserArticles();
}