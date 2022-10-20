package com.vincent.web3j_demo.contract;

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
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint192;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint64;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
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
 * <p>Generated with web3j version 4.8.9.
 */
@SuppressWarnings("rawtypes")
public class RequesterAuthorizerWithAirnode extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC_INDEFINITE_WHITELISTER_ROLE_DESCRIPTION = "INDEFINITE_WHITELISTER_ROLE_DESCRIPTION";

    public static final String FUNC_WHITELIST_EXPIRATION_EXTENDER_ROLE_DESCRIPTION = "WHITELIST_EXPIRATION_EXTENDER_ROLE_DESCRIPTION";

    public static final String FUNC_WHITELIST_EXPIRATION_SETTER_ROLE_DESCRIPTION = "WHITELIST_EXPIRATION_SETTER_ROLE_DESCRIPTION";

    public static final String FUNC_ACCESSCONTROLREGISTRY = "accessControlRegistry";

    public static final String FUNC_ADMINROLEDESCRIPTION = "adminRoleDescription";

    public static final String FUNC_AIRNODETOENDPOINTIDTOREQUESTERTOSETTERTOINDEFINITEWHITELISTSTATUS = "airnodeToEndpointIdToRequesterToSetterToIndefiniteWhitelistStatus";

    public static final String FUNC_AIRNODETOENDPOINTIDTOREQUESTERTOWHITELISTSTATUS = "airnodeToEndpointIdToRequesterToWhitelistStatus";

    public static final String FUNC_DERIVEADMINROLE = "deriveAdminRole";

    public static final String FUNC_DERIVEINDEFINITEWHITELISTERROLE = "deriveIndefiniteWhitelisterRole";

    public static final String FUNC_DERIVEWHITELISTEXPIRATIONEXTENDERROLE = "deriveWhitelistExpirationExtenderRole";

    public static final String FUNC_DERIVEWHITELISTEXPIRATIONSETTERROLE = "deriveWhitelistExpirationSetterRole";

    public static final String FUNC_EXTENDWHITELISTEXPIRATION = "extendWhitelistExpiration";

    public static final String FUNC_ISAUTHORIZED = "isAuthorized";

    public static final String FUNC_ISAUTHORIZEDV0 = "isAuthorizedV0";

    public static final String FUNC_MULTICALL = "multicall";

    public static final String FUNC_REVOKEINDEFINITEWHITELISTSTATUS = "revokeIndefiniteWhitelistStatus";

    public static final String FUNC_SETINDEFINITEWHITELISTSTATUS = "setIndefiniteWhitelistStatus";

    public static final String FUNC_SETWHITELISTEXPIRATION = "setWhitelistExpiration";

    public static final Event EXTENDEDWHITELISTEXPIRATION_EVENT = new Event("ExtendedWhitelistExpiration", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event REVOKEDINDEFINITEWHITELISTSTATUS_EVENT = new Event("RevokedIndefiniteWhitelistStatus", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>() {}, new TypeReference<Uint192>() {}));
    ;

    public static final Event SETINDEFINITEWHITELISTSTATUS_EVENT = new Event("SetIndefiniteWhitelistStatus", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}, new TypeReference<Uint192>() {}));
    ;

    public static final Event SETWHITELISTEXPIRATION_EVENT = new Event("SetWhitelistExpiration", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bytes32>() {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected RequesterAuthorizerWithAirnode(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RequesterAuthorizerWithAirnode(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RequesterAuthorizerWithAirnode(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RequesterAuthorizerWithAirnode(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ExtendedWhitelistExpirationEventResponse> getExtendedWhitelistExpirationEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EXTENDEDWHITELISTEXPIRATION_EVENT, transactionReceipt);
        ArrayList<ExtendedWhitelistExpirationEventResponse> responses = new ArrayList<ExtendedWhitelistExpirationEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ExtendedWhitelistExpirationEventResponse typedResponse = new ExtendedWhitelistExpirationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.airnode = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.requester = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.endpointId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.expiration = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExtendedWhitelistExpirationEventResponse> extendedWhitelistExpirationEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ExtendedWhitelistExpirationEventResponse>() {
            @Override
            public ExtendedWhitelistExpirationEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EXTENDEDWHITELISTEXPIRATION_EVENT, log);
                ExtendedWhitelistExpirationEventResponse typedResponse = new ExtendedWhitelistExpirationEventResponse();
                typedResponse.log = log;
                typedResponse.airnode = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.requester = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.endpointId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.expiration = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExtendedWhitelistExpirationEventResponse> extendedWhitelistExpirationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXTENDEDWHITELISTEXPIRATION_EVENT));
        return extendedWhitelistExpirationEventFlowable(filter);
    }

    public List<RevokedIndefiniteWhitelistStatusEventResponse> getRevokedIndefiniteWhitelistStatusEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REVOKEDINDEFINITEWHITELISTSTATUS_EVENT, transactionReceipt);
        ArrayList<RevokedIndefiniteWhitelistStatusEventResponse> responses = new ArrayList<RevokedIndefiniteWhitelistStatusEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RevokedIndefiniteWhitelistStatusEventResponse typedResponse = new RevokedIndefiniteWhitelistStatusEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.airnode = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.requester = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.setter = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.endpointId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.indefiniteWhitelistCount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RevokedIndefiniteWhitelistStatusEventResponse> revokedIndefiniteWhitelistStatusEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RevokedIndefiniteWhitelistStatusEventResponse>() {
            @Override
            public RevokedIndefiniteWhitelistStatusEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REVOKEDINDEFINITEWHITELISTSTATUS_EVENT, log);
                RevokedIndefiniteWhitelistStatusEventResponse typedResponse = new RevokedIndefiniteWhitelistStatusEventResponse();
                typedResponse.log = log;
                typedResponse.airnode = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.requester = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.setter = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.endpointId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.indefiniteWhitelistCount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RevokedIndefiniteWhitelistStatusEventResponse> revokedIndefiniteWhitelistStatusEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REVOKEDINDEFINITEWHITELISTSTATUS_EVENT));
        return revokedIndefiniteWhitelistStatusEventFlowable(filter);
    }

    public List<SetIndefiniteWhitelistStatusEventResponse> getSetIndefiniteWhitelistStatusEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETINDEFINITEWHITELISTSTATUS_EVENT, transactionReceipt);
        ArrayList<SetIndefiniteWhitelistStatusEventResponse> responses = new ArrayList<SetIndefiniteWhitelistStatusEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SetIndefiniteWhitelistStatusEventResponse typedResponse = new SetIndefiniteWhitelistStatusEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.airnode = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.requester = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.endpointId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.status = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.indefiniteWhitelistCount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SetIndefiniteWhitelistStatusEventResponse> setIndefiniteWhitelistStatusEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SetIndefiniteWhitelistStatusEventResponse>() {
            @Override
            public SetIndefiniteWhitelistStatusEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SETINDEFINITEWHITELISTSTATUS_EVENT, log);
                SetIndefiniteWhitelistStatusEventResponse typedResponse = new SetIndefiniteWhitelistStatusEventResponse();
                typedResponse.log = log;
                typedResponse.airnode = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.requester = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.endpointId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.status = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.indefiniteWhitelistCount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SetIndefiniteWhitelistStatusEventResponse> setIndefiniteWhitelistStatusEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SETINDEFINITEWHITELISTSTATUS_EVENT));
        return setIndefiniteWhitelistStatusEventFlowable(filter);
    }

    public List<SetWhitelistExpirationEventResponse> getSetWhitelistExpirationEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETWHITELISTEXPIRATION_EVENT, transactionReceipt);
        ArrayList<SetWhitelistExpirationEventResponse> responses = new ArrayList<SetWhitelistExpirationEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SetWhitelistExpirationEventResponse typedResponse = new SetWhitelistExpirationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.airnode = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.requester = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.endpointId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.expiration = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SetWhitelistExpirationEventResponse> setWhitelistExpirationEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SetWhitelistExpirationEventResponse>() {
            @Override
            public SetWhitelistExpirationEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SETWHITELISTEXPIRATION_EVENT, log);
                SetWhitelistExpirationEventResponse typedResponse = new SetWhitelistExpirationEventResponse();
                typedResponse.log = log;
                typedResponse.airnode = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.requester = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.endpointId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.expiration = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SetWhitelistExpirationEventResponse> setWhitelistExpirationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SETWHITELISTEXPIRATION_EVENT));
        return setWhitelistExpirationEventFlowable(filter);
    }

    public RemoteFunctionCall<String> INDEFINITE_WHITELISTER_ROLE_DESCRIPTION() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_INDEFINITE_WHITELISTER_ROLE_DESCRIPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> WHITELIST_EXPIRATION_EXTENDER_ROLE_DESCRIPTION() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_WHITELIST_EXPIRATION_EXTENDER_ROLE_DESCRIPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> WHITELIST_EXPIRATION_SETTER_ROLE_DESCRIPTION() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_WHITELIST_EXPIRATION_SETTER_ROLE_DESCRIPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> accessControlRegistry() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ACCESSCONTROLREGISTRY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> adminRoleDescription() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ADMINROLEDESCRIPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> airnodeToEndpointIdToRequesterToSetterToIndefiniteWhitelistStatus(String airnode, byte[] endpointId, String requester, String setter) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AIRNODETOENDPOINTIDTOREQUESTERTOSETTERTOINDEFINITEWHITELISTSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, airnode), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpointId), 
                new org.web3j.abi.datatypes.Address(160, requester), 
                new org.web3j.abi.datatypes.Address(160, setter)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Tuple2<BigInteger, BigInteger>> airnodeToEndpointIdToRequesterToWhitelistStatus(String airnode, byte[] endpointId, String requester) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AIRNODETOENDPOINTIDTOREQUESTERTOWHITELISTSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, airnode), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpointId), 
                new org.web3j.abi.datatypes.Address(160, requester)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint64>() {}, new TypeReference<Uint192>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, BigInteger>>(function,
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<byte[]> deriveAdminRole(String airnode) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DERIVEADMINROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, airnode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> deriveIndefiniteWhitelisterRole(String airnode) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DERIVEINDEFINITEWHITELISTERROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, airnode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> deriveWhitelistExpirationExtenderRole(String airnode) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DERIVEWHITELISTEXPIRATIONEXTENDERROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, airnode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> deriveWhitelistExpirationSetterRole(String airnode) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DERIVEWHITELISTEXPIRATIONSETTERROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, airnode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> extendWhitelistExpiration(String airnode, byte[] endpointId, String requester, BigInteger expirationTimestamp) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXTENDWHITELISTEXPIRATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, airnode), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpointId), 
                new org.web3j.abi.datatypes.Address(160, requester), 
                new org.web3j.abi.datatypes.generated.Uint64(expirationTimestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isAuthorized(String airnode, byte[] endpointId, String requester) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISAUTHORIZED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, airnode), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpointId), 
                new org.web3j.abi.datatypes.Address(160, requester)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isAuthorizedV0(byte[] requestId, String airnode, byte[] endpointId, String sponsor, String requester) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISAUTHORIZEDV0, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(requestId), 
                new org.web3j.abi.datatypes.Address(160, airnode), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpointId), 
                new org.web3j.abi.datatypes.Address(160, sponsor), 
                new org.web3j.abi.datatypes.Address(160, requester)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> multicall(List<byte[]> data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MULTICALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(data, org.web3j.abi.datatypes.DynamicBytes.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> revokeIndefiniteWhitelistStatus(String airnode, byte[] endpointId, String requester, String setter) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REVOKEINDEFINITEWHITELISTSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, airnode), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpointId), 
                new org.web3j.abi.datatypes.Address(160, requester), 
                new org.web3j.abi.datatypes.Address(160, setter)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setIndefiniteWhitelistStatus(String airnode, byte[] endpointId, String requester, Boolean status) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETINDEFINITEWHITELISTSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, airnode), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpointId), 
                new org.web3j.abi.datatypes.Address(160, requester), 
                new org.web3j.abi.datatypes.Bool(status)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setWhitelistExpiration(String airnode, byte[] endpointId, String requester, BigInteger expirationTimestamp) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETWHITELISTEXPIRATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, airnode), 
                new org.web3j.abi.datatypes.generated.Bytes32(endpointId), 
                new org.web3j.abi.datatypes.Address(160, requester), 
                new org.web3j.abi.datatypes.generated.Uint64(expirationTimestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static RequesterAuthorizerWithAirnode load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RequesterAuthorizerWithAirnode(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RequesterAuthorizerWithAirnode load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RequesterAuthorizerWithAirnode(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RequesterAuthorizerWithAirnode load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RequesterAuthorizerWithAirnode(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RequesterAuthorizerWithAirnode load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RequesterAuthorizerWithAirnode(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class ExtendedWhitelistExpirationEventResponse extends BaseEventResponse {
        public String airnode;

        public String requester;

        public String sender;

        public byte[] endpointId;

        public BigInteger expiration;
    }

    public static class RevokedIndefiniteWhitelistStatusEventResponse extends BaseEventResponse {
        public String airnode;

        public String requester;

        public String setter;

        public byte[] endpointId;

        public String sender;

        public BigInteger indefiniteWhitelistCount;
    }

    public static class SetIndefiniteWhitelistStatusEventResponse extends BaseEventResponse {
        public String airnode;

        public String requester;

        public String sender;

        public byte[] endpointId;

        public Boolean status;

        public BigInteger indefiniteWhitelistCount;
    }

    public static class SetWhitelistExpirationEventResponse extends BaseEventResponse {
        public String airnode;

        public String requester;

        public String sender;

        public byte[] endpointId;

        public BigInteger expiration;
    }
}
