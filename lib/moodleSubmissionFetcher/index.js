const
    puppeteer = require("puppeteer")
    require("dotenv").config();

(async () => {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto('https://moodle.uni-jena.de/login/index.php');
    await page.click('a[title="Login der Friedrich-Schiller-Universität"]');
    await page.waitForNavigation();

    await page.type('#username', process.env.MOODLE_USERNAME);
    await page.type('#password', process.env.MOODLE_PASSWORD);
    await page.click('button[name="_eventId_proceed"]');
    await page.waitForNavigation();

    const formErrors = await page.$("p.form-error")
    if (formErrors) {
        const errorMessages = await formErrors.map(x => x.textContent)
        await console.error("There has been an error while logging in: " + errorMessages);
        await browser.close();
        return;
    }

    await page.screenshot({path: "Lol2.png"})

    await page.goto('https://moodle.uni-jena.de/course/view.php?id=26958');

    await page.screenshot({path: "Lol.png"})

    const assignments = await page.$$eval("a[href*='assign']", el => el.map(x => x.getAttribute("href")));
    if (assignments) {
        // link contains something like this
        // https://moodle.uni-jena.de/mod/assign/view.php?id=641374
        console.log(assignments)

        let idFromLink = new RegExp(/mod\/assign\/view\.php\?id=(\d+)/i);

        for (let assignment of assignments) {
            const [match, assignmentId] = idFromLink.exec(assignment)

            await page.goto(`https://moodle.uni-jena.de/mod/assign/view.php?id=${assignmentId}&action=grading`)
            await page.waitForNavigation();

            await page.select("#id_filter", "requiregrading");

            const groupSelectorLabel = (await page.$$("label")).find(el => el.textContent === 'Sichtbare Gruppen').getAttribute("for")


            // console.log("https://moodle.uni-jena.de/mod/assign/view.php?id=" + assignmentId + "&action=grading&page=" + pageNumber)
        }
    }
    await browser.close();
})();

