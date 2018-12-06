package com.easy.shop.dto;

import com.easy.shop.constants.CusotmerType;
import org.joda.time.DateTime;

/**
 * Created by Abhinav Malviya on 12/17/2017.
 */
public class  CustomerDTO {
    private String customerName;
    private int age;
    private String customerAddressFirstLine;
    private String customerAddressSecondLine;
    private DateTime registrationDate;
    private CusotmerType cusotmerType;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCustomerAddressFirstLine() {
        return customerAddressFirstLine;
    }

    public void setCustomerAddressFirstLine(String customerAddressFirstLine) {
        this.customerAddressFirstLine = customerAddressFirstLine;
    }

    public String getCustomerAddressSecondLine() {
        return customerAddressSecondLine;
    }

    public void setCustomerAddressSecondLine(String customerAddressSecondLine) {
        this.customerAddressSecondLine = customerAddressSecondLine;
    }

    public DateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(DateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public CusotmerType getCusotmerType() {
        return cusotmerType;
    }

    public void setCusotmerType(CusotmerType cusotmerType) {
        this.cusotmerType = cusotmerType;
    }
}
