/**  
* @Title: CommonServiceImpTest.java  
* @Package com.whut.www.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author HuangTianning
* @date 2019年5月8日  
* @version V1.0  
*/  

package com.whut.www.service;

import java.util.List;

import com.whut.www.model.User;

/**  
* @ClassName: CommonServiceImpTest  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author htn  
* @date 2019年5月8日  
*    
*/
public class CommonServiceImpTest implements CommonServiceTest<User, Object>{

	/**
	* <p>Title: create</p>  
	* <p>Description: </p>  
	* @param t
	* @return  
	* @see com.whut.www.service.CommonService#create(java.lang.Object)  
	*/
	@Override
	public boolean create(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	* <p>Title: delete</p>  
	* <p>Description: </p>  
	* @param t
	* @return  
	* @see com.whut.www.service.CommonService#delete(java.lang.Object)  
	*/
	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	* <p>Title: update</p>  
	* <p>Description: </p>  
	* @param t
	* @return  
	* @see com.whut.www.service.CommonService#update(java.lang.Object)  
	*/
	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	* <p>Title: retrieve</p>  
	* <p>Description: </p>  
	* @param e
	* @return  
	* @see com.whut.www.service.CommonService#retrieve(java.lang.Object)  
	*/
	@Override
	public User retrieve(Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* <p>Title: retrieveAll</p>  
	* <p>Description: </p>  
	* @param e
	* @return  
	* @see com.whut.www.service.CommonService#retrieveAll(java.lang.Object)  
	*/
	@Override
	public List<User> retrieveAll(Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* <p>Title: doSomething</p>  
	* <p>Description: </p>  
	* @param e
	* @return  
	* @see com.whut.www.service.CommonServiceTest#doSomething(java.lang.Object)  
	*/
	@Override
	public User doSomething(Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
