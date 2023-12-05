package com.openelements.dbch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlockChainTests {

    @Test
    void testEmptyCahin(){
        //given
        Chain chain = new Chain();

        //then
        Assertions.assertDoesNotThrow(() -> chain.verify());
    }

    @Test
    void testChainWithOneElement(){
        //given
        Chain chain = new Chain();
        String data = "Hello World";

        // when
        chain.addBlock(data);
        //then

        Assertions.assertDoesNotThrow(() -> chain.verify());
    }

    @Test
    void testChainWithManyElements(){
        //given
        Chain chain = new Chain();
        String data1 = "Hello World";
        String data2 = "Hello World1";
        String data3 = "Hello World2";
        String data4 = "Hello3 World";


        // when
        chain.addBlock(data1);
        chain.addBlock(data2);
        chain.addBlock(data3);
        chain.addBlock(data4);
        //then

        Assertions.assertDoesNotThrow(() -> chain.verify());
    }

    
}
