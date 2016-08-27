package sky.skyapp.view;

import java.util.ArrayList;
import java.util.List;

import jc.sky.SKYHelper;
import jc.sky.core.Impl;
import jc.sky.core.SKYBiz;
import jc.sky.core.SKYIBiz;
import jc.sky.modules.methodProxy.Background;
import jc.sky.modules.threadpool.BackgroundType;
import sky.skyapp.view.model.ListModel;

/**
 * @创建人 sky
 * @创建时间 16/8/27 上午11:51
 * @类描述 一句话描述你的业务
 */
@Impl(ListBiz.class)
public interface IListBiz extends SKYIBiz {

	/**
	 * 加载数据
	 */
	@Background(BackgroundType.WORK) void loadData();
}

class ListBiz extends SKYBiz<IListActivity> implements IListBiz {

	@Override public void loadData() {

		List<ListModel> listModelList = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			ListModel listModel = new ListModel();

			listModel.title = "我是" + i;

			listModelList.add(listModel);
		}

		ui().setData(listModelList);

		// 刷新登陆页面
		biz(ILoginBiz.class).updateBtn();

		// SKYHelper.biz(ILoginBiz.class).updateBtn(); 两种方式 都可以
	}
}