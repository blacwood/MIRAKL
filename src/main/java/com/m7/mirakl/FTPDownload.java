package com.m7.mirakl;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;

import java.io.*;

/**
 * Created by Manu on 1/29/2017.
 */
public class FTPDownload {

    private static String hostName = "blacwood.com";
    private static String userName = "bigname@blacwood.com";
    private static String password = "envelopes5300!";
    private static String remoteFileLocation = "bigname/mirakl/import/product/";
    private static String remoteSuccessLocation = "processed/success/";
    private static String remoteErrorLocation = "processed/error/";

    public static void main(String[] args) {
        listFiles();
    }

    public static void listFiles() {
        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(hostName, 21);
            ftpClient.login(userName, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            FTPFile[] files = ftpClient.listFiles(remoteFileLocation, new FTPFileFilter() {

                public boolean accept(FTPFile ftpFile) {
                    return ftpFile.getName().endsWith(".csv");
                }
            });
            for(FTPFile file : files) {
                System.out.println(file.getName());
                ftpClient.rename(remoteFileLocation + file.getName(), remoteFileLocation + remoteSuccessLocation + file.getName());
            }
            /*// APPROACH #1: using retrieveFile(String, OutputStream)
            String remoteFile1 = "/test/video.mp4";
            File downloadFile1 = new File("D:/Downloads/video.mp4");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();

            if (success) {
                System.out.println("File #1 has been downloaded successfully.");
            }

            // APPROACH #2: using InputStream retrieveFileStream(String)
            String remoteFile2 = "/test/song.mp3";
            File downloadFile2 = new File("D:/Downloads/song.mp3");
            OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
            byte[] bytesArray = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(bytesArray)) != -1) {
                outputStream2.write(bytesArray, 0, bytesRead);
            }

            success = ftpClient.completePendingCommand();
            if (success) {
                System.out.println("File #2 has been downloaded successfully.");
            }
            outputStream2.close();
            inputStream.close();*/

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
