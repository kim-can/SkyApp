package sky.skyapp.http.model;

/**
 * @创建人 sky
 * @创建时间 16/10/12 上午9:25
 * @类描述
 */
public class Contributor {
    public final String login;
    public final int contributions;

    public Contributor(String login, int contributions) {
        this.login = login;
        this.contributions = contributions;
    }
}
