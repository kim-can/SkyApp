package sky.skyapp;

import jc.sky.core.Impl;
import jc.sky.core.SKYCommonBiz;
import jc.sky.core.SKYICommonBiz;
import jc.sky.modules.log.L;

/**
 * @创建人 sky
 * @创建时间 16/8/25 下午5:15
 * @类描述
 */
@Impl(Common.class)
public interface ICommon extends SKYICommonBiz {

	void test();
}

class Common extends SKYCommonBiz implements ICommon {

	@Override public void test() {
		L.i("哈哈哈");
	}
}
