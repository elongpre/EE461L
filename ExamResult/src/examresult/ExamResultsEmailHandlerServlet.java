package examresult;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examresult.dao.ExamResultDAO;
import examresult.entity.ExamResult;

public class ExamResultsEmailHandlerServlet  extends HttpServlet {
	public static final Logger _log = Logger.getLogger(ExamResultsEmailHandlerServlet.class.getName());

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		try {
			MimeMessage message = new MimeMessage(session, req.getInputStream());
			Address[] fromAddresses = message.getFrom();
			String studentID  = message.getSubject();

			//Retrieve the results
			String strCallResult = "";
			ExamResult ER = ExamResultDAO.INSTANCE.getExamResult(studentID);
			strCallResult = "Student ID Number : " + ER.getIdNumber().getName() + "\r\n";
			strCallResult += "Student Name : " + ER.getName() + "\r\n";
			strCallResult += "Exam 1 Grade : " + ER.getGrade1() + "\r\n";
			strCallResult += "Exam 2 Grade : " + ER.getGrade2() + "\r\n";
			strCallResult += "=================================" + "\r\n";
			strCallResult += "Thank you for using the Exam Helper Bot" + "\r\n";
				
			//Send out Email
			MimeMessage outMessage = new MimeMessage(session);
			outMessage.setFrom(new InternetAddress("admin@thoughtless-fog-3306.appspotmail.com"));
			outMessage.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(fromAddresses[0].toString()));
			outMessage.setSubject("Your Exam Results");
			outMessage.setText(strCallResult);
			Transport.send(outMessage);
		}
		catch (MessagingException e) { 
			_log.info("ERROR: Could not send out Email Results response : " + e.getMessage());
		}
	}
}
