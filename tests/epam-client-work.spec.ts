import { test, expect } from '@playwright/test';

test('EPAM Client Work Page Test', async ({ page }) => {
  // Step 1: Navigate to https://www.epam.com/
  await page.goto('https://www.epam.com/');

  // Step 2: Select "Services" from the header menu
  await page.getByRole('link', { name: 'Services' }).nth(1).click();

  // Step 3: Click the "Explore Our Client Work" link
  await page.getByRole('link', { name: 'Explore Our Client Work' }).click();

  // Step 4: Verify that the "Client Work" text is visible on the page
  const isClientWorkVisible = await page.evaluate(() => document.body.innerText.includes('Client Work'));
  expect(isClientWorkVisible).toBeTruthy();
});