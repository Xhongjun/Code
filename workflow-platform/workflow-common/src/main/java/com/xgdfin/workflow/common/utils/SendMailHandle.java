package com.xgdfin.workflow.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 邮件发送工具
 * @version 2018年11月7日上午9:17:38
 * @author ruhan.fan
 */
public class SendMailHandle {
	
	/** 日志记录 */
	private static final Logger logger = LoggerFactory.getLogger(SendMailHandle.class);
	
	/** 文本编码 */
	public static final String TEXT = "text/plain;charset=gb2312";
	
	/** html编码 */
	public static final String HTML = "text/html;charset=gb2312";
	
	/** 编码 */
	public static final String ENCODING = "gb2312";

	/**
	 * 获取邮件正文
	 * @version 2018年11月7日上午9:19:20
	 * @author ruhan.fan
	 * @param content 内容
	 * @param contentType 类型
	 * @return 邮件正文
	 * @throws MessagingException 异常
	 */
	public static BodyPart getBody(String content, String contentType) throws MessagingException {
		BodyPart body = new MimeBodyPart();
		DataHandler dh = new DataHandler(content, contentType);
		body.setDataHandler(dh);
		return body;
	}

	/**
	 * 获取文本邮件正文
	 * @version 2018年11月7日上午9:21:06
	 * @author ruhan.fan
	 * @param content 内容
	 * @return 文本邮件正文
	 * @throws MessagingException 异常
	 */
	public static BodyPart getBodyAsText(String content) throws MessagingException {
		return getBody(content, TEXT);
	}

	/**
	 * 获取html邮件正文
	 * @version 2018年11月7日上午9:21:44
	 * @author ruhan.fan
	 * @param content 内容
	 * @return html邮件正文
	 * @throws MessagingException 异常
	 */
	public static BodyPart getBodyAsHTML(String content) throws MessagingException {
		return getBody(content, HTML);
	}

	/**
	 * 从文件中获取邮件正文
	 * @version 2018年11月7日上午9:22:53
	 * @author ruhan.fan
	 * @param fileName 文件名
	 * @return 邮件正文
	 * @throws MessagingException
	 */
	public static BodyPart getBodyFromFile(String fileName) throws MessagingException {
		BodyPart mdp = new MimeBodyPart();
		FileDataSource fds = new FileDataSource(fileName);
		DataHandler dh = new DataHandler(fds);
		mdp.setDataHandler(dh);
		return mdp;
	}

	/**
	 * 从url中获取邮件正文
	 * @version 2018年11月7日上午9:24:19
	 * @author ruhan.fan
	 * @param url url
	 * @return 邮件正文
	 * @throws MessagingException
	 * @throws MalformedURLException
	 */
	public static BodyPart getBodyFromUrl(String url) throws MessagingException, MalformedURLException {
		BodyPart mdp = new MimeBodyPart();
		URLDataSource ur = new URLDataSource(new URL(url));
		DataHandler dh = new DataHandler(ur);
		mdp.setDataHandler(dh);
		return mdp;
	}

	/**
	 * 添加文本附件
	 * @version 2018年11月7日上午9:26:20
	 * @author ruhan.fan
	 * @param content 内容
	 * @param showName 附件名
	 * @return 邮件正文
	 * @throws UnsupportedEncodingException 异常
	 * @throws MessagingException 异常
	 */
	public static BodyPart addAttachFromString(String content, String showName) throws UnsupportedEncodingException, MessagingException {
		BodyPart mdp = new MimeBodyPart();
		DataHandler dh = new DataHandler(content, TEXT);
		mdp.setFileName(MimeUtility.encodeWord(showName, ENCODING, null));
		mdp.setDataHandler(dh);
		return mdp;
	}

