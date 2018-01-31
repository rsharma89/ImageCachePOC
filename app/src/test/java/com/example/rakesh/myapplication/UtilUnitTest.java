package com.example.rakesh.myapplication;

import android.content.Context;
import com.example.rakesh.myapplication.helper.Util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by rakesh on 01/02/18.
 */

public class UtilUnitTest {

    @Mock
    Context mContext;

    @Before
    public void setupBankStringFormatterTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_loadJSONFromAsset() {
        String result = Util.loadJSONFromAsset(mContext);
        Assert.assertNotNull(result);
    }

    @Test
    public void test_getDummyList(){
        ArrayList list = Util.getDummyList();
        Assert.assertNotNull(list);
    }
}
