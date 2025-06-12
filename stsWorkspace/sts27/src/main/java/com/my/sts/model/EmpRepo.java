package com.my.sts.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.my.sts.model.entity.Emp;

@Transactional
public interface EmpRepo extends JpaRepository<Emp, Integer> {
//	https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	// select * from emp where ename=?
	Emp findByEname(String ename);
	// select * from emp where ename=? and sal=?
	Emp findByEnameAndSal(String ename,int sal);
	// select * from emp where ename=? or sal=?
	List<Emp> findByEnameOrSal(String ename,int sal);
	// select * from emp where sal between :begin and :end;
	List<Emp> findBySalBetween(int begin, int end);
	// select * from emp where sal < :sal;
	List<Emp> findBySalLessThan(int sal);
	// select * from emp where sal <= :sal;
	List<Emp> findBySalLessThanEqual(int sal);
	// select * from emp where sal in (0,0,0);
	List<Emp> findBySalIn(int ... arr);
	// select * from emp order by sal ;
	List<Emp> findBySalBetweenOrderBySalAsc(int begin, int end);
	// select * from emp order by sal desc;
	List<Emp> findBySalBetweenOrderBySalDesc(int begin, int end);
	// select * from emp where ename like '';
	List<Emp> findByEnameLike(String ename);
	
}








