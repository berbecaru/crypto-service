package com.aexpect.cryptoservice.services.contracts.token;


import com.aexpect.cryptoservice.services.rpc.EthereumRpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TK721Token {

    private static final Logger logger = LoggerFactory.getLogger(TK721Token.class);

    private final EthereumRpc ethereumRpc;

    public TK721Token(EthereumRpc ethereumRpc) {
        this.ethereumRpc = ethereumRpc;
        logger.info(this.getClass().getSimpleName() + " created.");
    }


}

