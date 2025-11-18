import com.microsoft.playwright.*;

public class TestScenario {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Step 1: Navigate to the website
            page.navigate("https://test.epm-sbcm.projects.epam.com/dev/login?epamId=4060741400311603918");

            // Step 2: Click on 'New line item' button
            page.locator("text=New line item").click();

            // Step 3: Click on 'Report expense' button
            page.locator("text=Report expense").click();

            // Step 4: Wait for 3 seconds
            page.waitForTimeout(3000);

            // Step 5: Click on the 'Contractor' input field
            page.locator("[placeholder='Select']").click();

            // Step 6: Enter the 'Agency Worker' value into the 'Contractor' field
            page.locator("text=Agency Worker").click();

            // Step 7: Wait for 3 seconds
            page.waitForTimeout(3000);

            // Step 8: Enter the '01.10.2025' value into the 'Start date' field
            page.locator("[placeholder='DD.MM.YYYY']").first().fill("01.10.2025");

            // Step 9: Enter the '31.10.2025' value into the 'End date' field
            page.locator("[placeholder='DD.MM.YYYY']").nth(1).fill("31.10.2025");

            // Step 10: Click 'Tab' key button twice
            page.keyboard().press("Tab");
            page.keyboard().press("Tab");

            // Step 11: Click on the 'Enter' key button
            page.keyboard().press("Enter");

            // Step 12: Select the 'US sales tax' value
            page.locator("text=US sales tax").click();

            // Step 13: Click on the 'Project / Cost object' input field
            page.locator("[placeholder='Select']").nth(1).click();

            // Step 14: Select the 'EPM-SBCM' value
            page.locator("text=EPM-SBCM").click();

            // Step 15: Click on the 'Net amount' input field
            page.locator("[placeholder='0.00']").click();

            // Step 16: Enter the '1000' value
            page.locator("[placeholder='0.00']").fill("1000");

            // Step 17: Click on the 'Description' input field
            page.locator("[placeholder='To speed up the review by the SBC Team, describe the expense or work in detail here']").click();

            // Step 18: Enter the '1000' value
            page.locator("[placeholder='To speed up the review by the SBC Team, describe the expense or work in detail here']").fill("1000");

            // Step 19: Click on the 'Save' button
            page.locator("text=Save").click();

            // Close the browser
            browser.close();
        }
    }
}