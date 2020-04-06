package entities;

public class RoleInfo {
    private String loginName;
    private String password;
    private String roleName;

    public RoleInfo() {
    }

    public RoleInfo(String loginName, String password, String roleName) {
        this.loginName = loginName;
        this.password = password;
        this.roleName = roleName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
