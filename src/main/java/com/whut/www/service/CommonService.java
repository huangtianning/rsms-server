/**  
* @Title: CommonService.java  
* @Package com.whut.www.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author HuangTianning
* @date 2019年5月8日  
* @version V1.0  
*/  

package com.whut.www.service;

import java.util.List;

/**  
* @ClassName: CommonService  
* @Description: 公共的service接口,包括CRUD四种操作,加上"获取全部"retrieveAll操作,共五种.
* 				所有service接口都应继承该接口.
* 				若特定的service接口有自己独有的方法,只需自行增加.
* @author HuangTianning  
* @date 2019年5月8日  
*    
*/
public interface CommonService<T,E> {
	/**  
	* @Title: create  
	* @Description: 增加
	* @param t
	* @return  boolean 返回类型
	* @throws：
	*/ 
	public boolean create(T t); 
	/**  
	* @Title: delete  
	* @Description: 删除
	* @param t
	* @return  boolean 返回类型
	* @throws：异常信息
	*/ 
	public boolean delete(T t);
	/**  
	* @Title: update  
	* @Description: 修改
	* @param t
	* @return  boolean 返回类型
	* @throws：异常信息
	*/ 
	public boolean update(T t);
	/**  
	* @Title: retrieve  
	* @Description: 查找(获取)
	* @param e
	* @return  T 返回类型
	* @throws：异常信息
	*/ 
	public T retrieve(E e);
	/**  
	* @Title: retrieveAll  
	* @Description: 查找(获取)全部
	* @param e
	* @return  List<T> 返回类型
	* @throws：异常信息
	*/ 
	public List<T> retrieveAll(E e);
}
