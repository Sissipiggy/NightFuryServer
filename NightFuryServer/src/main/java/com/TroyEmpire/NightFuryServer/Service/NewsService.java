package com.TroyEmpire.NightFuryServer.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.TroyEmpire.NightFuryServer.Constant.Constant;
import com.TroyEmpire.NightFuryServer.Constant.NewsType;
import com.TroyEmpire.NightFuryServer.Entity.News;
import com.TroyEmpire.NightFuryServer.IDAO.INewsDAO;
import com.TroyEmpire.NightFuryServer.IService.INewsService;
import com.TroyEmpire.NightFuryServer.Util.CommonUtil;
import com.TroyEmpire.NightFuryServer.Util.HtmlUtil;

@Service
@Component
public class NewsService implements INewsService {

	@Autowired
	private INewsDAO dao;

	@Override
	public void saveNews(News news) {
		dao.save(news);
	}

	@Override
	@Scheduled(fixedRate = Constant.INTERVAL_GRAB_NEWS)
	public void grabNewsServiceSchedulely() {
		// Grab Jwc News Service
		System.out.println("****** Grab News Round ******");
		grabJwcNews();
		grabXscNews();
	}

	private void grabJwcNews() {
		try {
			List<News> newsList = new ArrayList<News>();
			// find the last news
			News latestNews = dao.findLatestNews(NewsType.教务处);
			Document doc = Jsoup.connect(Constant.JWC_NEWS_PORTAL_URL)
					.method(Method.GET).execute().parse();
			// the charming characteristic 80%
			List<Element> eles = doc
					.getElementsByAttributeValue("width", "80%");
			for (Element ele : eles) {
				News news = new News();
				Element child = ele.child(1);
				if (latestNews == null
						|| !child.html().trim()
								.equalsIgnoreCase(latestNews.getTitle())) {
					news.setTitle(ele.child(1).html().trim());
					news.setNewsType(NewsType.教务处);
					news.setPublishDate(Calendar.getInstance().getTime());
					// get the content of the news
					news.setContent(getJwcNewsContent(Constant.JWC_ROOT_URL
							+ child.attr("href")));
					newsList.add(news);
				} else
					break;
			}
			List<News> reversedList = CommonUtil
					.reverse((ArrayList<News>) newsList);
			dao.saveAll(reversedList);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void grabXscNews() {
		List<News> newsList = new ArrayList<News>();
		// find the last news
		News latestNews = dao.findLatestNews(NewsType.学生处);
		Document doc;
		try {
			doc = Jsoup.connect(Constant.XSC_PORTAL_URL).method(Method.GET)
					.execute().parse();
			// the charming characteristics
			List<Element> eles = doc.getElementById("middle")
					.getElementsByAttributeValue("class", "mframe").get(0)
					.getElementsByAttributeValue("class", "nl").get(0)
					.children();
			for (Element ele : eles) {
				News news = new News();
				Element child = ele.child(0).child(0);
				if (latestNews == null
						|| !child.html().trim()
								.equalsIgnoreCase(latestNews.getTitle())) {
					news.setNewsType(NewsType.学生处);
					news.setPublishDate(Calendar.getInstance().getTime());
					news.setTitle(child.html().trim());
					// get the content of the news
					news.setContent(getXscNewsContent(Constant.XSC_PORTAL_URL
							+ child.attr("href")));
					newsList.add(news);
				} else
					break;
			}
			List<News> reversedList = CommonUtil
					.reverse((ArrayList<News>) newsList);
			dao.saveAll(reversedList);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getXscNewsContent(String url) {
		try {
			String content = Jsoup.connect(url).execute().parse()
					.getElementById("BodyLabel").html();
			content = HtmlUtil.optimizeHtmlByDeleteRangeMark(content, "style=\"",
					"\"");
			content = HtmlUtil.optimizeHtmlByDeleteSpecificSlice(content,
					"&nbsp;");
			content = HtmlUtil.optimizeHtmlByDeleteSpecificSlice(content, "\n");
			return content;
		} catch (Exception e) {
			System.out.println("信息平台学生处获取信息异常抛出。");
			return "没有规格化的消息，或许是一个外部链接，请用PC查看内容！";
		}
	}

	private String getJwcNewsContent(String url) {
		try {
			String legalUrl = "";
			int illegalStart1 = url.indexOf('教');
			int illegalStart2 = url.indexOf('通');
			legalUrl += url.substring(0,illegalStart1) + "%BD%CC%CE%F1%B4%A6"
					+ url.substring(illegalStart1 + 3, illegalStart2)
					+ "%CD%A8%D6%AA" + url.substring(illegalStart2 + 2);

			url.replace("[通知]", "%CD%A8%D6%AA");
			String content = Jsoup.connect(legalUrl).method(Method.GET).execute()
					.parse().getElementsByAttributeValue("class", "news")
					.get(0).html();
			content = HtmlUtil.optimizeHtmlByDeleteRangeMark(content, "style=\"",
					"\"");
			content = HtmlUtil.optimizeHtmlByDeleteSpecificSlice(content,
					"&nbsp;");
			content = HtmlUtil.optimizeHtmlByDeleteSpecificSlice(content, "\n");
			return content;

		} catch (Exception e) {
			System.out.println("信息平台教务处获取信息异常抛出。");
			return "没有规格化的消息，或许是一个外部链接，请用PC查看内容！";
		}
	}

	@Override
	public List<News> getNewsByClientNewsMaxId(NewsType type,
			int clientNewsMaxId) {
		if (type == NewsType.教务处)
			return (List<News>) CommonUtil.reverse(dao.findNewsAboveAnId(
					NewsType.教务处, clientNewsMaxId));
		else if (type == NewsType.学生处)
			return (List<News>) CommonUtil.reverse(dao.findNewsAboveAnId(
					NewsType.学生处, clientNewsMaxId));
		else if (type == null)
			return (List<News>) CommonUtil.reverse(dao
					.findNewsAboveAnId(clientNewsMaxId));
		return null;
	}

}
