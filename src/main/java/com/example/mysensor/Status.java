package com.example.mysensor;

import java.util.HashMap;

public class Status {
  static HashMap<String,Boolean> isEnters=new HashMap<String,Boolean>();
  static HashMap<String,String> buffer=new HashMap<String,String>();

  static HashMap<String,Boolean> upload=new HashMap<String,Boolean>();
  Status(){
	  isEnters=new HashMap<String,Boolean>();
	  buffer=new HashMap<String,String>();
	  upload=new HashMap<String,Boolean>();
  }
  
}
