package com.kaishengit.mybatis;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kaishengit.entity.User;

public class MyBatisTest {
	@Test
	public void first() throws Exception{
		//���������ļ�
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		
		//����sqlSessionFactory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//����sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�������ݿ�
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);
		System.out.println(user.getUserName());
		System.out.println(user.getAddress());
		//�ر�sqlSession
		sqlSession.close();
	}
	@Test
	public void findAll() throws Exception{
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userList = sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
		//����
		for(User user : userList) {
			System.out.println(user.getUserName());
			System.out.println(user.getAddress());
		}
		sqlSession.close();
	}	 	
	@Test
	public void save() throws Exception{
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUserName("jim");
		user.setAddress("Ӣ��");
		user.setPassword("111");
		
		sqlSession.insert("com.kaishengit.mapper.UserMapper.save",user);
		//�ύ����insert update delete
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void update() throws Exception{
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",2);
		
		user.setUserName("�Ŵ�");
		user.setAddress("����");
		sqlSession.update("com.kaishengit.mapper.UserMapper.update",user);
		
		
		//�ύ����insert update delete
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void delete() throws Exception{
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("com.kaishengit.mapper.UserMapper.delById",3);
		//�ύ����insert update delete
		sqlSession.commit();
		sqlSession.close();
	}
}
