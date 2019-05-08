/**  
* @Title: CommonServiceTest.java  
* @Package com.whut.www.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author HuangTianning
* @date 2019年5月8日  
* @version V1.0  
*/  

package com.whut.www.service;

/**  
* @ClassName: CommonServiceTest  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author htn  
 * @param <T>
 * @param <E>
* @date 2019年5月8日  
*    
*/
public interface CommonServiceTest<T, E> extends CommonService<T, E> {
	/*该接口自己自己独有的方法*/
	public T doSomething(E e);
}
