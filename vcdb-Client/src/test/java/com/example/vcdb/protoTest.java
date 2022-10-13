package com.example.vcdb;

import org.example.vcdb.entity.Delete.DeleteCells;
import org.example.vcdb.entity.Delete.DeleteTable;
import org.example.vcdb.entity.Post.*;
import org.example.vcdb.entity.Put.CreateDB;
import org.example.vcdb.entity.Put.CreateTable;
import org.example.vcdb.executor.VCDBAdmin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class protoTest {



    @Test
    public void CommunicationTest(){
        VCDBAdmin vcdbAdmin=new VCDBAdmin();
        vcdbAdmin.createDB("123",null);
    }



}
