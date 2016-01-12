package cn.ideath.crawler.fetch;

import cn.ideath.crawler.bean.RequestData;
import cn.ideath.crawler.bean.ResponseData;

/**
 * 抓捕父接口
 * @author HuangYao
 *
 */
public interface Fetcher {

	ResponseData fetch(RequestData request);
}
