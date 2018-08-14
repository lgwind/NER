package com.lgwind.controller.util;

/**
 * 密码修改数据实体类
 * @author Lgwind
 *
 */
public class PU {
    
    private String username;
    private String userrole;
    private String passwordOld;
    private String passwordNew;
    
    public PU() {
        super();
        // TODO Auto-generated constructor stub
    }

    public PU(String username, String userrole, String passwordOld,
            String passwordNew) {
        super();
        this.username = username;
        this.userrole = userrole;
        this.passwordOld = passwordOld;
        this.passwordNew = passwordNew;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordOld() {
        return passwordOld;
    }

    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    @Override
    public String toString() {
        return "PU [username=" + username + ", userrole=" + userrole
                + ", passwordOld=" + passwordOld + ", passwordNew="
                + passwordNew + "]";
    }
    
}
