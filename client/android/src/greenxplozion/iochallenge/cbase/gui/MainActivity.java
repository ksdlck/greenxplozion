package greenxplozion.iochallenge.cbase.gui;

import greenxplozion.iochallenge.cbase.R;
import android.app.Activity;
import android.os.Bundle;

/**
 * Activity to show all categories and some other info of the user.
 * 
 * @author friederike
 * @version $Rev$ $Date$
 */
public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}