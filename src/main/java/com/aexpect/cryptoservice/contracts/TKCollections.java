package com.aexpect.cryptoservice.contracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class TKCollections extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b506040805180820182526011815270546f6b757020436f6c6c656374696f6e7360781b602080830191825283518085019094526003845262544b4360e81b908401528151919291620000669160009162000097565b5080516200007c90600190602084019062000097565b5050600880546001600160a01b03191633179055506200017a565b828054620000a5906200013d565b90600052602060002090601f016020900481019282620000c9576000855562000114565b82601f10620000e457805160ff191683800117855562000114565b8280016001018555821562000114579182015b8281111562000114578251825591602001919060010190620000f7565b506200012292915062000126565b5090565b5b8082111562000122576000815560010162000127565b600181811c908216806200015257607f821691505b602082108114156200017457634e487b7160e01b600052602260045260246000fd5b50919050565b612197806200018a6000396000f3fe608060405234801561001057600080fd5b50600436106101585760003560e01c80636295c61a116100c3578063c87b56dd1161007c578063c87b56dd14610304578063da880aa814610317578063e547e69314610337578063e985e9c51461034a578063f851a4401461035d578063fe0f75071461037057600080fd5b80636295c61a1461028f5780636352211e146102a257806370a08231146102b557806395d89b41146102d6578063a22cb465146102de578063b88d4fde146102f157600080fd5b80632bb88056116101155780632bb88056146102005780633a0ba7d9146102205780633ff566501461024357806342842e0e14610256578063433b0c9414610269578063457a48ee1461027c57600080fd5b806301a4adff1461015d57806301ffc9a71461017257806306fdde031461019a578063081812fc146101af578063095ea7b3146101da57806323b872dd146101ed575b600080fd5b61017061016b366004611e5d565b610383565b005b610185610180366004611dec565b6104a3565b60405190151581526020015b60405180910390f35b6101a26104f5565b6040516101919190611f64565b6101c26101bd366004611e24565b610587565b6040516001600160a01b039091168152602001610191565b6101706101e8366004611dc3565b61060f565b6101706101fb366004611c6d565b610725565b61021361020e366004611e24565b610756565b6040516101919190611f20565b61018561022e366004611c21565b60096020526000908152604090205460ff1681565b610170610251366004611c21565b610880565b610170610264366004611c6d565b6108f4565b610170610277366004611e3c565b61090f565b61017061028a366004611e3c565b610980565b61017061029d366004611c6d565b610a35565b6101c26102b0366004611e24565b610b21565b6102c86102c3366004611c21565b610b98565b604051908152602001610191565b6101a2610c1f565b6101706102ec366004611d21565b610c2e565b6101706102ff366004611ca8565b610cf3565b6101a2610312366004611e24565b610d25565b6102c8610325366004611e24565b600c6020526000908152604090205481565b610213610345366004611c21565b610e9c565b610185610358366004611c3b565b610f85565b6008546101c2906001600160a01b031681565b6102c861037e366004611d5b565b610fb3565b61038c82610b21565b6001600160a01b0316336001600160a01b031614806103ba57503360009081526009602052604090205460ff165b610433576040805162461bcd60e51b81526020600482015260248101919091527f53656e646572206973206e6f74206f776e6572206f662074686520636f6c6c6560448201527f6374696f6e206f7220636f6e7472616374206e6f74207265676973746572656460648201526084015b60405180910390fd5b6000828152600b6020526040902061044b90846110ce565b506000818152600b6020526040902061046490846110e1565b5060408051848152602081018390527f509fcbb9499b00afb2a1aee06ac6ae77633f71620f18d0407148aced1d70987f910160405180910390a1505050565b60006001600160e01b031982166380ac58cd60e01b14806104d457506001600160e01b03198216635b5e139f60e01b145b806104ef57506301ffc9a760e01b6001600160e01b03198316145b92915050565b606060008054610504906120a2565b80601f0160208091040260200160405190810160405280929190818152602001828054610530906120a2565b801561057d5780601f106105525761010080835404028352916020019161057d565b820191906000526020600020905b81548152906001019060200180831161056057829003601f168201915b5050505050905090565b6000610592826110ed565b6105f35760405162461bcd60e51b815260206004820152602c60248201527f4552433732313a20617070726f76656420717565727920666f72206e6f6e657860448201526b34b9ba32b73a103a37b5b2b760a11b606482015260840161042a565b506000908152600460205260409020546001600160a01b031690565b600061061a82610b21565b9050806001600160a01b0316836001600160a01b031614156106885760405162461bcd60e51b815260206004820152602160248201527f4552433732313a20617070726f76616c20746f2063757272656e74206f776e656044820152603960f91b606482015260840161042a565b336001600160a01b03821614806106a457506106a48133610f85565b6107165760405162461bcd60e51b815260206004820152603860248201527f4552433732313a20617070726f76652063616c6c6572206973206e6f74206f7760448201527f6e6572206e6f7220617070726f76656420666f7220616c6c0000000000000000606482015260840161042a565b610720838361110a565b505050565b61072f3382611178565b61074b5760405162461bcd60e51b815260040161042a90611fc9565b61072083838361123a565b6000818152600b6020526040812060609190610771906113da565b9050806107ac5760005b6040519080825280602002602001820160405280156107a4578160200160208202803683370190505b509392505050565b60008167ffffffffffffffff8111156107d557634e487b7160e01b600052604160045260246000fd5b6040519080825280602002602001820160405280156107fe578160200160208202803683370190505b5090506000805b83811015610870576000868152600b6020526040902061082590826113e4565b83838151811061084557634e487b7160e01b600052603260045260246000fd5b60209081029190910101528161085a816120d7565b9250508080610868906120d7565b915050610805565b5090949350505050565b50919050565b6008546001600160a01b031633146108d05760405162461bcd60e51b815260206004820152601360248201527229b2b73232b91034b9903737ba1030b236b4b760691b604482015260640161042a565b6001600160a01b03166000908152600960205260409020805460ff19166001179055565b61072083838360405180602001604052806000815250610cf3565b61091882610b21565b6001600160a01b0316336001600160a01b03161461096e5760405162461bcd60e51b815260206004820152601360248201527229b2b73232b91034b9903737ba1037bbb732b960691b604482015260640161042a565b6000918252600c602052604090912055565b3360009081526009602052604090205460ff166109df5760405162461bcd60e51b815260206004820152601c60248201527f53656e646572206973206e6f7420544b37323120636f6e747261637400000000604482015260640161042a565b6000818152600b602052604090206109f790836110e1565b5060408051838152602081018390527f509fcbb9499b00afb2a1aee06ac6ae77633f71620f18d0407148aced1d70987f910160405180910390a15050565b610a3e81610b21565b6001600160a01b0316336001600160a01b03161480610a6c57503360009081526009602052604090205460ff165b610acb5760405162461bcd60e51b815260206004820152602a60248201527f53656e646572206973206e6569746865722061646d696e206e6f72206f776e65604482015269391037b3103a37b5b2b760b11b606482015260840161042a565b610ad683838361123a565b6001600160a01b0383166000908152600a60205260409020610af890826110ce565b506001600160a01b0382166000908152600a60205260409020610b1b90826110e1565b50505050565b6000818152600260205260408120546001600160a01b0316806104ef5760405162461bcd60e51b815260206004820152602960248201527f4552433732313a206f776e657220717565727920666f72206e6f6e657869737460448201526832b73a103a37b5b2b760b91b606482015260840161042a565b60006001600160a01b038216610c035760405162461bcd60e51b815260206004820152602a60248201527f4552433732313a2062616c616e636520717565727920666f7220746865207a65604482015269726f206164647265737360b01b606482015260840161042a565b506001600160a01b031660009081526003602052604090205490565b606060018054610504906120a2565b6001600160a01b038216331415610c875760405162461bcd60e51b815260206004820152601960248201527f4552433732313a20617070726f766520746f2063616c6c657200000000000000604482015260640161042a565b3360008181526005602090815260408083206001600160a01b03871680855290835292819020805460ff191686151590811790915590519081529192917f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31910160405180910390a35050565b610cfd3383611178565b610d195760405162461bcd60e51b815260040161042a90611fc9565b610b1b848484846113f0565b6060610d30826110ed565b610d965760405162461bcd60e51b815260206004820152603160248201527f45524337323155524953746f726167653a2055524920717565727920666f72206044820152703737b732bc34b9ba32b73a103a37b5b2b760791b606482015260840161042a565b60008281526006602052604081208054610daf906120a2565b80601f0160208091040260200160405190810160405280929190818152602001828054610ddb906120a2565b8015610e285780601f10610dfd57610100808354040283529160200191610e28565b820191906000526020600020905b815481529060010190602001808311610e0b57829003601f168201915b505050505090506000610e4660408051602081019091526000815290565b9050805160001415610e59575092915050565b815115610e8b578082604051602001610e73929190611eb4565b60405160208183030381529060405292505050919050565b610e9484611423565b949350505050565b60606000610ea983610b98565b905080610eb757600061077b565b60008167ffffffffffffffff811115610ee057634e487b7160e01b600052604160045260246000fd5b604051908082528060200260200182016040528015610f09578160200160208202803683370190505b5090506000805b83811015610870576001600160a01b0386166000908152600a60205260409020610f3a90826113e4565b838381518110610f5a57634e487b7160e01b600052603260045260246000fd5b602090810291909101015281610f6f816120d7565b9250508080610f7d906120d7565b915050610f10565b6001600160a01b03918216600090815260056020908152604080832093909416825291909152205460ff1690565b6000336001600160a01b0385161480610fd657506008546001600160a01b031633145b61102d5760405162461bcd60e51b815260206004820152602260248201527f53656e65646572206973206e6f742061646d696e2c206e6f722072656365697660448201526132b960f11b606482015260840161042a565b61103760076114fa565b600061104260075490565b905061104e8582611517565b611058818561164a565b6001600160a01b0385166000908152600a6020526040902061107a90826110e1565b506000818152600c602052604090819020849055517f2d6978489eca1ac00f986f21965f06e2ce9dd1cd0236e8cf7e4b242904154437906110be908390879061201a565b60405180910390a1949350505050565b60006110da83836116d5565b9392505050565b60006110da83836117ec565b6000908152600260205260409020546001600160a01b0316151590565b600081815260046020526040902080546001600160a01b0319166001600160a01b038416908117909155819061113f82610b21565b6001600160a01b03167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a45050565b6000611183826110ed565b6111e45760405162461bcd60e51b815260206004820152602c60248201527f4552433732313a206f70657261746f7220717565727920666f72206e6f6e657860448201526b34b9ba32b73a103a37b5b2b760a11b606482015260840161042a565b60006111ef83610b21565b9050806001600160a01b0316846001600160a01b0316148061122a5750836001600160a01b031661121f84610587565b6001600160a01b0316145b80610e945750610e948185610f85565b826001600160a01b031661124d82610b21565b6001600160a01b0316146112b55760405162461bcd60e51b815260206004820152602960248201527f4552433732313a207472616e73666572206f6620746f6b656e2074686174206960448201526839903737ba1037bbb760b91b606482015260840161042a565b6001600160a01b0382166113175760405162461bcd60e51b8152602060048201526024808201527f4552433732313a207472616e7366657220746f20746865207a65726f206164646044820152637265737360e01b606482015260840161042a565b61132260008261110a565b6001600160a01b038316600090815260036020526040812080546001929061134b90849061205f565b90915550506001600160a01b0382166000908152600360205260408120805460019290611379908490612033565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b0386811691821790925591518493918716917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef91a4505050565b60006104ef825490565b60006110da838361183b565b6113fb84848461123a565b611407848484846118cf565b610b1b5760405162461bcd60e51b815260040161042a90611f77565b606061142e826110ed565b6114925760405162461bcd60e51b815260206004820152602f60248201527f4552433732314d657461646174613a2055524920717565727920666f72206e6f60448201526e3732bc34b9ba32b73a103a37b5b2b760891b606482015260840161042a565b60006114a960408051602081019091526000815290565b905060008151116114c957604051806020016040528060008152506110da565b806114d3846119dc565b6040516020016114e4929190611eb4565b6040516020818303038152906040529392505050565b600181600001600082825461150f9190612033565b909155505050565b6001600160a01b03821661156d5760405162461bcd60e51b815260206004820181905260248201527f4552433732313a206d696e7420746f20746865207a65726f2061646472657373604482015260640161042a565b611576816110ed565b156115c35760405162461bcd60e51b815260206004820152601c60248201527f4552433732313a20746f6b656e20616c7265616479206d696e74656400000000604482015260640161042a565b6001600160a01b03821660009081526003602052604081208054600192906115ec908490612033565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b03861690811790915590518392907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908290a45050565b611653826110ed565b6116b65760405162461bcd60e51b815260206004820152602e60248201527f45524337323155524953746f726167653a2055524920736574206f66206e6f6e60448201526d32bc34b9ba32b73a103a37b5b2b760911b606482015260840161042a565b6000828152600660209081526040909120825161072092840190611af6565b600081815260018301602052604081205480156117e25760006116f960018361205f565b855490915060009061170d9060019061205f565b9050600086600001828154811061173457634e487b7160e01b600052603260045260246000fd5b906000526020600020015490508087600001848154811061176557634e487b7160e01b600052603260045260246000fd5b6000918252602080832090910192909255828152600189019091526040902084905586548790806117a657634e487b7160e01b600052603160045260246000fd5b600190038181906000526020600020016000905590558660010160008781526020019081526020016000206000905560019450505050506104ef565b60009150506104ef565b6000818152600183016020526040812054611833575081546001818101845560008481526020808220909301849055845484825282860190935260409020919091556104ef565b5060006104ef565b815460009082106118995760405162461bcd60e51b815260206004820152602260248201527f456e756d657261626c655365743a20696e646578206f7574206f6620626f756e604482015261647360f01b606482015260840161042a565b8260000182815481106118bc57634e487b7160e01b600052603260045260246000fd5b9060005260206000200154905092915050565b60006001600160a01b0384163b156119d157604051630a85bd0160e11b81526001600160a01b0385169063150b7a0290611913903390899088908890600401611ee3565b602060405180830381600087803b15801561192d57600080fd5b505af192505050801561195d575060408051601f3d908101601f1916820190925261195a91810190611e08565b60015b6119b7573d80801561198b576040519150601f19603f3d011682016040523d82523d6000602084013e611990565b606091505b5080516119af5760405162461bcd60e51b815260040161042a90611f77565b805181602001fd5b6001600160e01b031916630a85bd0160e11b149050610e94565b506001949350505050565b606081611a005750506040805180820190915260018152600360fc1b602082015290565b8160005b8115611a2a5780611a14816120d7565b9150611a239050600a8361204b565b9150611a04565b60008167ffffffffffffffff811115611a5357634e487b7160e01b600052604160045260246000fd5b6040519080825280601f01601f191660200182016040528015611a7d576020820181803683370190505b5090505b8415610e9457611a9260018361205f565b9150611a9f600a866120f2565b611aaa906030612033565b60f81b818381518110611acd57634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a905350611aef600a8661204b565b9450611a81565b828054611b02906120a2565b90600052602060002090601f016020900481019282611b245760008555611b6a565b82601f10611b3d57805160ff1916838001178555611b6a565b82800160010185558215611b6a579182015b82811115611b6a578251825591602001919060010190611b4f565b50611b76929150611b7a565b5090565b5b80821115611b765760008155600101611b7b565b600067ffffffffffffffff80841115611baa57611baa612132565b604051601f8501601f19908116603f01168101908282118183101715611bd257611bd2612132565b81604052809350858152868686011115611beb57600080fd5b858560208301376000602087830101525050509392505050565b80356001600160a01b0381168114611c1c57600080fd5b919050565b600060208284031215611c32578081fd5b6110da82611c05565b60008060408385031215611c4d578081fd5b611c5683611c05565b9150611c6460208401611c05565b90509250929050565b600080600060608486031215611c81578081fd5b611c8a84611c05565b9250611c9860208501611c05565b9150604084013590509250925092565b60008060008060808587031215611cbd578081fd5b611cc685611c05565b9350611cd460208601611c05565b925060408501359150606085013567ffffffffffffffff811115611cf6578182fd5b8501601f81018713611d06578182fd5b611d1587823560208401611b8f565b91505092959194509250565b60008060408385031215611d33578182fd5b611d3c83611c05565b915060208301358015158114611d50578182fd5b809150509250929050565b600080600060608486031215611d6f578283fd5b611d7884611c05565b9250602084013567ffffffffffffffff811115611d93578283fd5b8401601f81018613611da3578283fd5b611db286823560208401611b8f565b925050604084013590509250925092565b60008060408385031215611dd5578182fd5b611dde83611c05565b946020939093013593505050565b600060208284031215611dfd578081fd5b81356110da81612148565b600060208284031215611e19578081fd5b81516110da81612148565b600060208284031215611e35578081fd5b5035919050565b60008060408385031215611e4e578182fd5b50508035926020909101359150565b600080600060608486031215611e71578283fd5b505081359360208301359350604090920135919050565b60008151808452611ea0816020860160208601612076565b601f01601f19169290920160200192915050565b60008351611ec6818460208801612076565b835190830190611eda818360208801612076565b01949350505050565b6001600160a01b0385811682528416602082015260408101839052608060608201819052600090611f1690830184611e88565b9695505050505050565b6020808252825182820181905260009190848201906040850190845b81811015611f5857835183529284019291840191600101611f3c565b50909695505050505050565b6020815260006110da6020830184611e88565b60208082526032908201527f4552433732313a207472616e7366657220746f206e6f6e20455243373231526560408201527131b2b4bb32b91034b6b83632b6b2b73a32b960711b606082015260800190565b60208082526031908201527f4552433732313a207472616e736665722063616c6c6572206973206e6f74206f6040820152701ddb995c881b9bdc88185c1c1c9bdd9959607a1b606082015260800190565b828152604060208201526000610e946040830184611e88565b6000821982111561204657612046612106565b500190565b60008261205a5761205a61211c565b500490565b60008282101561207157612071612106565b500390565b60005b83811015612091578181015183820152602001612079565b83811115610b1b5750506000910152565b600181811c908216806120b657607f821691505b6020821081141561087a57634e487b7160e01b600052602260045260246000fd5b60006000198214156120eb576120eb612106565b5060010190565b6000826121015761210161211c565b500690565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052601260045260246000fd5b634e487b7160e01b600052604160045260246000fd5b6001600160e01b03198116811461215e57600080fd5b5056fea2646970667358221220d69b469edac6ebb4720f7856a19445039a54adc2cf3fb679ca622c853ce8c12364736f6c63430008040033";

    public static final String FUNC_ADDTOKENTOCOLLECTION = "addTokenToCollection";

    public static final String FUNC_ADMIN = "admin";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_CHANGECOMMISSIONFORCOLLECTION = "changeCommissionForCollection";

    public static final String FUNC_COLLECTIONCOMMISSION = "collectionCommission";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_GETCOLLECTIONTOKENS = "getCollectionTokens";

    public static final String FUNC_GETHOLDERTOKENS = "getHolderTokens";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_MINTITEM = "mintItem";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_REGISTERNEWCONTRACT = "registerNewContract";

    public static final String FUNC_REGISTEREDCONTRACT = "registeredContract";

    public static final String FUNC_safeTransferFrom = "safeTransferFrom";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOKENURI = "tokenURI";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_TRANSFERITEM = "transferItem";

    public static final String FUNC_TRANSFERTOKENTOANOTHERCOLLECTION = "transferTokenToAnotherCollection";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event MINTCOLLECTION_EVENT = new Event("MintCollection", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event TRANSFERTOKENTONEWCOLLECTION_EVENT = new Event("TransferTokenToNewCollection", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected TKCollections(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TKCollections(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TKCollections(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TKCollections(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public List<ApprovalForAllEventResponse> getApprovalForAllEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
        ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ApprovalForAllEventResponse>() {
            @Override
            public ApprovalForAllEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVALFORALL_EVENT, log);
                ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVALFORALL_EVENT));
        return approvalForAllEventFlowable(filter);
    }

    public List<MintCollectionEventResponse> getMintCollectionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINTCOLLECTION_EVENT, transactionReceipt);
        ArrayList<MintCollectionEventResponse> responses = new ArrayList<MintCollectionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MintCollectionEventResponse typedResponse = new MintCollectionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.tokenURL = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MintCollectionEventResponse> mintCollectionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, MintCollectionEventResponse>() {
            @Override
            public MintCollectionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINTCOLLECTION_EVENT, log);
                MintCollectionEventResponse typedResponse = new MintCollectionEventResponse();
                typedResponse.log = log;
                typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.tokenURL = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<MintCollectionEventResponse> mintCollectionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINTCOLLECTION_EVENT));
        return mintCollectionEventFlowable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public List<TransferTokenToNewCollectionEventResponse> getTransferTokenToNewCollectionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFERTOKENTONEWCOLLECTION_EVENT, transactionReceipt);
        ArrayList<TransferTokenToNewCollectionEventResponse> responses = new ArrayList<TransferTokenToNewCollectionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferTokenToNewCollectionEventResponse typedResponse = new TransferTokenToNewCollectionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.collectionId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferTokenToNewCollectionEventResponse> transferTokenToNewCollectionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferTokenToNewCollectionEventResponse>() {
            @Override
            public TransferTokenToNewCollectionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFERTOKENTONEWCOLLECTION_EVENT, log);
                TransferTokenToNewCollectionEventResponse typedResponse = new TransferTokenToNewCollectionEventResponse();
                typedResponse.log = log;
                typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.collectionId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferTokenToNewCollectionEventResponse> transferTokenToNewCollectionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFERTOKENTONEWCOLLECTION_EVENT));
        return transferTokenToNewCollectionEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addTokenToCollection(BigInteger tokenId, BigInteger collectionId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDTOKENTOCOLLECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.generated.Uint256(collectionId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> admin() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> changeCommissionForCollection(BigInteger collectionId, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CHANGECOMMISSIONFORCOLLECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(collectionId), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> collectionCommission(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COLLECTIONCOMMISSION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getApproved(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<List> getCollectionTokens(BigInteger collectionId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCOLLECTIONTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(collectionId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<List> getHolderTokens(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETHOLDERTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Boolean> isApprovedForAll(String owner, String operator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, operator)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> mintItem(String receiver, String tokenURI, BigInteger commission) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINTITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, receiver), 
                new org.web3j.abi.datatypes.Utf8String(tokenURI), 
                new org.web3j.abi.datatypes.generated.Uint256(commission)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> ownerOf(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNEROF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> registerNewContract(String contractAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTERNEWCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, contractAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> registeredContract(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_REGISTEREDCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId, byte[] _data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setApprovalForAll(String operator, Boolean approved) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETAPPROVALFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, operator), 
                new org.web3j.abi.datatypes.Bool(approved)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> tokenURI(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKENURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferItem(String from, String to, BigInteger collectionId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(collectionId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferTokenToAnotherCollection(BigInteger tokenId, BigInteger actualCollection, BigInteger newCollection) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERTOKENTOANOTHERCOLLECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.generated.Uint256(actualCollection), 
                new org.web3j.abi.datatypes.generated.Uint256(newCollection)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TKCollections load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TKCollections(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TKCollections load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TKCollections(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TKCollections load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TKCollections(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TKCollections load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TKCollections(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TKCollections> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TKCollections.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<TKCollections> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TKCollections.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TKCollections> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TKCollections.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TKCollections> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TKCollections.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class ApprovalForAllEventResponse extends BaseEventResponse {
        public String owner;

        public String operator;

        public Boolean approved;
    }

    public static class MintCollectionEventResponse extends BaseEventResponse {
        public BigInteger tokenId;

        public String tokenURL;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger tokenId;
    }

    public static class TransferTokenToNewCollectionEventResponse extends BaseEventResponse {
        public BigInteger tokenId;

        public BigInteger collectionId;
    }
}
