import com.microsoft.playwright.*;

public class TestScenario {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Step 1: Navigate to the website
            page.navigate("https://test.epm-sbcm.projects.epam.com/dev/login?epamId=4060741400311603918");
            page.waitForTimeout(3000);

            // Step 2: Click on 'New line item' button
            page.getByRole("button", new Page.GetByRoleOptions().setName("New line item")).click();

            // Step 3: Click on 'Report expense' button
            page.getByRole("menuitem", new Page.GetByRoleOptions().setName("Report expense")).click();

            // Step 4: Wait for 3 seconds
            page.waitForTimeout(3000);

            // Step 5: Click on the 'Contractor' input field
            page.getByTestId("contractor").click();

            // Step 6: Select 'Agency Worker' value from the dropdown
            page.getByRole("option", new Page.GetByRoleOptions().setName("Agency Worker")).click();

            // Step 7: Wait for 3 seconds
            page.waitForTimeout(3000);

            // Step 8: Enter '01.10.2025' into the 'Start date' field
            page.getByRole("textbox", new Page.GetByRoleOptions().setName("DD.MM.YYYY")).first().fill("01.10.2025");

            // Step 9: Enter '31.10.2025' into the 'End date' field
            page.getByRole("textbox", new Page.GetByRoleOptions().setName("DD.MM.YYYY")).nth(1).fill("31.10.2025");

            // Step 10: Press 'Tab' key twice
            page.keyboard().press("Tab");
            page.keyboard().press("Tab");

            // Step 11: Press 'Enter' key
            page.keyboard().press("Enter");

            // Step 12: Select 'US sales tax' value
            page.getByRole("option", new Page.GetByRoleOptions().setName("US sales tax")).click();

            // Step 13: Click on the 'Project / Cost object' input field
            page.getByTestId("project-cost-object").click();

            // Step 14: Select 'EPM-SBCM' value
            page.getByRole("option", new Page.GetByRoleOptions().setName("EPM-SBCM")).click();

            // Step 15: Click on the 'Net amount' input field
            page.getByRole("textbox", new Page.GetByRoleOptions().setName("0.00")).click();

            // Step 16: Enter '1000' value into the 'Net amount' field
            page.getByRole("textbox", new Page.GetByRoleOptions().setName("0.00")).fill("1000");

            // Step 17: Click on the 'Description' input field
            page.getByRole("textbox", new Page.GetByRoleOptions().setName("To speed up the review by the")).click();

            // Step 18: Enter '1000' value into the 'Description' field
            page.getByRole("textbox", new Page.GetByRoleOptions().setName("To speed up the review by the")).fill("1000");

            // Step 19: Click on the 'Save' button
            page.getByRole("button", new Page.GetByRoleOptions().setName("Save")).click();

            // Close the browser
            browser.close();
        }
    }
}