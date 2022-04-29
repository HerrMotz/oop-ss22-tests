const puppeteer = require("puppeteer");

(async () => {
    const browser = await puppeteer.launch({ headless: false });
    const page = await browser.newPage();
    await page.goto('https://moodle.uni-jena.de/login/index.php');
    await page.click('a[title="Login der Friedrich-Schiller-Universität"]');
    await page.waitForNavigation();

    await page.type('#username', "");
    await page.type('#password', "");
    await page.click('button[name="_eventId_proceed"]');
    await page.waitForNavigation();

    await page.goto('https://moodle.uni-jena.de/course/view.php?id=26958');
    await page.waitForNavigation();

    const [assignments] = await page.$x("//a[contains(@href, 'assign')]");
    if (assignments) {
        for (const assignment in assignments) {
            // link contains something like this
            // https://moodle.uni-jena.de/mod/assign/view.php?id=641374
            console.log(assignment)

        }
    }
    await browser.close();
})();

