package unipanel;

import java.util.Observable;

/**
 * Created by SashaNote on 03.09.2015.
 */
public class UniModel extends Observable {
    UniPanelController uPanel;

    UniModel(UniPanelController panel){
        this.uPanel = panel;

    }





    void addContainer (String name) {

        setChanged();
        notifyObservers();

    }

    void removeContainer (String name) {

        setChanged();
        notifyObservers();

    }







}
