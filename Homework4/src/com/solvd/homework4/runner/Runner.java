package com.solvd.homework4.runner;

import com.solvd.homework4.exceptions.InvalidItemException;
import com.solvd.homework4.exceptions.UnderageException;
import com.solvd.homework4.hierarchy.Desktop;
import com.solvd.homework4.hierarchy.Laptop;
import com.solvd.homework4.hierarchy.SalesData;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.net.StandardSocketOptions;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Runner {
  private final static Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());


  public static void main(String[] args) throws UnderageException {

    Desktop myPC = new Desktop("i3 9100f", 16, 1024, 3, "Black", false, "GTX 1660s");
    Desktop myPC2 = new Desktop("i5 9400f", 8, 512, 2, "White", false, "GT 1030");

    Laptop myLT = new Laptop("i7 8700k", 16, 512, "QWERTY SPA 100%", true, 12, 5000);
    Laptop myLT2 = new Laptop("i7 8700k", 16, 512, "QWERTY SPA 100%", true, 12, 5000);

    LOGGER.info(myPC.toString());
    LOGGER.info("hash= " + myPC.hashCode());

    LOGGER.info(myPC2.toString());
    LOGGER.info("hash= " + myPC2.hashCode());

    if (myPC.equals(myPC2)) {
      LOGGER.info("These computers share the same components");
    } else {
      LOGGER.info("These computers do not share the same components");
    }
    LOGGER.info("");
    LOGGER.info(myLT.toString());
    LOGGER.info("hash= " + myLT.hashCode());

    LOGGER.info(myLT2.toString());
    LOGGER.info("hash= " + myLT2.hashCode());

    if (myLT.equals(myLT2)) {
      LOGGER.info("These computers share the same components");
    } else {
      LOGGER.info("These computers do not share the same components");
    }

    SalesData.pricelist(SalesData.MY_PC_PRICE, SalesData.MY_PC2_PRICE, SalesData.MY_LT_PRICE, SalesData.MY_LT2_PRICE);

    myPC.boot();
    myPC.run("Adobe Photoshop CC");
    myPC.capsLock();
    myPC.capsUnlock();
    myPC.temperature();
    myPC.shutdown();

    myLT2.boot();
    myLT2.run("League of Legends");
    myLT2.charge();
    myLT2.capsLock();
    myLT2.temperature();
    myLT2.shutdown();

    SalesData.stock();


    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Input your age: ");
    int age = scanner1.nextInt();
    if(age<18){
      throw new UnderageException();
    }
    LOGGER.info("Access granted - you are old enough");

  try{
    int[] availablePCsIDs = {1,2,3,4};
    System.out.println(availablePCsIDs[5]);
  }catch (InvalidItemException e){
  LOGGER.info(e.getMessage() + "Please select an item from the catalog.");
  }
  }
}
