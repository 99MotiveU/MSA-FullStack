package com.my.sts.dept.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.my.sts.Sts14Application;
import com.my.sts.dept.model.DeptDao;
import com.my.sts.dept.model.DeptVo;

@Service
public class DeptService {

    private final Sts14Application sts14Application;
	Logger log=LoggerFactory.getLogger(getClass());
	@Autowired
	SqlSessionFactory sqlSessionFactory;

    DeptService(Sts14Application sts14Application) {
        this.sts14Application = sts14Application;
    }
	
	public void getList(Model model) {
		try(
				SqlSession session=sqlSessionFactory.openSession();
				){
			log.debug(session.getMapper(DeptDao.class).selectAll().toString());
			model.addAttribute("list", session.getMapper(DeptDao.class).selectAll());
		}
	}

	@Transactional
	public void addList(DeptVo bean) {
		try(
				SqlSession session=sqlSessionFactory.openSession();
				){
			log.debug("result:"+
			session.getMapper(DeptDao.class).insertOne(bean)
			);
		}
	}

	public DeptVo getList(int deptno) {
		try(
				SqlSession session=sqlSessionFactory.openSession();
				){
			return session.getMapper(DeptDao.class).selectOne(deptno);
		}
	}

	@Transactional
	public void setList(DeptVo bean) {
		try(
				SqlSession session=sqlSessionFactory.openSession();
				){
			session.getMapper(DeptDao.class).updateOne(bean);
		}
	}

	@Transactional
	public boolean rmList(int deptno) {
		try(
				SqlSession session=sqlSessionFactory.openSession();
				){
			return session.getMapper(DeptDao.class).deleteOne(deptno)>0?true:false;
		}
	}
}







