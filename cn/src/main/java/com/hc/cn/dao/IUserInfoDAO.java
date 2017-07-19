package com.hc.cn.dao;
import java.util.List;

import com.hc.cn.entity.Article;
import com.hc.cn.entity.UserInfo;
public interface IUserInfoDAO {
	UserInfo getActiveUser(String userName);
	List<Article> getAllUserArticles();
}