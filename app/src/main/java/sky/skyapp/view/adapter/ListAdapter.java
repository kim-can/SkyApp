package sky.skyapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import jc.sky.SKYHelper;
import jc.sky.view.SKYActivity;
import jc.sky.view.adapter.recycleview.SKYHolder;
import jc.sky.view.adapter.recycleview.SKYRVAdapter;
import sky.skyapp.R;
import sky.skyapp.view.model.ListModel;

/**
 * @创建人 sky
 * @创建时间 16/8/27 上午11:56
 * @类描述
 */
public class ListAdapter extends SKYRVAdapter<ListModel, ListAdapter.ItemHolder> {

	public ListAdapter(SKYActivity skyActivity) {
		super(skyActivity);
	}

	@Override public ItemHolder newViewHolder(ViewGroup viewGroup, int i) {
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
		ItemHolder itemHolder = new ItemHolder(view);
		return itemHolder;
	}

	/**
	 * holder
	 */
	public class ItemHolder extends SKYHolder<ListModel> {

		@BindView(R.id.tv_content) TextView	tvContent;

		@BindView(R.id.line1) LinearLayout	line1;

		public ItemHolder(View view) {
			super(view);
		}

		@Override public void bindData(ListModel listModel, int i) {
			tvContent.setText(listModel.title);
		}

		/**
		 * 点击事件
		 */
		@OnClick(R.id.line1) public void onItem() {
			SKYHelper.toast().show(getAdapterPosition() + "被点击了");
		}
	}
}
