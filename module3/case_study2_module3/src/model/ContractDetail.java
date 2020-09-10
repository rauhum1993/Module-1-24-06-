package model;

public class ContractDetail {
    private String contractDetailID;
    private String contractID;
    private String attachServiceID;
    private String quantity;

    public ContractDetail(String contractDetailID, String contractID, String attachServiceID, String quantity) {
        this.contractDetailID = contractDetailID;
        this.contractID = contractID;
        this.attachServiceID = attachServiceID;
        this.quantity = quantity;
    }

    public String getContractDetailID() {
        return contractDetailID;
    }

    public void setContractDetailID(String contractDetailID) {
        this.contractDetailID = contractDetailID;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getAttachServiceID() {
        return attachServiceID;
    }

    public void setAttachServiceID(String attachServiceID) {
        this.attachServiceID = attachServiceID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
