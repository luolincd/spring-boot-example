package com.tech.court.dao.primary;

import com.tech.court.entity.CaseReport;
import com.tech.court.entity.CaseReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseReportMapper {
    long countByExample(CaseReportExample example);

    int deleteByExample(CaseReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CaseReport record);

    int insertSelective(CaseReport record);

    List<CaseReport> selectByExample(CaseReportExample example);

    CaseReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CaseReport record, @Param("example") CaseReportExample example);

    int updateByExample(@Param("record") CaseReport record, @Param("example") CaseReportExample example);

    int updateByPrimaryKeySelective(CaseReport record);

    int updateByPrimaryKey(CaseReport record);
}