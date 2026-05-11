package CompleteFramework.seleniumweb;

import org.testng.annotations.Test;

import CompleteFramework.seleniumweb.PageObjects.ForgotPasswordPage;
import CompleteFramework.seleniumweb.TestComponents.BaseTest;

public class ForgotPasswordexe extends BaseTest {
	
	
	@Test
	public void ForgotPasswordexe()
	{
		
		    ForgotPasswordPage forgotPasswordPage =
		    landingPage.ForgotPassword();
		    
		    forgotPasswordPage.ResetPasswordPage("somesh26@gmail.com", "password@1", "password@1");
		}


	}


