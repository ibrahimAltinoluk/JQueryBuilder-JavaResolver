package com.jquerybuilder.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import junit.framework.TestCase;

public class BaseTest extends TestCase {

  protected Map<String, String> data1 = new HashMap<String, String>();
  protected Map<String, String> data2 = new HashMap<String, String>();
  protected Map<String, String> data3 = new HashMap<String, String>();
  protected Map<String, String> data4 = new HashMap<String, String>();
  protected Map<String, String> data5 = new HashMap<String, String>();
  protected Map<String, String> data6 = new HashMap<String, String>();
  protected Map<String, String> data7 = new HashMap<String, String>();
  protected Map<String, String> data8 = new HashMap<String, String>();
  protected Map<String, String> data9 = new HashMap<String, String>();
  protected Map<String, String> data10 = new HashMap<String, String>();

  protected Gson gson = new GsonBuilder().create();

  protected String readFile(String file) {
    StringBuffer sb = new StringBuffer();
    try {
      File fileDir = new File(file);
      BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
      String str;
      while ((str = in.readLine()) != null)
        sb.append(str);
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
      assertTrue(false);
    }
    return sb.toString();
  }

  public void testBase() {
    assertNotNull(gson);
  }

}
