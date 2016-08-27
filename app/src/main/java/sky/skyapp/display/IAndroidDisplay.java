package sky.skyapp.display;

import jc.sky.core.Impl;
import jc.sky.display.SKYDisplay;
import jc.sky.display.SKYIDisplay;
import jc.sky.modules.log.L;

/**
 * @创建人 sky
 * @创建时间 16/8/24 下午7:39
 * @类描述
 */
@Impl(AndroidDisplay.class)
public interface IAndroidDisplay extends SKYIDisplay {

	void load();
}

class AndroidDisplay extends SKYDisplay implements IAndroidDisplay {

	@Override public void load() {
		L.i("执行了");

	}
}
