package com.kaishengit.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	//����
	private static SqlSessionFactory sqlSessionFactory = builderSessionFactory();

	private static SqlSessionFactory builderSessionFactory() {

		try {
			//���������ļ�
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			//����sqlSessionFactory
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			return sqlSessionFactoryBuilder.build(reader);
		} catch (IOException e) {
			throw new RuntimeException("��ȡmyBatis�����ļ��쳣",e);
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
	
	public static SqlSession getSqlSession(){
		return getSqlSessionFactory().openSession();
	}
}
