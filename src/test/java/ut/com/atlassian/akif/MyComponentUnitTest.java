package ut.com.atlassian.akif;

import org.junit.Test;
import com.atlassian.akif.api.MyPluginComponent;
import com.atlassian.akif.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}