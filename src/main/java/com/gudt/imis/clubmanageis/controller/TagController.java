package com.gudt.imis.clubmanageis.controller;

import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TagController
 * @Author: ccjmlkj
 * @Description:
 * @create: 2020-12-21 15:50
 **/
@RestController
public class TagController {
    @Autowired
    private TagService tagService;
    @PostMapping(value = ("/creatTag"))
    public Result createTag(@RequestParam("clubId")Integer clubId,
                                    @RequestParam("tagName")String tagName,
                                    @RequestParam("tagType")Integer tagType){
        return tagService.createTag(clubId,tagName,tagType);
    }
}
