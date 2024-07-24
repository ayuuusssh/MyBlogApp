package com.blogapp12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestClass {
   public static void main(String[] args){
      Supplier<Double> val = ()->Math.random();
      Double result = val.get();
      System.out.println(result);
   }
}
