package com.kaishengit.mybatis;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.util.MyBatisUtil;

public class UserMapperTest {
	
	private Logger logger = LoggerFactory.getLogger(UserMapperTest.class);
	
	private SqlSession sqlSession;
	private UserMapper userMapper;
	@Before
	public void before() {
		sqlSession = MyBatisUtil.getSqlSession();
		//!!! MyBatis���ݶ����Mapper�ӿڶ�̬�����ɸýӿڵ�ʵ����
		userMapper = sqlSession.getMapper(UserMapper.class);
	}
	@After
	public void after() {
		sqlSession.close();
	}
	@Test
	public void findById() {
		User user = userMapper.findById(1);
		logger.debug("user: {}" ,user);
	
	}
	@Test
	public void findAllLoadDept(){
		List<User> userList = userMapper.findAllLoadDept();
		
		for(User user : userList) {
			logger.debug("{} --> {}", user.getDept(),user.getUserName(),user.getAddress());
		}
	}
	
	@Test
	public void findByUserNameAndPassword(){
		User user = userMapper.findByUserNameAndPassword("tom", "123");
		System.out.println(user.getId());
	}
	@Test
	public void findByMapParam(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", "tom");
		map.put("pwd", "123");
		
		User user = userMapper.findByMapParam(map);
		System.out.println(user.getId());
		
	}
	@Test
	public void searchByNameAndAddress() {
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("name", "tom");
		map.put("address", "����");
		
		List<User> userList = userMapper.searchByNameAndAddress(map);
		for(User user : userList) {
			System.out.println(user.getId());
		}
	}
	@Test
	public void delByIds(){
		List<Integer> idList = Arrays.asList(11,12);
		userMapper.delByIds(idList);
		sqlSession.commit();
		
	}
	@Test
	public void batchSave(){
		List<User> userList = Arrays.asList(new User("jack","����","000",1)
				,new User("nihao","shanghai","000",1));
		userMapper.batchSave(userList);
		sqlSession.commit();
	}
	
	@Test
	public void firstLevelCache() {
		
		User user = userMapper.findById(1);
		User user2 = userMapper.findById(1);
		
		System.out.println(user2.getUserName());
		
		
	}
	@Test
	public void secLeccelCache() {
		
		SqlSession sqlSession1 = MyBatisUtil.getSqlSession();
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		
		User user1 = userMapper1.findById(1);
		System.out.println(user1.getUserName());
		sqlSession1.close();
		
		System.out.println("---------------");
		
		SqlSession sqlSession2 = MyBatisUtil.getSqlSession();
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		
		User user2 = userMapper2.findById(1);
		System.out.println(user2.getUserName());
		sqlSession2.close();
	}
	
}
