package xyz.stackoverflow.blog.pojo.vo;

import xyz.stackoverflow.blog.pojo.entity.User;
import xyz.stackoverflow.blog.util.web.SuperVO;

/**
 * 用户VO
 *
 * @author 凉衫薄
 */
public class UserVO implements SuperVO {

    private String id;
    private String email;
    private String password;
    private String nickname;
    private String salt;
    private Integer deleteAble;

    private String oldPassword;
    private String vcode;

    public UserVO(){

    }

    public UserVO(String id, String email, String password, String nickname, String salt, Integer deleteAble, String oldPassword, String vcode) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.salt = salt;
        this.deleteAble = deleteAble;
        this.oldPassword = oldPassword;
        this.vcode = vcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getDeleteAble() {
        return deleteAble;
    }

    public void setDeleteAble(Integer deleteAble) {
        this.deleteAble = deleteAble;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    /**
     * 转换成实体类
     *
     * @return 转换后的实体类
     */
    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setNickname(nickname);
        user.setPassword(password);
        user.setSalt(salt);
        user.setDeleteAble(deleteAble);
        return user;
    }
}
