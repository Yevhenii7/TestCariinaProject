package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.TestTag;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecss;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPages;
import com.qaprosoft.carina.demo.gui.pages.FooterMenuPage;
import com.qaprosoft.carina.demo.gui.pages.HomePages;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CompareMobileTest extends AbstractTest {

    @Test(description = "JIRA#AUTO-0009")
    @MethodOwner(owner = "Kolchyba Yevheniy")
    public void testCompareMobile() {
        HomePages homePages = new HomePages(getDriver());
        homePages.open();
        Assert.assertTrue(homePages.isPageOpened(), "Home page is not opened");

        FooterMenuPage footerMenuPage = homePages.getFooterMenu();
        Assert.assertTrue(footerMenuPage.isUIObjectPresent(2), "Footer menu page is not opened");

        CompareModelsPages compareModelsPages = footerMenuPage.openComparePage();

        List<ModelSpecss> specs = compareModelsPages.compareModels("Samsung Galaxy J3", "Samsung Galaxy J5", "Samsung Galaxy J7 Pro");
        Assert.assertEquals(specs.get(0).readSpec(ModelSpecss.SpecType.ANNOUNCED),"2016, March 31. Released 2016, May 06");
        Assert.assertEquals(specs.get(1).readSpec(ModelSpecss.SpecType.ANNOUNCED),"2015, June 19. Released 2015, July 28");
        Assert.assertEquals(specs.get(2).readSpec(ModelSpecss.SpecType.ANNOUNCED),"2017, June");

    }
}
