package sky.skyapp;

import jc.sky.core.Impl;
import jc.sky.core.SKYBiz;
import jc.sky.core.SKYIBiz;

/**
 * @创建人 sky
 * @创建时间 16/8/22 下午3:40
 * @类描述 一句话描述你的业务
 */
@Impl(LoginBiz.class)
public interface ILoginBiz extends SKYIBiz {

}

class LoginBiz extends SKYBiz<ILoginActivity> implements ILoginBiz {

}