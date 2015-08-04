package com.morningbaby.sdk.model;

import android.test.AndroidTestCase;
import junit.framework.Assert;
//import junit.framework.TestCase;
import junit.framework.*;
//import org.junit.Test;

import com.morningbaby.sdk.model.User;

/**
 * Created by carl on 15/8/3.
 */
public class UserTest extends AndroidTestCase {

    //@Test
    public void testLogin(){
        assertTrue(User.getCurrentUser().logout());
    }
    public void testObj(){
        assertTrue(new User().testReturnObj());
    }
}
