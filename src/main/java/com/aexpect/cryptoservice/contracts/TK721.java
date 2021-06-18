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
import org.web3j.abi.FunctionEncoder;
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
public class TK721 extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b506040516200259c3803806200259c833981016040819052620000349162000178565b604080518082018252600e81526d1512cdcc8c4814dd185b99185c9960921b602080830191825283518085019094526002845261544b60f01b9084015281519192916200008491600091620000d2565b5080516200009a906001906020840190620000d2565b505060088054336001600160a01b031991821617909155600c80549091166001600160a01b03939093169290921790915550620001e5565b828054620000e090620001a8565b90600052602060002090601f0160209004810192826200010457600085556200014f565b82601f106200011f57805160ff19168380011785556200014f565b828001600101855582156200014f579182015b828111156200014f57825182559160200191906001019062000132565b506200015d92915062000161565b5090565b5b808211156200015d576000815560010162000162565b6000602082840312156200018a578081fd5b81516001600160a01b0381168114620001a1578182fd5b9392505050565b600181811c90821680620001bd57607f821691505b60208210811415620001df57634e487b7160e01b600052602260045260246000fd5b50919050565b6123a780620001f56000396000f3fe608060405234801561001057600080fd5b506004361061014d5760003560e01c80636352211e116100c3578063c87b56dd1161007c578063c87b56dd146102e6578063e547e693146102f9578063e985e9c514610319578063eb8caae91461032c578063f851a4401461033f578063fe0f75071461035257600080fd5b80636352211e1461027f5780636e65851b1461029257806370a08231146102a557806395d89b41146102b8578063a22cb465146102c0578063b88d4fde146102d357600080fd5b806323b872dd1161011557806323b872dd146101fd5780633a0ba7d9146102105780633ff566501461023357806342842e0e14610246578063576cc0f7146102595780636295c61a1461026c57600080fd5b806301ffc9a71461015257806306fdde031461017a578063081812fc1461018f578063095ea7b3146101ba578063195f78ae146101cf575b600080fd5b610165610160366004612005565b610365565b60405190151581526020015b60405180910390f35b6101826103b7565b6040516101719190612152565b6101a261019d36600461203d565b610449565b6040516001600160a01b039091168152602001610171565b6101cd6101c8366004611fda565b6104d6565b005b6101ef6101dd36600461203d565b600b6020526000908152604090205481565b604051908152602001610171565b6101cd61020b366004611e82565b6105ec565b61016561021e366004611e12565b60096020526000908152604090205460ff1681565b6101cd610241366004611e12565b61061d565b6101cd610254366004611e82565b610691565b6101cd61026736600461203d565b6106ac565b6101cd61027a366004611e82565b610747565b6101a261028d36600461203d565b610848565b6101a26102a036600461203d565b6108bf565b6101ef6102b3366004611e12565b61093c565b6101826109c3565b6101cd6102ce366004611f3f565b6109d2565b6101cd6102e1366004611ec2565b610a97565b6101826102f436600461203d565b610ac9565b61030c610307366004611e12565b610c40565b604051610171919061210e565b610165610327366004611e4a565b610d48565b6101cd61033a366004612055565b610d76565b6008546101a2906001600160a01b031681565b6101ef610360366004611f70565b610fe3565b60006001600160e01b031982166380ac58cd60e01b148061039657506001600160e01b03198216635b5e139f60e01b145b806103b157506301ffc9a760e01b6001600160e01b03198316145b92915050565b6060600080546103c6906122a0565b80601f01602080910402602001604051908101604052809291908181526020018280546103f2906122a0565b801561043f5780601f106104145761010080835404028352916020019161043f565b820191906000526020600020905b81548152906001019060200180831161042257829003601f168201915b5050505050905090565b6000610454826111cd565b6104ba5760405162461bcd60e51b815260206004820152602c60248201527f4552433732313a20617070726f76656420717565727920666f72206e6f6e657860448201526b34b9ba32b73a103a37b5b2b760a11b60648201526084015b60405180910390fd5b506000908152600460205260409020546001600160a01b031690565b60006104e182610848565b9050806001600160a01b0316836001600160a01b0316141561054f5760405162461bcd60e51b815260206004820152602160248201527f4552433732313a20617070726f76616c20746f2063757272656e74206f776e656044820152603960f91b60648201526084016104b1565b336001600160a01b038216148061056b575061056b8133610d48565b6105dd5760405162461bcd60e51b815260206004820152603860248201527f4552433732313a20617070726f76652063616c6c6572206973206e6f74206f7760448201527f6e6572206e6f7220617070726f76656420666f7220616c6c000000000000000060648201526084016104b1565b6105e783836111ea565b505050565b6105f63382611258565b6106125760405162461bcd60e51b81526004016104b1906121b7565b6105e783838361131a565b6008546001600160a01b0316331461066d5760405162461bcd60e51b815260206004820152601360248201527229b2b73232b91034b9903737ba1030b236b4b760691b60448201526064016104b1565b6001600160a01b03166000908152600960205260409020805460ff19166001179055565b6105e783838360405180602001604052806000815250610a97565b6008546001600160a01b031633146106fc5760405162461bcd60e51b815260206004820152601360248201527229b2b73232b91034b9903737ba1030b236b4b760691b60448201526064016104b1565b600061070782610848565b9050610712826114ba565b6001600160a01b0381166000908152600a6020526040902061073490836114fd565b50506000908152600b6020526040812055565b6008546001600160a01b0316331480610779575061076481610848565b6001600160a01b0316336001600160a01b0316145b8061079357503360009081526009602052604090205460ff165b6107f25760405162461bcd60e51b815260206004820152602a60248201527f53656e646572206973206e6569746865722061646d696e206e6f72206f776e65604482015269391037b3103a37b5b2b760b11b60648201526084016104b1565b6107fd83838361131a565b6001600160a01b0383166000908152600a6020526040902061081f90826114fd565b506001600160a01b0382166000908152600a602052604090206108429082611510565b50505050565b6000818152600260205260408120546001600160a01b0316806103b15760405162461bcd60e51b815260206004820152602960248201527f4552433732313a206f776e657220717565727920666f72206e6f6e657869737460448201526832b73a103a37b5b2b760b91b60648201526084016104b1565b600c546040516331a9108f60e11b8152600481018390526000916001600160a01b031690636352211e9060240160206040518083038186803b15801561090457600080fd5b505afa158015610918573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906103b19190611e2e565b60006001600160a01b0382166109a75760405162461bcd60e51b815260206004820152602a60248201527f4552433732313a2062616c616e636520717565727920666f7220746865207a65604482015269726f206164647265737360b01b60648201526084016104b1565b506001600160a01b031660009081526003602052604090205490565b6060600180546103c6906122a0565b6001600160a01b038216331415610a2b5760405162461bcd60e51b815260206004820152601960248201527f4552433732313a20617070726f766520746f2063616c6c65720000000000000060448201526064016104b1565b3360008181526005602090815260408083206001600160a01b03871680855290835292819020805460ff191686151590811790915590519081529192917f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31910160405180910390a35050565b610aa13383611258565b610abd5760405162461bcd60e51b81526004016104b1906121b7565b6108428484848461151c565b6060610ad4826111cd565b610b3a5760405162461bcd60e51b815260206004820152603160248201527f45524337323155524953746f726167653a2055524920717565727920666f72206044820152703737b732bc34b9ba32b73a103a37b5b2b760791b60648201526084016104b1565b60008281526006602052604081208054610b53906122a0565b80601f0160208091040260200160405190810160405280929190818152602001828054610b7f906122a0565b8015610bcc5780601f10610ba157610100808354040283529160200191610bcc565b820191906000526020600020905b815481529060010190602001808311610baf57829003601f168201915b505050505090506000610bea60408051602081019091526000815290565b9050805160001415610bfd575092915050565b815115610c2f578082604051602001610c179291906120a2565b60405160208183030381529060405292505050919050565b610c388461154f565b949350505050565b60606000610c4d8361093c565b905080610c6a575050604080516000815260208101909152919050565b60008167ffffffffffffffff811115610c9357634e487b7160e01b600052604160045260246000fd5b604051908082528060200260200182016040528015610cbc578160200160208202803683370190505b5090506000805b83811015610d38576001600160a01b0386166000908152600a60205260409020610ced9082611626565b838381518110610d0d57634e487b7160e01b600052603260045260246000fd5b602090810291909101015281610d22816122d5565b9250508080610d30906122d5565b915050610cc3565b5090949350505050565b50919050565b6001600160a01b03918216600090815260056020908152604080832093909416825291909152205460ff1690565b610d7f82610848565b6001600160a01b0316336001600160a01b031614610deb5760405162461bcd60e51b8152602060048201526024808201527f53656e646572206973206e6f7420746865206f776e6572206f6620746865207460448201526337b5b2b760e11b60648201526084016104b1565b610df4816108bf565b6001600160a01b0316336001600160a01b031614610e665760405162461bcd60e51b815260206004820152602960248201527f53656e646572206973206e6f7420746865206f776e6572206f66206e6577206360448201526837b63632b1ba34b7b760b91b60648201526084016104b1565b6000828152600b6020526040902054610e7e906108bf565b6001600160a01b0316336001600160a01b031614610ef45760405162461bcd60e51b815260206004820152602d60248201527f53656e65646572206973206e6f74206f776e6572206f6620746865206163747560448201526c30b61031b7b63632b1ba34b7b760991b60648201526084016104b1565b6000828152600b6020526040902054610f5d5760405162461bcd60e51b815260206004820152602560248201527f746f6b656e20646f6573206e6f742062656c6f6e6720746f206120636f6c6c6560448201526431ba34b7b760d91b60648201526084016104b1565b6000828152600b602052604090819020805490839055600c5491516301a4adff60e01b815260048101859052602481018290526044810184905290916001600160a01b0316906301a4adff90606401600060405180830381600087803b158015610fc657600080fd5b505af1158015610fda573d6000803e3d6000fd5b50505050505050565b600c546040516331a9108f60e11b81526004810183905260009133916001600160a01b0390911690636352211e9060240160206040518083038186803b15801561102c57600080fd5b505afa158015611040573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906110649190611e2e565b6001600160a01b0316146110c55760405162461bcd60e51b815260206004820152602260248201527f53656e646572206973206e6f74206f776e657220666f7220636f6c6c6563746960448201526137b760f11b60648201526084016104b1565b6110cf6007611632565b60006110da60075490565b90506110e6858261164f565b6110f08185611782565b6001600160a01b0385166000908152600a602052604090206111129082611510565b506000818152600b602052604090819020849055600c5490516322bd247760e11b815260048101839052602481018590526001600160a01b039091169063457a48ee90604401600060405180830381600087803b15801561117257600080fd5b505af1158015611186573d6000803e3d6000fd5b505050507f62c7d0ab3d4a5ce83ab60c8c32abd5fd0bdb5e26e780ee6b932699755639afab8185856040516111bd93929190612208565b60405180910390a1949350505050565b6000908152600260205260409020546001600160a01b0316151590565b600081815260046020526040902080546001600160a01b0319166001600160a01b038416908117909155819061121f82610848565b6001600160a01b03167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a45050565b6000611263826111cd565b6112c45760405162461bcd60e51b815260206004820152602c60248201527f4552433732313a206f70657261746f7220717565727920666f72206e6f6e657860448201526b34b9ba32b73a103a37b5b2b760a11b60648201526084016104b1565b60006112cf83610848565b9050806001600160a01b0316846001600160a01b0316148061130a5750836001600160a01b03166112ff84610449565b6001600160a01b0316145b80610c385750610c388185610d48565b826001600160a01b031661132d82610848565b6001600160a01b0316146113955760405162461bcd60e51b815260206004820152602960248201527f4552433732313a207472616e73666572206f6620746f6b656e2074686174206960448201526839903737ba1037bbb760b91b60648201526084016104b1565b6001600160a01b0382166113f75760405162461bcd60e51b8152602060048201526024808201527f4552433732313a207472616e7366657220746f20746865207a65726f206164646044820152637265737360e01b60648201526084016104b1565b6114026000826111ea565b6001600160a01b038316600090815260036020526040812080546001929061142b90849061225d565b90915550506001600160a01b0382166000908152600360205260408120805460019290611459908490612231565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b0386811691821790925591518493918716917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef91a4505050565b6114c38161180d565b600081815260066020526040902080546114dc906122a0565b1590506114fa5760008181526006602052604081206114fa91611cc9565b50565b600061150983836118a8565b9392505050565b600061150983836119bf565b61152784848461131a565b61153384848484611a0e565b6108425760405162461bcd60e51b81526004016104b190612165565b606061155a826111cd565b6115be5760405162461bcd60e51b815260206004820152602f60248201527f4552433732314d657461646174613a2055524920717565727920666f72206e6f60448201526e3732bc34b9ba32b73a103a37b5b2b760891b60648201526084016104b1565b60006115d560408051602081019091526000815290565b905060008151116115f55760405180602001604052806000815250611509565b806115ff84611b1b565b6040516020016116109291906120a2565b6040516020818303038152906040529392505050565b60006115098383611c35565b60018160000160008282546116479190612231565b909155505050565b6001600160a01b0382166116a55760405162461bcd60e51b815260206004820181905260248201527f4552433732313a206d696e7420746f20746865207a65726f206164647265737360448201526064016104b1565b6116ae816111cd565b156116fb5760405162461bcd60e51b815260206004820152601c60248201527f4552433732313a20746f6b656e20616c7265616479206d696e7465640000000060448201526064016104b1565b6001600160a01b0382166000908152600360205260408120805460019290611724908490612231565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b03861690811790915590518392907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908290a45050565b61178b826111cd565b6117ee5760405162461bcd60e51b815260206004820152602e60248201527f45524337323155524953746f726167653a2055524920736574206f66206e6f6e60448201526d32bc34b9ba32b73a103a37b5b2b760911b60648201526084016104b1565b600082815260066020908152604090912082516105e792840190611d03565b600061181882610848565b90506118256000836111ea565b6001600160a01b038116600090815260036020526040812080546001929061184e90849061225d565b909155505060008281526002602052604080822080546001600160a01b0319169055518391906001600160a01b038416907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908390a45050565b600081815260018301602052604081205480156119b55760006118cc60018361225d565b85549091506000906118e09060019061225d565b9050600086600001828154811061190757634e487b7160e01b600052603260045260246000fd5b906000526020600020015490508087600001848154811061193857634e487b7160e01b600052603260045260246000fd5b60009182526020808320909101929092558281526001890190915260409020849055865487908061197957634e487b7160e01b600052603160045260246000fd5b600190038181906000526020600020016000905590558660010160008781526020019081526020016000206000905560019450505050506103b1565b60009150506103b1565b6000818152600183016020526040812054611a06575081546001818101845560008481526020808220909301849055845484825282860190935260409020919091556103b1565b5060006103b1565b60006001600160a01b0384163b15611b1057604051630a85bd0160e11b81526001600160a01b0385169063150b7a0290611a529033908990889088906004016120d1565b602060405180830381600087803b158015611a6c57600080fd5b505af1925050508015611a9c575060408051601f3d908101601f19168201909252611a9991810190612021565b60015b611af6573d808015611aca576040519150601f19603f3d011682016040523d82523d6000602084013e611acf565b606091505b508051611aee5760405162461bcd60e51b81526004016104b190612165565b805181602001fd5b6001600160e01b031916630a85bd0160e11b149050610c38565b506001949350505050565b606081611b3f5750506040805180820190915260018152600360fc1b602082015290565b8160005b8115611b695780611b53816122d5565b9150611b629050600a83612249565b9150611b43565b60008167ffffffffffffffff811115611b9257634e487b7160e01b600052604160045260246000fd5b6040519080825280601f01601f191660200182016040528015611bbc576020820181803683370190505b5090505b8415610c3857611bd160018361225d565b9150611bde600a866122f0565b611be9906030612231565b60f81b818381518110611c0c57634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a905350611c2e600a86612249565b9450611bc0565b81546000908210611c935760405162461bcd60e51b815260206004820152602260248201527f456e756d657261626c655365743a20696e646578206f7574206f6620626f756e604482015261647360f01b60648201526084016104b1565b826000018281548110611cb657634e487b7160e01b600052603260045260246000fd5b9060005260206000200154905092915050565b508054611cd5906122a0565b6000825580601f10611ce5575050565b601f0160209004906000526020600020908101906114fa9190611d87565b828054611d0f906122a0565b90600052602060002090601f016020900481019282611d315760008555611d77565b82601f10611d4a57805160ff1916838001178555611d77565b82800160010185558215611d77579182015b82811115611d77578251825591602001919060010190611d5c565b50611d83929150611d87565b5090565b5b80821115611d835760008155600101611d88565b600067ffffffffffffffff80841115611db757611db7612330565b604051601f8501601f19908116603f01168101908282118183101715611ddf57611ddf612330565b81604052809350858152868686011115611df857600080fd5b858560208301376000602087830101525050509392505050565b600060208284031215611e23578081fd5b813561150981612346565b600060208284031215611e3f578081fd5b815161150981612346565b60008060408385031215611e5c578081fd5b8235611e6781612346565b91506020830135611e7781612346565b809150509250929050565b600080600060608486031215611e96578081fd5b8335611ea181612346565b92506020840135611eb181612346565b929592945050506040919091013590565b60008060008060808587031215611ed7578081fd5b8435611ee281612346565b93506020850135611ef281612346565b925060408501359150606085013567ffffffffffffffff811115611f14578182fd5b8501601f81018713611f24578182fd5b611f3387823560208401611d9c565b91505092959194509250565b60008060408385031215611f51578182fd5b8235611f5c81612346565b915060208301358015158114611e77578182fd5b600080600060608486031215611f84578283fd5b8335611f8f81612346565b9250602084013567ffffffffffffffff811115611faa578283fd5b8401601f81018613611fba578283fd5b611fc986823560208401611d9c565b925050604084013590509250925092565b60008060408385031215611fec578182fd5b8235611ff781612346565b946020939093013593505050565b600060208284031215612016578081fd5b81356115098161235b565b600060208284031215612032578081fd5b81516115098161235b565b60006020828403121561204e578081fd5b5035919050565b60008060408385031215612067578182fd5b50508035926020909101359150565b6000815180845261208e816020860160208601612274565b601f01601f19169290920160200192915050565b600083516120b4818460208801612274565b8351908301906120c8818360208801612274565b01949350505050565b6001600160a01b038581168252841660208201526040810183905260806060820181905260009061210490830184612076565b9695505050505050565b6020808252825182820181905260009190848201906040850190845b818110156121465783518352928401929184019160010161212a565b50909695505050505050565b6020815260006115096020830184612076565b60208082526032908201527f4552433732313a207472616e7366657220746f206e6f6e20455243373231526560408201527131b2b4bb32b91034b6b83632b6b2b73a32b960711b606082015260800190565b60208082526031908201527f4552433732313a207472616e736665722063616c6c6572206973206e6f74206f6040820152701ddb995c881b9bdc88185c1c1c9bdd9959607a1b606082015260800190565b8381526060602082015260006122216060830185612076565b9050826040830152949350505050565b6000821982111561224457612244612304565b500190565b6000826122585761225861231a565b500490565b60008282101561226f5761226f612304565b500390565b60005b8381101561228f578181015183820152602001612277565b838111156108425750506000910152565b600181811c908216806122b457607f821691505b60208210811415610d4257634e487b7160e01b600052602260045260246000fd5b60006000198214156122e9576122e9612304565b5060010190565b6000826122ff576122ff61231a565b500690565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052601260045260246000fd5b634e487b7160e01b600052604160045260246000fd5b6001600160a01b03811681146114fa57600080fd5b6001600160e01b0319811681146114fa57600080fdfea26469706673582212206c8325806b7575c3713a84ad8d8baaa6c578ceb9a92545ee71cad1866f872c8f64736f6c63430008040033";

    public static final String FUNC_ADMIN = "admin";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BURNITEM = "burnItem";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_GETCONTENTCREATORCOLLECTION = "getContentCreatorCollection";

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

    public static final String FUNC_TOKENTOCOLLECTION = "tokenToCollection";

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

    public static final Event MINTTOKEN_EVENT = new Event("MintToken", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected TK721(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TK721(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TK721(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TK721(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public List<MintTokenEventResponse> getMintTokenEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINTTOKEN_EVENT, transactionReceipt);
        ArrayList<MintTokenEventResponse> responses = new ArrayList<MintTokenEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MintTokenEventResponse typedResponse = new MintTokenEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.tokenURL = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.collectionId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MintTokenEventResponse> mintTokenEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, MintTokenEventResponse>() {
            @Override
            public MintTokenEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINTTOKEN_EVENT, log);
                MintTokenEventResponse typedResponse = new MintTokenEventResponse();
                typedResponse.log = log;
                typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.tokenURL = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.collectionId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<MintTokenEventResponse> mintTokenEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINTTOKEN_EVENT));
        return mintTokenEventFlowable(filter);
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

    public RemoteFunctionCall<TransactionReceipt> burnItem(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BURNITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getApproved(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getContentCreatorCollection(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCONTENTCREATORCOLLECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteFunctionCall<TransactionReceipt> mintItem(String receiver, String tokenURI, BigInteger collectionId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINTITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, receiver), 
                new org.web3j.abi.datatypes.Utf8String(tokenURI), 
                new org.web3j.abi.datatypes.generated.Uint256(collectionId)), 
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

    public RemoteFunctionCall<BigInteger> tokenToCollection(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKENTOCOLLECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteFunctionCall<TransactionReceipt> transferItem(String from, String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferTokenToAnotherCollection(BigInteger tokenId, BigInteger collectionId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERTOKENTOANOTHERCOLLECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.generated.Uint256(collectionId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TK721 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TK721(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TK721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TK721(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TK721 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TK721(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TK721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TK721(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TK721> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String tkCollectionsAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, tkCollectionsAddress)));
        return deployRemoteCall(TK721.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<TK721> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String tkCollectionsAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, tkCollectionsAddress)));
        return deployRemoteCall(TK721.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TK721> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String tkCollectionsAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, tkCollectionsAddress)));
        return deployRemoteCall(TK721.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TK721> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String tkCollectionsAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, tkCollectionsAddress)));
        return deployRemoteCall(TK721.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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

    public static class MintTokenEventResponse extends BaseEventResponse {
        public BigInteger tokenId;

        public String tokenURL;

        public BigInteger collectionId;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger tokenId;
    }
}