	/**
	 * 添加文件附件
	 * @version 2018年11月7日上午9:27:24
	 * @author ruhan.fan
	 * @param fileName 文件名
	 * @param showName 显示名
	 * @return 邮件正文
	 * @throws UnsupportedEncodingException
	 * @throws MessagingException
	 */
	public static BodyPart addAttachFromFile(String fileName, String showName) throws UnsupportedEncodingException, MessagingException {
		if ((showName == null) || (showName.trim().equals(""))) {
			showName = fileName.substring(fileName.indexOf("/") != -1 ? fileName.lastIndexOf("/") + 1 : 0);
		}
		BodyPart mdp = new MimeBodyPart();
		FileDataSource fds = new FileDataSource(fileName);
		DataHandler dh = new DataHandler(fds);
		mdp.setFileName(MimeUtility.encodeWord(showName, ENCODING, null));
		mdp.setDataHandler(dh);
		return mdp;
	}

	/**
	 * 添加附件
	 * @version 2018年11月7日上午9:28:29
	 * @author ruhan.fan
	 * @param url url
	 * @param showName 显示名
	 * @return 邮件正文
	 * @throws UnsupportedEncodingException
	 * @throws MessagingException
	 * @throws MalformedURLException
	 */
	public static BodyPart addAttachFromUrl(String url, String showName) throws UnsupportedEncodingException, MessagingException, MalformedURLException {
		if ((showName == null) || (showName.trim().equals(""))) {
			showName = url.substring(url.indexOf("/") != -1 ? url.lastIndexOf("/") + 1 : 0);
		}
		BodyPart mdp = new MimeBodyPart();
		URLDataSource ur = new URLDataSource(new URL(url));
		DataHandler dh = new DataHandler(ur);
		mdp.setFileName(MimeUtility.encodeWord(showName, ENCODING, null));
		mdp.setDataHandler(dh);
		return mdp;
	}

	/**
	 * 邮件发送
	 * @version 2018年11月7日上午9:29:20
	 * @author ruhan.fan
	 * @param host 邮件服务器主机
	 * @param port 邮件服务器端口
	 * @param userName 邮件服务器用户名
	 * @param password 邮件服务器密码
	 * @param from 发送方
	 * @param to 接收方
	 * @param subject 邮件主题
	 * @param content 邮件内容
	 * @param attachfile 附件
	 * @param type 邮件类型，TEXT或HTML等
	 * @param isAuth 是否做证书校验
	 * @param cc 抄送
	 * @param bc 密送
	 * @throws Exception 异常
	 */
	public static void send(String host, String port, String userName, String password, String from, String to, String subject, String content, String[] attachfile, String type, boolean isAuth, String cc, String bc) throws Exception {
		
		Transport transport = null;
		try {
			
			/*
			 *  参数校验
			 */
			if(StringUtils.isBlank(host)) {
				throw new Exception("没有指定发送邮件服务器");
			}
			
			if(StringUtils.isBlank(from)) {
				throw new Exception("没有指定发件人");
			}
			
			if(StringUtils.isBlank(to)) {
				throw new Exception("没有指定收件人地址");
			}
			
			
			/*
			 *  设置邮件服务器主机信息
			 */
			Properties props = new Properties();// 保存主机信息
			props.setProperty("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			
			// 是否做证书校验
			if (isAuth) {
				props.put("mail.smtp.starttls.enable", "true");
				props.setProperty("mail.smtp.auth", "true");
			}
			
			/*
			 *  封装邮件信息
			 */
			Session s = Session.getInstance(props, null);
			MimeMessage msg = new MimeMessage(s);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.addFrom(InternetAddress.parse(from)); // 发件人
			msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // 收件人
			if (StringUtils.isNotBlank(cc)) {
				msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc)); // 抄送
			}
			if (StringUtils.isNotBlank(bc)) {
				msg.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(bc)); // 密送
			}

