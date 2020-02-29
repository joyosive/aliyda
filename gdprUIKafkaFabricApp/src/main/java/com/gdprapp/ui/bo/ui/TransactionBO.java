package com.gdprapp.ui.bo.ui;

import java.util.Date;

public class TransactionBO {

    private String transactionName;
    private String blockchainHash;
    private String transactionId;

    private String paymentMode;
    private boolean isIdProofSubmitted;
    private Date transactionDate;
    private String transactionDisplayDate;
    private String eventName;
    private String assetName;


    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getBlockchainHash() {
        return blockchainHash;
    }

    public void setBlockchainHash(String blockchainHash) {
        this.blockchainHash = blockchainHash;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public boolean isIdProofSubmitted() {
        return isIdProofSubmitted;
    }

    public void setIdProofSubmitted(boolean idProofSubmitted) {
        isIdProofSubmitted = idProofSubmitted;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionDisplayDate() {
        return transactionDisplayDate;
    }

    public void setTransactionDisplayDate(String transactionDisplayDate) {
        this.transactionDisplayDate = transactionDisplayDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
}
