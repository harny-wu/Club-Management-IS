package com.gudt.imis.clubmanageis.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * club_role
 * @author 
 */
@Data
public class ClubRole implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 社团id
     */
    private Integer clubId;

    /**
     * 用户在这个社团的权限，枚举：（0：管理员，1：记账员 2：普通成员）
     */
    private Integer userRole;

    /**
     * 用户别名
     */
    private String userAlias;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public static final class ClubRoleBuilder {
        private Integer id;
        private Integer userId;
        private Integer clubId;
        private Integer userRole;
        private String userAlias;
        private Date updateTime;
        private Date createTime;

        private ClubRoleBuilder() {
        }

        public static ClubRoleBuilder aClubRole() {
            return new ClubRoleBuilder();
        }

        public ClubRoleBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public ClubRoleBuilder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public ClubRoleBuilder withClubId(Integer clubId) {
            this.clubId = clubId;
            return this;
        }

        public ClubRoleBuilder withUserRole(Integer userRole) {
            this.userRole = userRole;
            return this;
        }

        public ClubRoleBuilder withUserAlias(String userAlias) {
            this.userAlias = userAlias;
            return this;
        }

        public ClubRoleBuilder withUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public ClubRoleBuilder withCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public ClubRole build() {
            ClubRole clubRole = new ClubRole();
            clubRole.setId(id);
            clubRole.setUserId(userId);
            clubRole.setClubId(clubId);
            clubRole.setUserRole(userRole);
            clubRole.setUserAlias(userAlias);
            clubRole.setUpdateTime(updateTime);
            clubRole.setCreateTime(createTime);
            return clubRole;
        }
    }
}