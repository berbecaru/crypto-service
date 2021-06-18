package com.aexpect.cryptoservice.services.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

@Service
public class EthereumRpc {

    private static final Logger logger = LoggerFactory.getLogger(EthereumRpc.class);

    private boolean connected;


    public Web3j connect() {
        String connectionUrl = "https://goerli.infura.io/v3/ddf6290ec6ce4c0180f2a8781936ac6f";
        Web3j web3j = Web3j.build(new HttpService(connectionUrl));
        try{
            if(!connected){
                String version = web3j.web3ClientVersion().send().getWeb3ClientVersion();
                connected = true;
                logger.info("New connection is open [{}]", version);

            }
        } catch (IOException e) {
            connected = false;
            logger.error("Connection to [{}] failed", connectionUrl, e);
        }
        return web3j;
    }
}
