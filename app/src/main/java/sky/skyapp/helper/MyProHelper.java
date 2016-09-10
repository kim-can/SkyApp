package sky.skyapp.helper;

import jc.sky.SKYHelper;
import sky.skyapp.helper.modules.DBManager;
import sky.skyapp.helper.modules.ChannelManage;

/**
 * @创建人 sky
 * @创建时间 16/1/8
 * @类描述 帮助
 */
public class MyProHelper extends SKYHelper {

	/**
	 * 获取 数据库
	 *
	 * @return
	 */
	public static final DBManager skyDB() {
		MyProModulesManage kmModulesManage = getManage();
		return kmModulesManage.getDbManager();
	}

	/**
	 * 获取渠道
	 * 
	 * @return
	 */
	public static final ChannelManage channel() {
		MyProModulesManage myProModulesManage = getManage();
		return myProModulesManage.getChannelManage();
	}
}
