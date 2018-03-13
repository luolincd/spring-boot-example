package com.tech.court.service.impl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tech.court.dao.primary.CourtCaseMapper;
import com.tech.court.entity.CourtCase;
import com.tech.court.entity.CourtCaseExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UploadService {

  @Autowired
  private CourtCaseMapper courtCaseMapper;

  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public static boolean isExcel2003(String filePath) {
    return filePath.matches("^.+\\.(?i)(xls)$");
  }

  public static boolean isExcel2007(String filePath) {
    return filePath.matches("^.+\\.(?i)(xlsx)$");
  }

  public void importData(File file) throws Exception {
    Workbook wb = null;
    List<CourtCase> cases = new ArrayList();
    try {
      wb = new HSSFWorkbook(new FileInputStream(file));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Sheet sheet = wb.getSheetAt(0);//获取第一张表
    log.info("total excel rows:{}", sheet.getLastRowNum());
    for (int i = 1; i < sheet.getLastRowNum(); i++) {
      Row row = sheet.getRow(i);//获取索引为i的行，以0开始
      String deadline = row.getCell(1).getStringCellValue();
      String status = row.getCell(2).getStringCellValue();//获取第i行的索引为0的单元格数据
      String name = row.getCell(4).getStringCellValue();
      String type = row.getCell(5).getStringCellValue();
      String reason = row.getCell(7).getStringCellValue();
      String caseInvolved = row.getCell(8).getStringCellValue();
      String acceptDate = row.getCell(9).getStringCellValue();
      String registerDate = row.getCell(10).getStringCellValue();
      String registerUser = row.getCell(11).getStringCellValue();
      double registerAmount = row.getCell(12).getNumericCellValue();
      String undertakeDept = row.getCell(14).getStringCellValue();
      String undertakeUser = row.getCell(15).getStringCellValue();
      String chiefJudge = row.getCell(16).getStringCellValue();
      String openDate = row.getCell(21).getStringCellValue();
      String endDate = row.getCell(22).getStringCellValue();
      String reportEndDate = row.getCell(23).getStringCellValue();
      String acturalEndDate = row.getCell(24).getStringCellValue();
      String endMethod = row.getCell(25).getStringCellValue();
      double judgeDays = row.getCell(30).getNumericCellValue();
      double endAmount = row.getCell(31).getNumericCellValue();
      double acturalAmount = row.getCell(32).getNumericCellValue();
      double abandonAmount = row.getCell(33).getNumericCellValue();
      String programe = row.getCell(38).getStringCellValue();
      CourtCase courtCase = new CourtCase();
      if (!StringUtils.isEmpty(deadline)) {
        //courtCase.setDeadline(Integer.parseInt(deadline));
      }
      courtCase.setStatus(status);
      courtCase.setName(name);
      courtCase.setType(type);
      courtCase.setReason(reason);
      courtCase.setCaseInvolved(caseInvolved);
      if (!StringUtils.isEmpty(acceptDate)) {
        courtCase.setAcceptDate(sdf.parse(acceptDate));
      }
      if (!StringUtils.isEmpty(registerDate)) {
        courtCase.setRegisterDate(sdf.parse(registerDate));
      }
      courtCase.setRegisterUser(registerUser);
      if (!StringUtils.isEmpty(registerAmount)) {
        courtCase.setRegisterAmount(new BigDecimal(registerAmount));
      }
      courtCase.setUndertakeDepartment(undertakeDept);
      courtCase.setUndertakeUser(undertakeUser);
      courtCase.setChiefJudge(chiefJudge);
      if (!StringUtils.isEmpty(openDate)) {
        courtCase.setOpenDate(sdf.parse(openDate));
      }
      if (!StringUtils.isEmpty(endDate)) {
        courtCase.setEndDate(sdf.parse(endDate));
      }
      if (!StringUtils.isEmpty(reportEndDate)) {
        courtCase.setReportEndDate(sdf.parse(reportEndDate));
      }
      if (!StringUtils.isEmpty(acturalEndDate)) {
        courtCase.setActualEndDate(sdf.parse(acturalEndDate));
      }
      courtCase.setEndMethod(endMethod);
      if (!StringUtils.isEmpty(judgeDays)) {
        courtCase.setJudgeDays((int) judgeDays);
      }
      if (!StringUtils.isEmpty(endAmount)) {
        courtCase.setEndAmount(new BigDecimal(endAmount));
      }
      if (!StringUtils.isEmpty(acturalAmount)) {
        courtCase.setActualAmount(new BigDecimal(acturalAmount));
      }
      if (!StringUtils.isEmpty(abandonAmount)) {
        courtCase.setAbandonAmount(new BigDecimal(abandonAmount));
      }
      courtCase.setProgram(programe);
      cases.add(courtCase);
    }
    try {
      wb.close();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (wb != null) {
          wb.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    final List<CourtCase> sucessCases = new ArrayList<>();
    cases.forEach(courtCase -> {
      if (hasExistCase(courtCase.getName())) {
        deleteCase(courtCase.getName());
        log.info("delete court case:{}", courtCase.getName());
      }
      courtCaseMapper.insertSelective(courtCase);
      log.info("insert court case:{}", courtCase.getName());
      sucessCases.add(courtCase);
    });
    log.info("insert {} court case", sucessCases.size());
  }

  private boolean hasExistCase(String name) {
    CourtCaseExample example = new CourtCaseExample();
    example.createCriteria().andNameEqualTo(name);
    List<CourtCase> caseList = courtCaseMapper.selectByExample(example);
    if (caseList != null && caseList.size() > 0) {
      return true;
    } else {
      return false;
    }
  }

  private void deleteCase(String name) {
    CourtCaseExample example = new CourtCaseExample();
    example.createCriteria().andNameEqualTo(name);
    courtCaseMapper.deleteByExample(example);
  }
}
