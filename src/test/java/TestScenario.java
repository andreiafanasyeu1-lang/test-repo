import com.microsoft.playwright.*;

public class TestScenario {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Step 1: Navigate to the website
            page.navigate("https://test.epm-sbcm.projects.epam.com/dev/login?epamId=4060741400311603918");

            // Step 2: Click on 'New line item' button
            page.click("button:has-text('New line item')");

            // Step 3: Click on 'Report expense' button
            page.click("text=Report expense");

            // Step 4: Wait for 3 seconds
            page.waitForTimeout(3000);

            // Step 5: Click on the 'Contractor' input field
            page.click("[placeholder='Select']");

            // Step 6: Enter the 'Agency Worker' value into the 'Contractor' field
            page.click("text=Agency Worker");

            // Step 7: Wait for 3 seconds
            page.waitForTimeout(3000);

            // Step 8: Enter the '01.10.2025' value into the 'Start date' field
            page.fill("[placeholder='DD.MM.YYYY']", "01.10.2025");

            // Step 9: Enter the '31.10.2025' value into the 'End date' field
            page.fill("[placeholder='DD.MM.YYYY']", "31.10.2025");

            // Step 10: Click 'Tab' key button twice
            page.keyboard().press("Tab");
            page.keyboard().press("Tab");

            // Step 11: Click on the 'Enter' key button
            page.keyboard().press("Enter");

            // Step 12: Select the 'US sales tax' value
            page.click("text=US sales tax");

            // Step 13: Click on the 'Project / Cost object' input field
            page.click("[placeholder='Select']");

            // Step 14: Select the 'EPM-SBCM' value
            page.click("text=EPM-SBCM");

            // Step 15: Click on the 'Net amount' input field
            page.click("[placeholder='0.00']");

            // Step 16: Enter the '1000' value
            page.fill("[placeholder='0.00']", "1000");

            // Step 17: Click on the 'Description' input field
            page.click("[placeholder='To speed up the review by the SBC Team, describe the expense or work in detail here']");

            // Step 18: Enter the '1000' value
            page.fill("[placeholder='To speed up the review by the SBC Team, describe the expense or work in detail here']", "1000");

            // Step 19: Click on the 'Save' button
            page.click("button:has-text('Save')");

            // Close the browser
            browser.close();
        }
    }
}