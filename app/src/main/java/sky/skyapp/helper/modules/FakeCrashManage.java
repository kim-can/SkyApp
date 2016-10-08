package sky.skyapp.helper.modules;

/**
 * @创建人 sky
 * @创建时间 16/9/28 上午11:55
 * @类描述
 */
public class FakeCrashManage {
    public static void log(int priority, String tag, String message) {
        // TODO add log entry to circular buffer.
    }

    public static void logWarning(Throwable t) {
        // TODO report non-fatal warning.
    }

    public static void logError(Throwable t) {
        // TODO report non-fatal error.
        System.out.print("jincan:存储到文件里 并且上传"+t.getMessage());
    }

    private FakeCrashManage() {
        throw new AssertionError("No instances.");
    }
}