			// 指定邮件容器
			Multipart mm = new MimeMultipart();
			// 设置邮件正文
			if (StringUtils.isNotBlank(content)) {
				if (StringUtils.isBlank(type)) {
					mm.addBodyPart(getBodyAsText(content));
				} else if (type.trim().toUpperCase().equals("HTML")) {
					mm.addBodyPart(getBodyAsHTML(content));
				} else if (type.trim().toUpperCase().equals("TEXT")) {
					mm.addBodyPart(getBodyAsText(content));
				} else {
					mm.addBodyPart(getBody(content, type.trim().toUpperCase()));
				}
			}
			// 指定邮件附件 
			if (attachfile != null) {
				for (int i = 0; i < attachfile.length; i++) {
					String fileName = attachfile[i];
					BodyPart part = addAttachFromFile(fileName, null);
					mm.addBodyPart(part);
				}
			}
			// 将转载容器放入邮件中
			msg.setContent(mm);

			// 保存前面的设置
			msg.saveChanges();
			
			
			/*
			 * 邮件发送
			 */
			transport = s.getTransport("smtp");
			transport.connect(host, userName, password);
			transport.sendMessage(msg, msg.getAllRecipients());
		} catch (Exception e) {
			logger.error("邮件发送失败！", e);
			throw new Exception("发送邮件失败:", e);
		} finally {
			if(transport != null) {
				transport.close();
			}
		}
	}

	/**
	 * 发送邮件
	 * @version 2018年11月7日上午9:47:34
	 * @author ruhan.fan
	 * @param host 邮件服务器主机
	 * @param port 邮件服务器端口
	 * @param userName 邮件服务器用户名
	 * @param password 邮件服务器密码
	 * @param from 发送方
	 * @param to 接收方
	 * @param subject 主题
	 * @param content 内容
	 * @param attachFile 附件
	 * @param type 类型（TEXT或HTML等）
	 * @param isAuth 是否需要验证证书
	 * @throws Exception 异常
	 */
	public synchronized static void send(String host, String port, String userName, String password, String from, String to, String subject, String content, String[] attachFile, String type, boolean isAuth) throws Exception {
		send(host, port, userName, password, from, to, subject, content, attachFile, type, isAuth, null, null);
	}

	/**
	 * 邮件发送
	 * @version 2018年11月7日上午9:49:37
	 * @author ruhan.fan
	 * @param host 邮件服务器主机
	 * @param port 邮件服务器端口
	 * @param userName 邮件服务器用户名
	 * @param password 邮件服务器密码
	 * @param from 发送方
	 * @param to 接收方(xxx@xxx.com,xxx@xxx.com,xxx@xxx.com)
	 * @param subject 主题
	 * @param content 内容
	 * @param type 类型（TEXT或HTML等）
	 * @param isAuth 是否需要验证证书
	 * @throws Exception 异常
	 */
	public void send(String host, String port, String userName, String password, String from, String to, String subject, String content, String type, boolean isAuth) throws Exception {
		send(host, port, userName, password, from, to, subject, content, null, type, isAuth, null, null);
	}

//	public static void main(String[] args) {
//		String host = "Mail.xgd.com";
//		String port = "587";
//		String from = "XLCreditReportSystem@xgd.com";
//		String username = "XLCreditReportSystem";
//		String password = "xgd.2018";
//		String to = "fanruhan@xgd.com,zhangjilong@xgd.com";
//		String cc = "huangdaye@xgd.com";
//
//		String subject = "测试GMAIL发送";
////		String content = "<a href=\"http://boolen.taobao.com\">淘宝服装城</a>";
//		String type = "html";
//		boolean isAuth = true;
//
//		String[] attachfile = null;
//		try {
//			
//			String content = MessageFormat.format(TxtReader.readAsString("email_report_apply.html", "UTF-8"), 
//				"测试公司", "", "X001", "05", "苏三", "15988888888", "18-11-7 下午1:50");
//			SendMailHandle.send(host, port, username, password, from, to, subject, content, attachfile, type, isAuth, cc, null);
//			System.out.println("系统信息邮件发送成功！！！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("系统信息邮件发送失败！！！");
//		}
//	}

}
