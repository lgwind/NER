package com.lgwind.domain;

public class Datas {
	
	private String username;
	private String name;
	private String phone;
    private String email;
    private String post;
    private String reporttime;
    private String starttime;
    private String position;
    private String direction;
    private String birthday;
    
    private User user;
    
    public Datas() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Datas(String username, String name, String phone, String email,
            String post, String reporttime, String starttime, String position,
            String direction, String birthday) {
        super();
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.post = post;
        this.reporttime = reporttime;
        this.starttime = starttime;
        this.position = position;
        this.direction = direction;
        this.birthday = birthday;
    }

    public Datas(String username, String name, String phone, String email,
            String post, String reporttime, String starttime, String position,
            String direction, String birthday, User user) {
        super();
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.post = post;
        this.reporttime = reporttime;
        this.starttime = starttime;
        this.position = position;
        this.direction = direction;
        this.birthday = birthday;
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getReporttime() {
        return reporttime;
    }

    public void setReporttime(String reporttime) {
        this.reporttime = reporttime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Datas [username=" + username + ", name=" + name + ", phone="
                + phone + ", email=" + email + ", post=" + post
                + ", reporttime=" + reporttime + ", starttime=" + starttime
                + ", position=" + position + ", direction=" + direction
                + ", birthday=" + birthday + ", user=" + user + "]";
    }

}
