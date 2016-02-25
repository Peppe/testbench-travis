package org.vaadin.artur.testbenchtravis;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TextFieldElement;

public class BasicIT extends TestBenchTestCase {

    @Test
    public void simpleTest() {
        setDriver(new PhantomJSDriver());
        getDriver().get("http://localhost:8080/");

        TextFieldElement nameInput = $(TextFieldElement.class).first();
        nameInput.setValue("Jeff");
        ButtonElement helloButton = $(ButtonElement.class).caption("Click Me")
                .first();
        helloButton.click();

        LabelElement outputLabel = $(LabelElement.class).first();
        Assert.assertEquals("Thanks Jeff, it works!", outputLabel.getText());
    }
}
