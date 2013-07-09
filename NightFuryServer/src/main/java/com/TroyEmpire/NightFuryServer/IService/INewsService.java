package com.TroyEmpire.NightFuryServer.IService;

import java.util.List;

import com.TroyEmpire.NightFuryServer.Constant.NewsType;
import com.TroyEmpire.NightFuryServer.Entity.News;


public interface INewsService {
	public void saveNews(News news);

	/**
	 * this method will be runned schedulely
	 */
	public void grabNewsServiceSchedulely();
	
	/**
	 * @param clientNewsMaxId  is the id of the newsest news on client side
	 * @return a list of latest news of specific type
	 */
	List<News> getNewsByClientNewsMaxId(NewsType type,
			int clientNewsMaxId);
}
