package com.example.rakesh.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Category local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CategoryUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_loadJSONFromAsset() {
        String result = Utils.loadJSONFromAsset(mContext, "testJson.json");
    }
}