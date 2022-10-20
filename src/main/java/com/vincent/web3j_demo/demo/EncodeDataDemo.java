package com.vincent.web3j_demo.demo;

import org.web3j.abi.DefaultFunctionEncoder;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author vincent
 * create at 2022/10/20
 * Description
 **/
public class EncodeDataDemo {

    /**
     * encode data format(string,uint64,array[string],array[uint64])
     *
     * in solidity it can be decode like:abi.decode(
     *       message_,
     *       (string, uint64, string[], uint64[])
     *     );
     */
    public String encodeData() {
        List<Utf8String> strings = new ArrayList<>();
        List<Uint64> ints = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            strings.add(new Utf8String("utf8String-" + i));
            ints.add(new Uint64(i));
        }
        List<Type> types = new ArrayList<>();
        types.add(new Utf8String("data1"));
        types.add(new Uint64(System.currentTimeMillis()));
        types.add(new DynamicArray(Utf8String.class, strings));
        types.add(new DynamicArray(Uint64.class, ints));
        return new DefaultFunctionEncoder().encodeParameters(types);
    }
}
