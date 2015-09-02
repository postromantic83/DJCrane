package controller;

import org.junit.Test;
import view.CraneComboboxPanel;
import view.CranePanel;
import view.LiebherrControl;

/**
 * Created by SashaNote on 02.09.2015.
 */
public class LiebherrCraneTest {

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testMakeTower() throws Exception {

    }

    @Test
    public void testGetTower() throws Exception {

    }

    @Test
    public void testCreateControl() throws Exception {

    }

    CranePanel cranePanel = new CranePanel();
    CraneComboboxPanel craneComboboxPanel = new CraneComboboxPanel(cranePanel);


    LiebherrCrane crane = new LiebherrCrane(craneComboboxPanel);
    LiebherrControl liebherrControl = new LiebherrControl(crane, cranePanel);


    @Test
    public void testConcreteTowerCrane() throws Exception {


    }

    @Test
    public void testGetHeight() throws Exception {

    }

    @Test
    public void testGetHeightUnderJib() throws Exception {

    }
}