package com.gudt.imis.clubmanageis.model.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户自我介绍
     */
    private String userSelfDescription;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户手机
     */
    private String userPhone;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 微信授权需要的一个id
     */
    private String userOpenId;

    private static final long serialVersionUID = 1L;

    public static final class UserBuilder {
        private Integer id;
        private String userName;
        private String userSelfDescription;
        private String userPwd;
        private String userPhone;
        private String userEmail;
        private String userOpenId;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public UserBuilder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder withUserSelfDescription(String userSelfDescription) {
            this.userSelfDescription = userSelfDescription;
            return this;
        }

        public UserBuilder withUserPwd(String userPwd) {
            this.userPwd = userPwd;
            return this;
        }

        public UserBuilder withUserPhone(String userPhone) {
            this.userPhone = userPhone;
            return this;
        }

        public UserBuilder withUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public UserBuilder withUserOpenId(String userOpenId) {
            this.userOpenId = userOpenId;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setUserName(userName);
            user.setUserSelfDescription(userSelfDescription);
            user.setUserPwd(userPwd);
            user.setUserPhone(userPhone);
            user.setUserEmail(userEmail);
            user.setUserOpenId(userOpenId);
            return user;
        }
    }
}