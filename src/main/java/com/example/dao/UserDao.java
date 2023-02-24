package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.awt.print.Book;

@Mapper
public interface UserDao extends BaseMapper<User> {

}
