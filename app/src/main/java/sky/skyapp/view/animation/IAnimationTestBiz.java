package sky.skyapp.view.animation;

import jc.sky.core.Impl;
import jc.sky.core.SKYBiz;
import jc.sky.core.SKYIBiz;

/**
 * @创建人 sky
 * @创建时间 16/9/13 下午8:07
 * @类描述 一句话描述你的业务
 */
@Impl(AnimationTestBiz.class)
public interface IAnimationTestBiz extends SKYIBiz {

}

class AnimationTestBiz extends SKYBiz<IAnimationTestActivity> implements IAnimationTestBiz {

}