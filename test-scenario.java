import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class TestScenario {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the website
            page.navigate("https://test.epm-sbcm.projects.epam.com/dev/login?epamId=4060741400311603918");

            // Click on 'New line item' button
            page.click("text=New line item");

            // Click on 'Report expense' button
            page.click("text=Report expense");

            // Wait for 3 seconds
            page.waitForTimeout(3000);

            // Click on the 'Contractor' input field
            page.click("[placeholder='Select']");

            // Enter the 'Agency Worker' value into the 'Contractor' field
            page.fill("[placeholder='Select']", "Agency Worker");

            // Click on the 'Agency Worker' value on the drop down
            page.click("text=Agency Worker");

            // Wait for 3 seconds
            page.waitForTimeout(3000);

            // Enter the '01.10.2025' value into the 'Start date' field
            page.fill("[placeholder='DD.MM.YYYY']", "01.10.2025");

            // Enter the '31.10.2025' value into the 'End date' field
            page.fill("[placeholder='DD.MM.YYYY']", "31.10.2025");

            // Click 'Tab' key button twice
            page.keyboard().press("Tab");
            page.keyboard().press("Tab");

            // Click on the 'Enter' key button
            page.keyboard().press("Enter");

            // Select the 'US sales tax' value
            page.click("text=US sales tax");

            // Click on the 'Project / Cost object' input field
            page.click("[placeholder='Select']");

            // Select the 'EPM-SBCM' value
            page.click("text=EPM-SBCM");

            // Click on the 'Net amount' input field
            page.click("[placeholder='0.00']");

            // Enter the '1000' value
            page.fill("[placeholder='0.00']", "1000");

            // Click on the 'Description' input field
            page.click("[placeholder='To speed up the review by the SBC Team, describe the expense or work in detail here']");

            // Enter the '1000' value
            page.fill("[placeholder='To speed up the review by the SBC Team, describe the expense or work in detail here']", "1000");

            // Click on the 'Save' button
            page.click("text=Save");

            // Close the browser
            browser.close();
        }
    }
}
