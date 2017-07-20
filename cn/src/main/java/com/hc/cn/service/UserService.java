package com.hc.cn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.hc.cn.entity.User;
import com.hc.cn.repository.ArticleRepository;
import com.hc.cn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.cn.repository.IUserInfoDAO;
import com.hc.cn.entity.Article;
@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Override
	public List<Article> getAllUserArticles(){
		Iterable<Article> geted = articleRepository.findAll();
		List<Article> list = new ArrayList<>();
		geted.forEach(single ->{list.add(single);});
		return list;
	}

	@Override
	public void register(User user) {
		userRepository.save(user);

	}
}
