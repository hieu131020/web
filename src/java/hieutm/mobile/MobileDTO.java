/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieutm.mobile;

/**
 *
 * @author hieu1
 */
public class MobileDTO {

    private String mobileid;
    private String mobilename;

    private int price;
    private String description;

    public MobileDTO() {
    }

    public MobileDTO(String mobileid, String mobilename, int price, String description) {
        this.mobileid = mobileid;
        this.mobilename = mobilename;
        this.price = price;
        this.description = description;
    }

   

    public String getMobilename() {
        return mobilename;
    }

    public void setMobilename(String mobilename) {
        this.mobilename = mobilename;
    }

    public String getMobileid() {
        return mobileid;
    }

    public void setMobileid(String mobileid) {
        this.mobileid = mobileid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
