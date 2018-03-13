package com.tech.court.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.court.domain.CaseQuery;
import com.tech.court.entity.CourtCase;
import com.tech.court.service.ICourtService;

import java.util.List;
import java.util.Objects;

@Controller
public class PageController {
  @Autowired
  private ICourtService courtService;

  @RequestMapping("/test")
  public String test() {
    return "judgement/index";
  }

  @RequestMapping("/index.html")
  public String index() {
    return "index";
  }

  @RequestMapping("/judgement.html")
  public String judgement(Model model) {
    model.addAttribute("summary", courtService.getJudgementSummary(null, null));
    return "judgement";
  }

  @RequestMapping("/live.html")
  public String live(Model model) {
    model.addAttribute("courtRooms", courtService.getCourtLives());
    model.addAttribute("summary", courtService.getCourtLiveSummary());
    return "live";
  }

  @RequestMapping("/court.html")
  public String court() {
    return "court";
  }

  @RequestMapping("/enforce.html")
  public String enforce(Model model) {
    model.addAttribute("summary", courtService.getEnforceSummary(null, null));
    return "enforce";
  }

  @RequestMapping("/performance.html")
  public String performance(Model model) {
    model.addAttribute("summary", courtService.getJudgementSummary(null, null));
    model.addAttribute("performance", courtService.getPerformanceSummay(null, null));
    return "performance";
  }

  @RequestMapping("/query.html")
  public String query(Model model, @ModelAttribute(value = "caseQuery") CaseQuery caseQuery) throws Exception {
    if (Objects.isNull(caseQuery.getPageNo())) {
      caseQuery.setPageNo(0);
      caseQuery.setSize(10);
    }
    List<CourtCase> cases = courtService.queryCourtCase(caseQuery);
    model.addAttribute("cases", cases);
    return "query";
  }

  @RequestMapping("/user.html")
  public String user(Model model) {
    return "user";
  }

  @RequestMapping("/department.html")
  public String department(Model model) {
    model.addAttribute("summary", courtService.getDepartmentSummary(null, null));
    return "department";
  }

  @RequestMapping("/chiefjudge.html")
  public String chiefjudge(Model model) {
    return "chiefjudge";
  }

  @RequestMapping("/chiefjudge_performance.html")
  public String chiefjudgePerformance(Model model) {
    return "chiefjudge_performance";
  }

  @RequestMapping(value = "/upload.html")
  public String goUpload() {
    return "upload";
  }
}
