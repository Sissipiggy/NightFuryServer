package com.TroyEmpire.NightFuryServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TroyEmpire.NightFuryServer.Entity.InternalStatistics;
import com.TroyEmpire.NightFuryServer.IDAO.IInternalStatisticsDAO;

@Controller
public class InternalStatisticsController {

	@Autowired
	private IInternalStatisticsDAO interDao;

	@RequestMapping("/internalStatistics")
	public ModelAndView internalStatistics() {

		int totalDownloader = interDao.findAll(InternalStatistics.class).size();
		ModelAndView model = new ModelAndView();
		model.setViewName("internalStatistics");
		model.addObject("numberOfDownloadApk", totalDownloader);
		return model;

	}
}
