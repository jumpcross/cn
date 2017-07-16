package com.hc.cn;

import java.io.*;

/**
 * Created by Charlie on 2017-07-14.
 */
public class Test {
    static String scriptName = "test.vbs";
    public static void generateScript() throws IOException{
        File file=new File("D:/"+scriptName);
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,false);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Set WshShell = CreateObject (\"WScript.Shell\") \r\n").
                append("WshShell.Run(\"D:\\ABBYYFineReader\\FineReaderPortable.exe\")\r\n").
                append("WScript.Sleep(5000)\r\n")
                .append("      WshShell.SendKeys \"^o\" \r\n")
                .append("  WScript.Sleep(1000) \r\n")
                .append("WshShell.SendKeys \"charlie.pdf\" \r\n")
                .append(" WScript.Sleep(1000) \r\n")
                .append(" WshShell.SendKeys \"%o\" \r\n")
                .append("WScript.Sleep(25000) \r\n")
                .append(" WshShell.SendKeys \"^s\"\r\n")
                .append("WScript.Sleep(1000) \r\n")
                .append("WshShell.SendKeys \"%s\"\r\n")
                .append(" WshShell.SendKeys \"{enter}\"\r\n")
                .append("WScript.Sleep(5000) \r\n")
                .append("  WshShell.SendKeys \"%{F4}\"\r\n");
            out.write(stringBuffer.toString().getBytes("utf-8"));
            out.flush();
            out.close();
    }
    public static void main(String[] args) {
      /*  try {
            generateScript();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec("powershell  D:/"+scriptName);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
}}
