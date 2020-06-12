package store.utils;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
/**
 * 发送邮件的工具类
 */
public class MailUtils {
	public static void sendMail(String email, String emailMsg)
			throws AddressException, MessagingException {
		// 1.创建一个程序与邮件服务器会话对象 Session
		Properties props = new Properties();
		// 设置邮件传输协议为SMTP
		props.setProperty("mail.transport.protocol", "SMTP");
		// 设置SMTP服务器地址
		props.setProperty("mail.host", "smtp.qq.com");
		// 发送端口
		props.setProperty("mail.smtp.port", "465");
		// 设置SMTP服务器是否需要用户验证，需要验证设置为true
		props.setProperty("mail.smtp.auth", "true");
		//打印信息到控制台
		props.setProperty("mail.debug", "true");
		//发送的协议是smtp
		props.setProperty("mail.transport", "smtp");
		//ssl
		props.setProperty("mail.smtp.ssl.enable", "true");
		System.out.println("邮件调试用1");

		// 2.创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("2855263646@qq.com", "bpyhllbmqtwrdhbc");
			}
		};
		Session session = Session.getInstance(props, auth);
		System.out.println("邮件调试用2");
		
		
		// 3.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("2855263646@qq.com")); // 设置发送者
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者
		message.setSubject("确认订单");
		message.setContent(emailMsg, "text/html;charset=utf-8");
		
		
		// 4.创建 Transport用于将邮件发送
		Transport.send(message);
		System.out.println("邮件调试用3");
	}
}
