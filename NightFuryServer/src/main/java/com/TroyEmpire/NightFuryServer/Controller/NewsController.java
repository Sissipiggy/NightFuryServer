package com.TroyEmpire.NightFuryServer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TroyEmpire.NightFuryServer.Constant.NewsType;
import com.TroyEmpire.NightFuryServer.Entity.News;
import com.TroyEmpire.NightFuryServer.IService.INewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private INewsService newsService;

	@RequestMapping(value = "/{newsType}/{clientNewsMaxId}", method = RequestMethod.GET)
	@ResponseBody
	public List<News> updateClientSideNews(@PathVariable(value="clientNewsMaxId") int clientNewsMaxId,
			@PathVariable(value="newsType") int newsType) {
		if (newsType == NewsType.教务处.ordinal())
			return newsService.getNewsByClientNewsMaxId(NewsType.教务处,
					clientNewsMaxId);
		else if (newsType == NewsType.学生处.ordinal())
			return newsService.getNewsByClientNewsMaxId(NewsType.学生处,
					clientNewsMaxId);
		else
			return newsService.getNewsByClientNewsMaxId(null, clientNewsMaxId);
	}

}
