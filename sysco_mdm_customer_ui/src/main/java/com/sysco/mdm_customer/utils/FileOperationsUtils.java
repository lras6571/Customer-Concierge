package com.sysco.mdm_customer.utils;

import com.syscolab.qe.core.common.LoggerUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOperationsUtils {

    private FileOperationsUtils(){
    }

    public static String readFileToString(String filePath, String fileName) {
        try {
            StringBuilder data = new StringBuilder();
            File myObj = new File(filePath + fileName);
            Scanner myReader = new Scanner(myObj);

            while(myReader.hasNextLine()) {
                data.append(myReader.nextLine());
            }

            myReader.close();
            return data.toString();
        } catch (FileNotFoundException var5) {
            LoggerUtil.logERROR("Filename not found under : " + filePath + fileName, var5);
            return null;
        }
    }

}
