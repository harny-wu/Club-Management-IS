package com.gudt.imis.clubmanageis.service.impl;

import com.gudt.imis.clubmanageis.dao.ClubTagDao;
import com.gudt.imis.clubmanageis.model.entity.ClubTag;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.TagService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: TagServiceImpl
 * @Author: ccjmlkj
 * @Description:
 * @create: 2020-12-21 15:58
 **/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private ClubTagDao clubTagDao;
    @Override
    public Result createTag(Integer clubId, String tagName, Integer tagType) {
        ClubTag clubTag = new ClubTag();
        clubTag.setClubId(clubId);
        clubTag.setTagName(tagName);
        clubTag.setTagType(tagType);
        clubTag.setCreateTime(new Date());
        clubTag.setUpdateTime(new Date());
        clubTagDao.insert(clubTag);
        return ResultUtil.success();
    }

    @Override
    public Result<List<ClubTag>> getTagList(Integer clubId) {
        List<ClubTag> clubTagList=clubTagDao.getTagList(clubId);
        return ResultUtil.success(clubTagList);
    }
}
