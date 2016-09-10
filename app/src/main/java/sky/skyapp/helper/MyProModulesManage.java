package sky.skyapp.helper;

import android.app.Application;

import jc.sky.modules.SKYModulesManage;
import sky.skyapp.helper.modules.DBManager;
import sky.skyapp.helper.modules.ChannelManage;

/**
 * @创建人 sky
 * @创建时间 16/1/8
 * @类描述
 */
public class MyProModulesManage extends SKYModulesManage {

	private DBManager dbManager;		// 数据库

	private ChannelManage	channelManage;

	public MyProModulesManage(Application application) {
		super(application);
		dbManager = new DBManager(application);
		channelManage = new ChannelManage(application);
	}

	/**
	 * 获取数据库
	 *
	 * @return
	 */
	public DBManager getDbManager() {
		return dbManager;
	}

	/**
	 * 渠道管理器
	 * 
	 * @return
	 */
	public ChannelManage getChannelManage() {
		return channelManage;
	}
}
