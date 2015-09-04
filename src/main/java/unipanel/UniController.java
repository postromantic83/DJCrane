package unipanel;

/**
 * Created by SashaNote on 03.09.2015.
 */
public class UniController implements UniPanelController {

    protected UniModel model;



    @Override
    public void setUniModel(UniModel model) {
    this.model = model;
    }

    @Override
    public void setButtonPanelView(ButtonPanelView view) {

    }

    @Override
    public void start() {

    }

    @Override
    public void addElement(String name) {

    }

    @Override
    public int getValue(String name) {
        return 0;
    }
}
