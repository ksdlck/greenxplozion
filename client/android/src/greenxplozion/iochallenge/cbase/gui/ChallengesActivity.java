package greenxplozion.iochallenge.cbase.gui;

import greenxplozion.iochallenge.cbase.R;
import android.app.Activity;
import android.os.Bundle;

/**
 * Activity to show all challenges of one category.
 * 
 * @author friederike
 * @version $Rev$ $Date$
 */
public class ChallengesActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}