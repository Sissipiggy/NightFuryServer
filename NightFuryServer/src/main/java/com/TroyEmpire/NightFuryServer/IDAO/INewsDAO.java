package com.TroyEmpire.NightFuryServer.IDAO;

import java.util.List;

import com.TroyEmpire.NightFuryServer.Constant.NewsType;
import com.TroyEmpire.NightFuryServer.Entity.News;


public interface INewsDAO extends IDAO<News, Integer>{
	public News findLatestNews(NewsType type);
	
	/**
	 * @param type
	 * @param id
	 * @return a limited number of news which are a specific type and newer than a given id
	 */
	public List<News> findNewsAboveAnId(NewsType type, int id);

	/**
	 * @return a limited number of news which are newer than a given id
	 */
	List<News> findNewsAboveAnId(int id);
}
