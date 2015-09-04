package unipanel;

/**
 * Created by SashaNote on 03.09.2015.
 */
public interface UniPanelController {


   void setUniModel(UniModel model);
   void setButtonPanelView (ButtonPanelView view);
    void start ();


    public void addElement (String name);

    public int getValue(String name);




}
