package tests;

import helper.ButtonsFactory;
import org.example.dom.DomUnmarshaller;
import org.example.model.screenDom.ButtonDom;
import org.example.model.screenDom.DDom;
import org.example.model.screenDom.ScreenDom;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class CheckMinScreenTest {

    ButtonsFactory buttonsFactory = new ButtonsFactory();
    SoftAssert softAssert = new SoftAssert();
    DomUnmarshaller unmarshaller = new DomUnmarshaller();

    @Test
    public void checkDisplayButtonsOfMainScreenTest() throws ParserConfigurationException, IOException, SAXException {
        ScreenDom screenDom = getScreen();
        checkButtonsOfResponse(softAssert, screenDom, buttonsFactory.getNewOfferButton(),
                buttonsFactory.getReturnButtonProduct(), buttonsFactory.getHistoryButton());
        softAssert.assertAll();
    }

    public SoftAssert checkButtonsOfResponse(SoftAssert softAssert, ScreenDom screen, ButtonDom... verifiableButtons) {
        List<ButtonDom> buttons = screen.getButtons();

        for (ButtonDom verifiableButton : verifiableButtons) {
            List<DDom> dList = verifiableButton.getDDomList();
            ButtonDom button = buttons.stream()
                    .filter(b -> ((b.getT()).equals(verifiableButton.getT())))
                    .findFirst()
                    .orElse(null);

            if (button == null) {
                softAssert.fail("В ответе на экране '" + screen.getTitle() + "' отсутствует кнопка '"
                        + verifiableButton.getT() + "'.");
            } else {

                for (DDom d : dList) {
                    DDom dDom = button
                            .getDDomList().stream()
                            .filter(dd -> (dd.getD()).equals(d.getD()))
                            .findFirst()
                            .orElse(null);

                    if (dDom == null) {
                        softAssert.fail("В ответе на экране '" + screen.getTitle() + "' в кнопке '" + verifiableButton.getT()
                                + "' отсутствует подсказка '" + d.getD() + "'.");
                    }
                }
            }
        }
        return softAssert;
    }

    private ScreenDom getScreen() {
        return unmarshaller.unmarshalScreenDom("body.xml");
    }
}
