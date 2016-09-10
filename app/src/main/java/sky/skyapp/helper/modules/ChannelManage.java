package sky.skyapp.helper.modules;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @创建人 sky
 * @创建时间 16/9/10 下午12:03
 * @类描述
 */
public class ChannelManage {

	// 渠道KEY
	private static final String	CHANNEL_KEY		= "skychannelname";

	// 默认渠道
	private static final String	DEFAULT_CHANNEL	= "sky";

	private String				mChannel;

	public ChannelManage(Context context) {
		mChannel = getChannelFromApk(context, CHANNEL_KEY);
		if (StringUtils.isEmpty(mChannel)) {
			mChannel = DEFAULT_CHANNEL;
		}
	}

	/**
	 * 获取渠道
	 * 
	 * @return
	 */
	public String getChannel() {
		return mChannel;
	}

	/**
	 * 从apk中获取版本信息
	 *
	 * @param context
	 * @param channelKey
	 * @return
	 */
	private static String getChannelFromApk(Context context, String channelKey) {
		long startTime = System.currentTimeMillis();
		// 从apk包中获取
		ApplicationInfo appinfo = context.getApplicationInfo();
		String sourceDir = appinfo.sourceDir;
		// 默认放在meta-inf/里， 所以需要再拼接一下
		String key = "META-INF/" + channelKey;
		String ret = "";
		ZipFile zipfile = null;
		try {
			zipfile = new ZipFile(sourceDir);
			Enumeration<?> entries = zipfile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = ((ZipEntry) entries.nextElement());
				String entryName = entry.getName();
				if (entryName.startsWith(key)) {
					ret = entryName;
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (zipfile != null) {
				try {
					zipfile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		String channel = "";
		if (StringUtils.isNotBlank(ret)) {
			String[] split = ret.split("_");
			channel = split[1];
			System.out.println("-----------------------------");
			System.out.println("渠道号：" + channel + "，解压获取渠道号耗时:" + (System.currentTimeMillis() - startTime) + "ms");
			System.out.println("-----------------------------");
		} else {
			System.out.println("未解析到相应的渠道号，使用默认内部渠道号");
			channel = DEFAULT_CHANNEL;
		}
		return channel;
	}
}
