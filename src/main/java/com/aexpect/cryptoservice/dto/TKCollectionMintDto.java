package com.aexpect.cryptoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKCollectionMintDto {

    private String receiverAddress;
    private String collectionURI;
    private BigInteger commission;
    private String contractAddress;
}
