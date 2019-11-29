package com.xgdfin.workflow.common.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>TXT读取工具类</p>
 * @author FRH
 * @time 2018年9月6日下午2:03:08
 * @version 1.0
 */
public class TxtReader {

	/** 日志记录 */
	private static Logger logger = LoggerFactory.getLogger(TxtReader.class);

	/**
	 * <p>读取Txt文件</p>
	 * @param path 文件路径
	 * @param charset 字符编码，不传默认为UTF-8
	 * @return 读取结果
	 * @throws IOException List<String> 异常 
	 * @author FRH
	 * @time 2018年9月6日下午2:03:39
	 * @version 1.0
	 */
	public static String readAsString(String path, String charset) throws IOException {
		// 文件路径检查
		if (StringUtils.isBlank(path)) {
			logger.error("文件路径不正确！");
			throw new FileNotFoundException("文件路径不正确！");
		}

		// 封装返回结果
		StringBuffer resultSbf = new StringBuffer("");
		BufferedReader reader = null;
		InputStreamReader iStreamReader = null;
		InputStream fStream = null;
		try {
			// 参数为空，设置默认值
			if (StringUtils.isBlank(charset)) {
				charset = "UTF-8";
			}

			// 读取文件
			fStream = TxtReader.class.getResourceAsStream("/" + path);
			if(fStream == null) {
				fStream = TxtReader.class.getResourceAsStream(path);
			}
			iStreamReader = new InputStreamReader(fStream, charset);
			reader = new BufferedReader(iStreamReader);
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (StringUtils.isBlank(line)) {
					continue;
				}
				resultSbf.append(line);
			}
			logger.info("读取文件完成！");
		} catch (Exception e) {
			logger.error("read " + path + " error.", e);
		} finally {
			if (fStream != null) {
				fStream.close();
			}
			if (iStreamReader != null) {
				iStreamReader.close();
			}
			if (reader != null) {
				reader.close();
			}
		}

		return resultSbf.toString();
	}

}
