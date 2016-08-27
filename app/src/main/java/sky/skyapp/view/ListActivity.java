package sky.skyapp.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import jc.sky.SKYHelper;
import jc.sky.core.Impl;
import jc.sky.view.SKYBuilder;
import jc.sky.view.SKYActivity;
import sky.skyapp.R;
import sky.skyapp.display.IAndroidDisplay;
import sky.skyapp.view.adapter.ListAdapter;
import sky.skyapp.view.model.ListModel;

/**
 * @创建人 sky
 * @创建时间 16/8/27 上午11:51
 * @类描述 一句话描述你的UI
 */
@Impl(ListActivity.class)
interface IListActivity {

	String KEY = "key";

	/**
	 * 设置数据
	 * 
	 * @param listModelList
	 */
	void setData(List<ListModel> listModelList);
}

public class ListActivity extends SKYActivity<IListBiz> implements IListActivity {

	/**
	 * 默认跳转
	 */
	public static void intent() {
		SKYHelper.display(IAndroidDisplay.class).intent(ListActivity.class);
	}

	/**
	 * 带参数跳转
	 */
	public static void intent(String name) {
		Bundle bundle = new Bundle();
		bundle.putString(KEY, name);
		SKYHelper.display(IAndroidDisplay.class).intent(ListActivity.class, bundle);
	}

	@Override protected SKYBuilder build(SKYBuilder skyBuilder) {
		skyBuilder.layoutId(R.layout.activity_list);

		skyBuilder.recyclerviewId(R.id.recyclerView);
		skyBuilder.recyclerviewAdapter(new ListAdapter(this));
		skyBuilder.recyclerviewLinearLayoutManager(LinearLayoutManager.VERTICAL, null, null);
		return skyBuilder;
	}

	@Override protected void initData(Bundle bundle) {
		biz().loadData();
	}

	@Override public void setData(List<ListModel> listModelList) {
		recyclerAdapter().setItems(listModelList);
	}
}
