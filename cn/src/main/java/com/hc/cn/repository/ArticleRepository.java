package com.hc.cn.repository;

/**
 * Created by Charlie on 2017-07-17.
 */

import com.hc.cn.entity.Article;
import com.hc.cn.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {


}