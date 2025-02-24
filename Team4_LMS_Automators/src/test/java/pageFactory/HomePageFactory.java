package pageFactory;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.DriverFactory;

public class HomePageFactory {
	
	WebDriver driver = DriverFactory.getDriver();
	//WebDriverWait wait;
	@FindBy (id="mat-select-value-1")	WebElement SelectRole;
	@FindBy(id="mat-option-0")	WebElement AdminRole;
	@FindBy(id="login")WebElement Login;
	@FindBy(xpath="/html/body/app-root/app-header/mat-toolbar/span[1]") WebElement LMS;
	@FindBy(id="dashboard")	WebElement we_home;
	@FindBy(id="program") WebElement we_program;
	@FindBy(xpath = "/html/body/app-root/app-header/mat-toolbar/div/button[3]") WebElement we_batch;
	@FindBy(xpath = "/html/body/app-root/app-header/mat-toolbar/div/button[4]") WebElement we_class;
	@FindBy(id="logout") WebElement we_logout;
	@FindBy(xpath= "/html/body/app-root/app-header/mat-toolbar/span[1]") WebElement LMStitle;
	@FindBy(xpath = "/html/body/app-root/app-header/mat-toolbar/div") WebElement navBarText;
	@FindBy(xpath="//strong[normalize-space()='Welcome sdetnumpyninja@gmail.com']")	WebElement welcomeMessage;
	@FindBy(xpath="//div[contains(text(), '49')]") WebElement UserCount;
	@FindBy(xpath="//div[contains(text(), '21')]") WebElement StaffCount;
	
	
	
	@FindBy(xpath = "//button[@aria-label='Previous page']") WebElement previousPageIcon;
	@FindBy(xpath="//*[name()='path' and contains(@d,'M18.41 16.')]") WebElement firstPageIcon;
	@FindBy(xpath="//mat-card-content[@class='mat-card-content']//canvas[@class='chartjs-render-monitor']")	WebElement BarGraph;
	@FindBy(xpath="//app-doughnutchart") WebElement PieChart;
	
	
		
//	@FindBy(xpath="//div[contains(text(), 'Batches')]") WebElement batchCount;
//	@FindBy(partialLinkText="Batches") WebElement batchCount;
//	@FindBy(xpath = "//div[@class='widget red'] or //div[contains(@class, 'value')]") WebElement BatchCount;
//	@FindBy(css = "div.widget.red div.value") WebElement BatchCount;	
//    @FindBy(xpath="//div[contains(text(), '/batch']") WebElement BatchCount;
//	@FindBy(className="pi pi-sitemap") WebElement BatchCount;
//	@FindBy(xpath="//div[contains(text(), '237')]") WebElement ProgramCount;
//	@FindBy(xpath="mat-table cdk-table table-container mat-elevation-z8") List<WebElement> staffRows;
//	/html/body/app-root/app-home/div/app-dashboard/div/div[3]/mat-grid-list/div/mat-grid-tile[1]/figure/div/app-staffdata/mat-table
////	xpath /html/body/app-root/app-dashboard/div/div[3]/mat-grid-list/div/mat-grid-tile[1]/figure/div/app-staffdata/mat-table
////	classname mat-table cdk-table table-container mat-elevation-z8
//	@FindBy(xpath = "//div[@class='pagination-icons']") WebElement paginationIcons;//
//    @FindBy(xpath = "//table[@id='staffTable']/tbody/tr") List<WebElement> staffRows; 
//	@FindBy(xpath="//div[normalize-space()='49']") Web Element 
	
	
	
	// constructor
    public HomePageFactory() {
//    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    //methods
    public String getHomePageTitle() {
        return driver.getTitle();
    }
    
	public String pagetitle() {
		return driver.getTitle();
	}

	public void selectrole() {
		SelectRole.click();
		AdminRole.click();
	}
	
	public void clicklogin() {
		Login.click ();
	}
	
	public boolean get_lms_location() {
		if (LMS.getLocation().getX() < 50) {
			return true;
		}else {
			return false;
		}
	}
	
	public String get_toolbar_elements_text() {
		return we_home.getText() + we_program.getText() + we_batch.getText() + we_class.getText() + we_logout.getText();
	}
	
	public String getLMSTitleText() {
		return LMStitle.getText();
	}
	
	public boolean getnavBarLoc() {
// check the location of the Text on Top Right
		 if ( navBarText.getLocation().getX() > 50 && navBarText.getLocation().getY() < 50 ) {
			 return true;
		 }else {
			 return false;
		 }
	}
	
	public WebElement get_webelement(String element) {
		WebElement we = null;
		switch (element) {
			case "home": we = we_home; break;
			case "program": we = we_program; break;
			case "batch": we = we_batch; break;
			case "class": we = we_class; break;
			case "logout": we = we_logout; break;
			case "bargraph": we = BarGraph; break;
			case "doughnut": we = PieChart; break;
			case "prePage": we = previousPageIcon; break;
			case "firstPage": we = firstPageIcon; break;
			case "UserCount": we = UserCount; break;
			case "StaffCount" : we = StaffCount; break;			
//			case "batchCount" : we = batchCount; break;
//			case "ProgramCount" : we = ProgramCount; break;
		}
		return we;
	}
	
    public boolean toolBarElement_place(WebElement webElement, int i) {
// get the positions into an array and sort the positions	
    	int[] xPos = {	we_home.getLocation().getX(),
						we_program.getLocation().getX(),
						we_batch.getLocation().getX(),
						we_class.getLocation().getX(),
						we_logout.getLocation().getX()
	 		 		};
    	Arrays.sort(xPos);
// Verify the location of the WebElement
    	if ( xPos[i] == webElement.getLocation().getX()) {
    		return true;
    	}else {
    		return false;
    	}
    }

	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}	
	
	public Boolean isDisplayed(WebElement webElement) {
        if (webElement.isDisplayed()) {
            return true;
        } else {
            return false;
        }
	}

	public boolean isEnabled(WebElement webElement) {
        if (webElement.isEnabled()) {
            return true;
        } else {
            return false;
        }
	}

    public int getStaffCount() {
//        return staffRows.size();
//        Object[] rows = staffRows.toArray();
//        for (int i = 0; i < rows.length; i++ ) {
////        	System.out.println( rows[ i ].getClass().getName() );
//        	System.out.println(rows[i]);
//        }
        return 0;
        
    }
    
    
	
	
	
}








	






  

  

