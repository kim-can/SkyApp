package sky.skyapp.helper;

import jc.sky.SKYHelper;

/**
 * @创建人 sky
 * @创建时间 16/1/8
 * @类描述 帮助
 */
public class MyProHelper extends SKYHelper {
	/**
	 * 获取客脉 数据库
	 *
	 * @return
	 */
	public static final DBManager pudingDB() {
		MyProModulesManage kmModulesManage = getManage();
		return kmModulesManage.getDbManager();
	}

}
