package cn.guxiangfly.shiyan.project01;

/**
 * User
 *
 * @author guxiang
 * @date 2017/10/19
 */
public class User {
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println("调用了构造");
    }

    public String getUsername() {
        System.out.println("调用了getusername方法");
        return username;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
