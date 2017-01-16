// IMyService.aidl
package com.hrc.administrator.complextypeaidl;
import com.hrc.administrator.complextypeaidl.baocun.Product;

// Declare any non-default types here with import statements

interface IMyService {
    Product getProduct();
    Map getMap(in String country,in Product product);
}
