package sky.skyapp.view.interceptor;

import java.lang.reflect.Method;

import jc.sky.core.plugin.DisplayStartInterceptor;
import jc.sky.modules.log.L;

/**
 * @创建人 sky
 * @创建时间 16/8/27 下午1:45
 * @类描述
 */
public class MyProStartInterceptor implements DisplayStartInterceptor {

	/**
	 * 拦截器
	 * 
	 * @param s
	 *            实现类路径
	 * @param aClass
	 *            接口Class
	 * @param method
	 *            方法
	 * @param i
	 * @Interceptor 方法注解标记
	 * @param s1
	 *            跳转方向
	 * @param objects
	 *            参数
	 * @param <T>
	 * @return true 继续执行跳转 false 不执行
	 */
	@Override public <T> boolean interceptStart(String s, Class<T> aClass, Method method, int i, String s1, Object[] objects) {

		L.i(1 + ":" + s);
		L.i(2 + ":" + aClass.getName());
		L.i(3 + ":" + method.getName());
		L.i(4 + ":" + i);
		L.i(5 + ":" + s1);
		L.i(6 + ":" + objects.length);

		// 如果没有登陆不执行跳转 ---可以跳转到其他地方
		// if(checkLoginState()){
		// return false;
		// }

		return true;
	}
}
