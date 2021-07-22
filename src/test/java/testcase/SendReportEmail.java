package testcase;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.annotations.Test;

public class SendReportEmail
{

    @Test(testName = "Send Report Email" )
    public void sendingMail()

    {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("C:/Users/arieh/Documents/AutomatedTest/BP_Arie_Selenium_OrangeHRM/Reports/NewReport.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Test OrangeHRM");
        attachment.setName("Test Report File");

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("ariehutajulu@gmail.com", "passwod"));
        email.setSSLOnConnect(true);

        try
        {
            email.setFrom("ariehutajulu@gmail.com");
        }

        catch (EmailException e)
        {
            e.printStackTrace();
        }

        email.setSubject("Test Report File");

        try
        {
            email.setMsg("Hello Sir/Madam , This is a report of Selenium Test OrangHRM Web By Arie");
        }

        catch (EmailException e)
        {
            e.printStackTrace();
        }

        try
        {
            email.addTo("ariehutajulu20@gmail.com");
        }
        catch (EmailException e)
        {
            e.printStackTrace();
        }

        try
        {
            email.attach(attachment);
        }

        catch (EmailException e)
        {
            e.printStackTrace();
        }

        try
        {
            email.send();
        }

        catch (EmailException e)
        {
            e.printStackTrace();
        }

        System.out.println("Test file has been sent successfully.");
    }

}
