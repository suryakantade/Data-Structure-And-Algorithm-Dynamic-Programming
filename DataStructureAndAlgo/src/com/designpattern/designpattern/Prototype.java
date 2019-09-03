package com.designpattern.designpattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Prototype {
 private static List<StudentRestService> studentRestServices;

  {
    studentRestServices = Collections.unmodifiableList(
        Arrays.asList(new StudentRestService(), new StudentRestService(),
            new StudentRestService()));
  }

  public static StudentRestService getStudentRestService() throws CloneNotSupportedException{
    return (StudentRestService) studentRestServices.get(new  Random().nextInt(3)).clone();
  }
}


class StudentRestService implements Cloneable {
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}