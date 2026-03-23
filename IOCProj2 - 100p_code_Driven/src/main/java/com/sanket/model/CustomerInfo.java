//Model Class---> Model Class
package com.sanket.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerInfo
{
    private Integer Cno;
    private String CName;
    private String cAddress;
    private Double BillAmount;
    private Double Discount;
    private Double FinalAmount;

    //Setter Method
//    public void setCno(Integer cno) {
//        Cno = cno;
//    }
//
//    public void setcAddress(String cAddress) {
//        this.cAddress = cAddress;
//    }
//
//    public void setBillAmount(Double billAmount) {
//        BillAmount = billAmount;
//    }
//
//    public void setDiscount(Double discount) {
//        Discount = discount;
//    }
//
//    public void setFinalAmount(Double finalAmount) {
//        FinalAmount = finalAmount;
//    }
//    //Getter Method
//    public String getCName() {
//        return CName;
//    }
//
//    public Integer getCno() {
//        return Cno;
//    }
//
//    public String getcAddress() {
//        return cAddress;
//    }
//
//    public Double getBillAmount() {
//        return BillAmount;
//    }
//
//    public Double getDiscount() {
//        return Discount;
//    }
//
//    public Double getFinalAmount() {
//        return FinalAmount;
//    }
}
