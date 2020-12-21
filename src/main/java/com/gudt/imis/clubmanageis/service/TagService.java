package com.gudt.imis.clubmanageis.service;

import com.gudt.imis.clubmanageis.model.result.Result;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TagService
 * @Author: ccjmlkj
 * @Description:
 * @create: 2020-12-21 15:56
 **/
@Service
public interface TagService {
    Result createTag(Integer clubId, String tagName,Integer tagType);
}
