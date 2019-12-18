package com.example.mukesh.view.ui.home.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Mukesh Singh on 12/12/2019
 */
public class SharedTransitionArg implements Serializable {
    private HashMap<String,String> map;

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }
}
