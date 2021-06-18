package com.aexpect.cryptoservice.services.contracts.collection;
import com.aexpect.cryptoservice.contracts.TKCollections;
import com.aexpect.cryptoservice.dto.TKCollectionMintDto;
import com.aexpect.cryptoservice.services.rpc.EthereumRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class TK721Collection {

    private final EthereumRpc ethereumRpc;
    private final Environment env;

    public TK721Collection(EthereumRpc ethereumRpc, Environment env) {
        this.ethereumRpc = ethereumRpc;
        this.env = env;
    }


    public void mintCollection(TKCollectionMintDto tkCollectionMintDto) {
        Web3j web3j = ethereumRpc.connect();
        TKCollections contract = TKCollections.load(
                tkCollectionMintDto.getContractAddress(),
                web3j,
                Credentials.create(env.getProperty("technical.wallet.private.key")),
                new BigInteger(Objects.requireNonNull(env.getProperty("gas.price"))),
                new BigInteger(Objects.requireNonNull(env.getProperty("gas.limit"))));

        CompletableFuture<TransactionReceipt> transactionReceiptCompletableFuture =
                contract.mintItem(
                        tkCollectionMintDto.getReceiverAddress(),
                        tkCollectionMintDto.getCollectionURI(),
                        tkCollectionMintDto.getCommission())
                        .sendAsync();

        transactionReceiptCompletableFuture.thenAccept(transactionReceipt -> {
            log.info("Mint Collection Transaction done Tx:[{}] Block:[{}]", transactionReceipt.getTransactionHash(), transactionReceipt.getBlockNumber());
            List<Type> args = FunctionReturnDecoder.decode(
                    transactionReceipt.getLogs().get(1).getData(), contract.MINTCOLLECTION_EVENT.getParameters());
            log.info(args.toString());
            // then accept gets transaction receipt only if the transaction is successful

        }).exceptionally(transactionReceipt  -> {
            return null;
        });
        web3j.shutdown();
    }
}
