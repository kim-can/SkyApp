package sky.skyapp.view.animation;

import android.os.Bundle;
import android.widget.Button;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

import butterknife.BindView;
import butterknife.OnClick;
import jc.sky.core.Impl;
import jc.sky.modules.log.L;
import jc.sky.view.SKYBuilder;
import jc.sky.view.SKYActivity;
import sky.skyapp.R;

/**
 * @创建人 sky
 * @创建时间 16/9/13 下午8:07
 * @类描述 一句话描述你的UI
 */
public class AnimationTestActivity extends SKYActivity<IAnimationTestBiz> implements IAnimationTestActivity {

	@BindView(R.id.btn_animation) public Button btnAnimation;

	@Override protected SKYBuilder build(SKYBuilder skyBuilder) {
		skyBuilder.layoutId(R.layout.activity_animationtest);
		return skyBuilder;
	}

	@Override protected void initData(Bundle bundle) {

	}

    /**
     * 测试
     */
    @OnClick(R.id.btn_animation) public void test() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(btnAnimation, "alpha", 0f, 1f);
        anim.setDuration(300);
        anim.addUpdateListener(new ObjectAnimator.AnimatorUpdateListener() {

            @Override public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                L.i("cuurent value is " + currentValue);
            }
        });
        anim.setRepeatMode(ValueAnimator.INFINITE);
        anim.setRepeatCount(5);
        anim.start();
	}

}

@Impl(AnimationTestActivity.class)
interface IAnimationTestActivity {

}