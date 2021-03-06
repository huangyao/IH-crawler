package cn.ideath.crawler.analyze;

import cn.ideath.crawler.bean.SourceData;

/**
 * 解析父接口
 * @author HuangYao
 *
 */
public interface Parser<T> {

	T parse(SourceData src);
}
