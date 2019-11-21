package com.android.assignment3.controllerclass;



import com.android.assignment3.model.UserData;

public class controllerclass {
    public boolean CheckUser(UserData sd) {
        if ((sd.getName().equals("Admin")) && (sd.getPassword().equals("password"))) {
            return true;

        } else {
            return false;
        }
    }

}

