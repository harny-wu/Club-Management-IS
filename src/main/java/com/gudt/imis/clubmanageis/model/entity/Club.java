package com.gudt.imis.clubmanageis.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * club
 * @author 
 */
@Data
public class Club implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 社团简介
     */
    private String clubDescription;

    /**
     * 社团名字
     */
    private String clubName;

    /**
     * 列表存储[img1,img2….]社团首页展示图片
     */
    private String clubImgs;

    /**
     * 社团邀请码
     */
    private String clubInvitecode;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public static final class ClubBuilder {
        private Integer id;
        private String clubDescription;
        private String clubName;
        private String clubImgs;
        private String clubInvitecode;
        private Date updateTime;
        private Date createTime;

        private ClubBuilder() {
        }

        public static ClubBuilder aClub() {
            return new ClubBuilder();
        }

        public ClubBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public ClubBuilder withClubDescription(String clubDescription) {
            this.clubDescription = clubDescription;
            return this;
        }

        public ClubBuilder withClubName(String clubName) {
            this.clubName = clubName;
            return this;
        }

        public ClubBuilder withClubImgs(String clubImgs) {
            this.clubImgs = clubImgs;
            return this;
        }

        public ClubBuilder withClubInvitecode(String clubInvitecode) {
            this.clubInvitecode = clubInvitecode;
            return this;
        }

        public ClubBuilder withUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public ClubBuilder withCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Club build() {
            Club club = new Club();
            club.setId(id);
            club.setClubDescription(clubDescription);
            club.setClubName(clubName);
            club.setClubImgs(clubImgs);
            club.setClubInvitecode(clubInvitecode);
            club.setUpdateTime(updateTime);
            club.setCreateTime(createTime);
            return club;
        }
    }
}