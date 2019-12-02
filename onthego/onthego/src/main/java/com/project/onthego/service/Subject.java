package com.project.onthego.service;

public interface Subject {
 public void Attach(Observer o);
 public void Notify() throws Exception;
}
