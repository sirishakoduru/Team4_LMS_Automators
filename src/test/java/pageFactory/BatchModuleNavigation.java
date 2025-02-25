package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import driver.DriverFactory;
import utilities.ConfigReader;

public class BatchModuleNavigation {

	WebDriver driver=DriverFactory.getDriver();
	//driver.manage().window().maximize();
	ConfigReader reader=new ConfigReader();
	String baseURL = ConfigReader.baseUrl();
	
	@FindBy(xpath="//div//button[3][@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']")
	WebElement BatchButton;
	
	@FindBy(id="dashboard")
	WebElement Homebutton;
	
	@FindBy(xpath="//div[2]//div//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement DeleteAll_Btn;
	
	@FindBy(xpath="//app-root//app-header//mat-toolbar//span[contains(text(),' LMS - Learning Management System ')]")
	WebElement LMSTitle;
	
	@FindBy(xpath="//div//mat-card//mat-card-title/div[1][contains(text(),'Manage Batch')]")
	WebElement Title;
	
	@FindBy(xpath="//div//button[3][@class='p-paginator-next p-paginator-element p-link p-ripple']")
	WebElement NextPage_Pagination;
	 
	@FindBy(xpath="//table/tbody/tr//button[contains(@icon, 'pi-pencil')]")
	List<WebElement> AllEditIcons;
	
	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-trash')]") 
	List<WebElement> allDeleteIcons;
	
	@FindBy(xpath="//p-tablecheckbox//div//div[2][@class='p-checkbox-box p-component']")
	List<WebElement> AllCheckbox;

	@FindBy(xpath="//div//table//thead[@class='p-datatable-thead']")
	WebElement Datatable;
	
	@FindBy(xpath="//div//table//thead//tr[@class='ng-star-inserted']")
	List<WebElement> HeaderNames;
	
	@FindBy(xpath="//p-tableheadercheckbox//div//div[2]//span[@class='p-checkbox-icon']")
	WebElement Header_Checkbox;
	
	@FindBy(xpath="//thead//tr//th[2]//p-sorticon//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	List<WebElement> SortIcons;
	
	public BatchModuleNavigation() {
		PageFactory.initElements(driver, this);
	}
	
	public void click_HomeButton() {
		Homebutton.click();
	}
	
	public void click_BatchModule() {
		BatchButton.click();
	}
	
	public void Verify_Title_Manage_Batch() {
		String act_Title=Title.getText();
		String Exp_title="Manage Batch";
		Assert.assertEquals(act_Title, Exp_title);
		
	}
	
	public void Verify_LMSTitle() {
		String act_Title=LMSTitle.getText();
		String exp_title="LMS - Learning Management System";
		Assert.assertEquals(act_Title, exp_title);
	}
	
	@SuppressWarnings("deprecation")
	public void verify_DeleteAll_Disabled() {
		boolean isDisabled=DeleteAll_Btn.getAttribute("disabled")!=null;
		 // Print the result
        if (isDisabled) {
            System.out.println("The button is disabled.");
        } else {
            System.out.println("The button is enabled.");
        }
	}
	
	public void verify_NextPage_Pagination_Enabled() {
		NextPage_Pagination.isEnabled();
	}
	
	public boolean Edit_Icon_Each_Row() {
        boolean allEditIconsEnabled = true;
        for (WebElement editIcon : AllEditIcons) {
            if (!editIcon.isEnabled()) {
                System.out.println("Edit icon is not enabled: " + editIcon.getText());
                allEditIconsEnabled = false;
            }
        }
        return allEditIconsEnabled;
    }
    
	public boolean Delete_Icon_Each_row() {
        boolean allIconsEnabled = true;
        for (WebElement deleteIcon : allDeleteIcons) {
            if (!deleteIcon.isEnabled()) {
                System.out.println("Delete icon is not enabled: " + deleteIcon.getText());
                allIconsEnabled = false;
            }
        }
        return allIconsEnabled;
    }
	
	public boolean Checkbox_Icon_Each_Row() {
		boolean allIconsEnabled=true;
		for (WebElement Checkbox_Icon : AllCheckbox) {
			if (!Checkbox_Icon.isEnabled()) {
				System.out.println("Checkbox icon is not enabled:"+ Checkbox_Icon.getText() );
				allIconsEnabled=false;
			}
		}
		return allIconsEnabled;
	}
	
	public void Header_Validation() {
		//List of Header names
		String []ExpectedHeader= {"Batch Name ","Batch Description ","Batch Status ","No Of Classes ","Program Name "," Edit / Delete "};
		//Validate Header
		for (int i = 0; i < HeaderNames.size(); i++) {
			String actualHeaderText = HeaderNames.get(i).getText();
			if (actualHeaderText.equals(ExpectedHeader[i])) {
                System.out.println("Header validated: " + actualHeaderText);
            } else {
                System.out.println("Header mismatch at index " + i + ": Expected '" + ExpectedHeader[i] + "', but found '" + actualHeaderText + "'");
            }
		}
	}
	
	public boolean TableHeader_Checkbox() {
		boolean checkbox=true;
		if (Header_Checkbox.isEnabled()) {
			System.out.println("Checkbox for header is present");
			checkbox=false;
		}
		return checkbox;
	}
	
	public boolean Sort_Icon_Table() {
		boolean icons=false;
		for (WebElement iconlist : SortIcons) {
			if (iconlist.isEnabled()) {
				System.out.println("Sort Icons are present");
				icons=true;
			}
			else {
				System.out.println("Sort icon not found");
			}
		}
		return icons;
	}
	
}
