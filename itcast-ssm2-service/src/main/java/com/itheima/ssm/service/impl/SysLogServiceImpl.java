package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.SysLogDao;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysLogService")
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public Integer save(SysLog sysLog) throws Exception {
        Integer i = sysLogDao.save(sysLog);
        return i;
    }

    @Override
    public List<SysLog> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return sysLogDao.findAll();
    }
}
