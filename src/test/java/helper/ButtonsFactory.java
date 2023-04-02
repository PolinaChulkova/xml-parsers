package helper;

import org.example.model.screenDom.ButtonDom;
import org.example.model.screenDom.DDom;

public class ButtonsFactory {

    public ButtonDom getNewOfferButton() {
        return createButton("Новый заказ", "Заказать книгу", "Заказать тетрадь");
    }

    public ButtonDom getReturnButtonProduct() {
        return createButton("Возврат", "Оформить возврат");
    }

    public ButtonDom getHistoryButton() {
        return createButton("История покупок", "За весь период", "За последний месяц", "За последний год");
    }

    private ButtonDom createButton (String t, String ...d) {
        ButtonDom button = new ButtonDom();
        button.setT(t);
        for (String value : d) {
            button.getDDomList().add(new DDom().withD(value));
        }
        return button;
    }
}
