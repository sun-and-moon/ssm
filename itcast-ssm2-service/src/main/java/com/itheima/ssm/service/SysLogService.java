package com.itheima.ssm.service;


import com.itheima.ssm.domain.SysLog;

import java.util.List;

public interface SysLogService {
    public Integer save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(Integer page, Integer pageSize);

}
