package com.crm.campaign;

import com.crm.Object_Repository.CampaignInformation;

import com.crm.Object_Repository.CampaignListPage;
import com.crm.Object_Repository.CreatingNewCampaign;
import com.crm.Object_Repository.HomePage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Generic_utilities.BaseClass;
import com.crm.Generic_utilities.Excel_Utility;
import com.crm.Generic_utilities.File_Utility;
import com.crm.Generic_utilities.Java_Utility;
import com.crm.Generic_utilities.WebDriver_Utility;
import com.crm.Object_Repository.HomePage;
import com.crm.Object_Repository.LoginPage;

@Listeners(com.crm.Generic_utilities.ListenerImplementationClass.class)
public class CreateCampaignTest extends BaseClass{
	@Test(groups = {"smokeTest"})
public void createCampaignTest() throws EncryptedDocumentException, IOException
{
	File_Utility flib=new File_Utility();
	Excel_Utility elib=new Excel_Utility();
	Java_Utility jlib=new Java_Utility();
	WebDriver_Utility wlib=new WebDriver_Utility();

	wlib.toMaximizeBrowser(driver);
	wlib.waitForPageToLoad(driver);
	System.out.println("Pushing back to github");

HomePage home=new HomePage(driver);
home.clickToCampaign(driver);
CampaignListPage clist=new CampaignListPage(driver);
clist.getCreateCampaign().click();
//Assert.fail();
System.out.println("Pushing the file to Framework");
String value = elib.getExcelData("campaign", 0, 0);
CreatingNewCampaign createCamp=new CreatingNewCampaign(driver);
createCamp.setCampaignNameTxtBox(value);
createCamp.getSaveButton().click();

CampaignInformation campInfor=new CampaignInformation(driver);
campInfor.validationOfPage(driver,value);

}
}
